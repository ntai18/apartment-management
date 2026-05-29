package com.apartmentmanagement.features.profile.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Profile {
    Long id;
    Long accountId;
    String urlAvatar;
    String fullName;
    LocalDate birthDate;
    String bio;
}
