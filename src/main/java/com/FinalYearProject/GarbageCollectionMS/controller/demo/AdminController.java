package com.FinalYearProject.GarbageCollectionMS.controller.demo;

import com.FinalYearProject.GarbageCollectionMS.dto.GarbageBinDTO;
import com.FinalYearProject.GarbageCollectionMS.entity.GarbageBin;
import com.FinalYearProject.GarbageCollectionMS.service.GarbageBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {
    @Autowired
    private GarbageBinService garbageBinService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get(){
        return "GET::admin controller";
    }

    @PostMapping("/garbageBin/add")
    @PreAuthorize("hasAuthority('admin:create')")
    public GarbageBin addGarbageBin(@RequestBody GarbageBinDTO garbageBinDTO){
        return garbageBinService.addBinDetails(garbageBinDTO);
        //"POST::admin controller";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put(){
        return "PUT::admin controller";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public String delete(){
        return "DELETE::admin controller";
    }
}
