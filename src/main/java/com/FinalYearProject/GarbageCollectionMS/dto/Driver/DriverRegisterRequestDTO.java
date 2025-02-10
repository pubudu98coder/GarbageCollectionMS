package com.FinalYearProject.GarbageCollectionMS.dto.Driver;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record DriverRegisterRequestDTO(
        @NotNull(message = "First name is required")
        @NotEmpty(message = "First name is required")
        String firstName,
        @NotNull(message = "Last name is required")
        @NotEmpty(message = "Last name is required")
        String lastName,
        @NotNull(message = "NIC Number is required")
        @NotEmpty(message = "NIC Number is required")
        String nicNo,
        @NotNull(message = "Address is required")
        @NotEmpty(message = "Address is required")
        String address,
        @NotNull(message = "Email is required")
        @NotEmpty(message = "Email Number is required")
        String email,
        @NotNull(message = "Mobile Number is required")
        @NotEmpty(message = "Mobile Number is required")
        String mobileNo,
        @NotNull(message = "Password is required")
        @NotEmpty(message = "Password is required")
        String password,
        @NotNull(message = "Employee Number is required")
        @NotEmpty(message = "Employee Number is required")
        String empNumber,
        @NotNull(message = "Licence Number is required")
        @NotEmpty(message = "Licence Number is required")
        String licenceNo
) {
}
