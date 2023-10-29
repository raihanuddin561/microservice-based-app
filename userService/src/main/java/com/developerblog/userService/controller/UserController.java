package com.developerblog.userService.controller;

import com.developerblog.userService.model.request.UserRequestModel;
import com.developerblog.userService.model.response.UserResponseModel;
import com.developerblog.userService.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.developerblog.userService.constants.EndPoints.*;

/**
 * User controller class
 */
@RestController
@RequestMapping(API_USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping(STATUS)
    public String status(){
        return "working";
    }
    @PostMapping
    public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel requestModel){
        return new ResponseEntity<>( userService.createUser(requestModel), HttpStatus.CREATED);
    }
}
