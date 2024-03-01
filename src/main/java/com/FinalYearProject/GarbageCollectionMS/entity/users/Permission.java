package com.FinalYearProject.GarbageCollectionMS.entity.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    SUPERVISOR_READ("management:read"),
    SUPERVISOR_UPDATE("management:update"),
    SUPERVISOR_CREATE("management:create"),
    SUPERVISOR_DELETE("management:delete"),
    HOUSEHOLDER_READ("house_holder:read"),
    HOUSEHOLDER_UPDATE("house_holder:update"),
    HOUSEHOLDER_CREATE("house_holder:create"),
    HOUSEHOLDER_DELETE("house_holder:delete"),
    DRIVER_READ("truck_driver:read"),
    DRIVER_UPDATE("truck_driver:update"),
    DRIVER_CREATE("truck_driver:create"),
    DRIVER_DELETE("truck_driver:delete"),
    ;

    private final String permission;
}
