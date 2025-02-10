package com.FinalYearProject.GarbageCollectionMS.securityImplentation.auth;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.config.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String nicNo;
    private String password;
    private String mobileNo;
    private Role role;

}
