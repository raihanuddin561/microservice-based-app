package com.developerblog.userService.controller;

import com.developerblog.userService.ResponseType;
import com.developerblog.userService.model.BaseResponse;
import com.developerblog.userService.model.request.UserRequestModel;
import com.developerblog.userService.model.response.UserResponseModel;
import com.developerblog.userService.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.developerblog.userService.constants.EndPoints.API_USER;
import static com.developerblog.userService.constants.EndPoints.STATUS;
import static com.developerblog.userService.constants.ResponseMessage.USER_CREATED_SUCCESS;

/**
 * User controller class
 */
@RestController
@RequestMapping(API_USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(STATUS)
    public String status() {
        return "working";
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createUser(
            @Valid @RequestBody UserRequestModel requestModel) {
        UserResponseModel userResponseModel = userService.createUser(requestModel);
        BaseResponse baseResponse = BaseResponse.builder()
                .responseType(ResponseType.SUCCESS)
                .code(HttpStatus.CREATED.value())
                .result(userResponseModel)
                .message(List.of(USER_CREATED_SUCCESS))
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
}
