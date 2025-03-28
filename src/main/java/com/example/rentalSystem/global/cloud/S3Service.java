package com.example.rentalSystem.global.cloud;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.example.rentalSystem.domain.facility.entity.Facility;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;
    private final long expirationTimeMillis = 1000 * 60 * 5; // 5분 동안 유효한 URL

    public String generateFacilityS3Key(String fileName) {
        return "facility/" + UUID.randomUUID() + "_" + fileName;
    }

    public String generatePresignedUrlForPut(String fileName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
            new GeneratePresignedUrlRequest(bucket, fileName)
                .withMethod(HttpMethod.PUT)
                .withExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis));

        // Presigned URL 생성
        return amazonS3.generatePresignedUrl(generatePresignedUrlRequest).toString();
    }

    public List<String> generatePresignedUrlsForGet(Facility facility) {
        return facility.getImages().stream()
            .map(this::generatePresignedUrl)
            .collect(Collectors.toList());
    }

    private String generatePresignedUrl(String objectKey) {
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucket, objectKey)
            .withMethod(HttpMethod.GET)
            .withExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis));

        URL url = amazonS3.generatePresignedUrl(request);
        return url.toString();
    }

}
