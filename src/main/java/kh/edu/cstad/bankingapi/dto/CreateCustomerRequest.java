package kh.edu.cstad.bankingapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequest(

        @NotBlank (message = "Full name is required!!")
        String fullName,

        @NotBlank (message = "Gender is required!!")
        String gender,
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Phone Number is required")
        String phoneNumber,

        @NotBlank(message = "National card id is required!!")
        String nationalCardId,
        @NotBlank(message = "Customer Segment is required!!")
        String customerSegment

) {
}
