package com.FinalYearProject.GarbageCollectionMS.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private String firstName;
    private String lastName;
    private String nicNo;
    private String address;
    private String email;
    private String mobileNo;
    private String empNumber;
    private String licenceNo;
    private String password;

}
