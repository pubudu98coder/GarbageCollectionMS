package com.FinalYearProject.GarbageCollectionMS.entity.users.Visible;

import com.FinalYearProject.GarbageCollectionMS.securityImplentation.User;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn
public class Admin extends User {
    private String adNo;
}
