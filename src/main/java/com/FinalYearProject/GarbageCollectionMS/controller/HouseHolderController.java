package com.FinalYearProject.GarbageCollectionMS.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/houseHolder")
public class HouseHolderController {
    @PostMapping(value = "/add")
    public ResponseEntity saveHousHolder(){
        //[TODO]:complete controller class
    }

}
