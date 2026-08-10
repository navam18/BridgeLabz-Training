package com.training.contactdirectory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String emailAddress;
}
