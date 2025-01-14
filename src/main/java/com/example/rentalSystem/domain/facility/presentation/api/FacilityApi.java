package com.example.rentalSystem.domain.facility.presentation.api;

import com.example.rentalSystem.domain.facility.dto.request.CreateFacilityRequestDto;
import com.example.rentalSystem.domain.facility.dto.request.UpdateFacilityRequestDto;
import com.example.rentalSystem.domain.facility.dto.response.FacilityResponse;
import com.example.rentalSystem.global.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Facility", description = "Facility API")
@RequestMapping(value = "/api/admin/facilities", produces = "application/json;charset=utf-8")
public interface FacilityApi {

  @Operation(summary = "[Admin 전용] 시설 생성하기")
  @PostMapping
  ApiResponse<?> createFacility(@RequestBody CreateFacilityRequestDto createFacilityRequestDto);

  @Operation(summary = "[Admin 전용] 시설 수정하기")
  @PutMapping("/{facilityId}")
  ApiResponse<?> updateFacility(@RequestBody UpdateFacilityRequestDto updateFacilityRequestDto, @PathVariable Long facilityId);

  @Operation(summary = "[Admin 전용] 시설 삭제하기")
  @DeleteMapping("/{facilityId}")
  ApiResponse<?> deleteFacility(@PathVariable Long facilityId);

  @Operation(summary = "[Admin 전용] 시설 전체 조회하기")
  @GetMapping
  ApiResponse<List<FacilityResponse>> getAllFacility();

}
