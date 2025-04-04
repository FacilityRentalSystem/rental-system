package com.example.rentalSystem.domain.approval.controller.dto.request;

import com.example.rentalSystem.domain.rentalhistory.entity.RentalApplicationResult;
import io.swagger.v3.oas.annotations.media.Schema;

public record RegisterRentalResultRequest(
    @Schema(description = "대여 신청 결과", example = "PIC or PROFESSOR + _ + PERMITTED or DENIED")
    RentalApplicationResult rentalApplicationResult,
    @Schema(description = "사유", example = "거절시에만 전달됩니다.")
    String reason
) {

}
