package com.developerblog.userService.exceptions;

import com.developerblog.userService.ResponseType;
import com.developerblog.userService.constants.ErrorMessages;
import com.developerblog.userService.model.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<BaseResponse> userCreationExceptin(UserCreationException ex) {
        BaseResponse baseResponse = BaseResponse.builder()
                .responseType(ResponseType.FAILURE)
                .message(List.of(ErrorMessages.USER_CREATION_ERROR))
                .error(Map.of("message", ex.getLocalizedMessage()))
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
}
