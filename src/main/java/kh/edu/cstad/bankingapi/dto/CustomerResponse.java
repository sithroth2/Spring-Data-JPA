package kh.edu.cstad.bankingapi.dto;

import lombok.Builder;

@Builder
public record CustomerResponse (
        Integer id,
        String fullName,
        String email,
        String phoneNumber,
        String gender
){}
