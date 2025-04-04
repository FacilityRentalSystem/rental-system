package com.example.rentalSystem.domain.member.controller;

import com.example.rentalSystem.domain.member.controller.dto.response.MemberInfoResponse;
import com.example.rentalSystem.domain.member.entity.CustomerDetails;
import com.example.rentalSystem.global.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "회원 정보 관련 API")
public interface MemberControllerDocs {

    ApiResponse<MemberInfoResponse> getMemberInfo(CustomerDetails customerDetails);
}
