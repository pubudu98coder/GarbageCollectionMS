package com.FinalYearProject.GarbageCollectionMS.controller.demo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
@CrossOrigin
public class UserController {
    @GetMapping
    public List<String> getUsers(){
        List<String> users= Arrays.asList("pubudu","lilanka");
        return users;
    }

}
