package com.example.rentalSystem.domain.email.dto.response;

import com.example.rentalSystem.domain.email.entity.EMailVerification;

public record EmailVerificationResult(boolean authResult) {

    public static EmailVerificationResult of(boolean authResult) {
        return new EmailVerificationResult(authResult);
    }
}
