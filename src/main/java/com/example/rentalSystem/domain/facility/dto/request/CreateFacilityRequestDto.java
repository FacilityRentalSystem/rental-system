package com.example.rentalSystem.domain.facility.dto.request;

import com.example.rentalSystem.domain.facility.entity.Facility;
import java.time.LocalTime;
import java.util.List;

public record CreateFacilityRequestDto(
    String name,
    Long capacity,
    String location,
    String chargeProfessor,
    List<String> supportFacilities,
    List<String> possibleDays,
    LocalTime startTime,
    LocalTime endTime,
    boolean isAvailable
    //이미지
) {

  public Facility toFacility() {
    return Facility.builder()
        .name(name)
        .capacity(capacity)
        .location(location)
        .chargeProfessor(chargeProfessor)
        .supportFacilities(supportFacilities)
        .possibleDays(possibleDays)
        .startTime(startTime)
        .endTime(endTime)
        .isAvailable(isAvailable)
        .build();
  }
}
