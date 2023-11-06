package com.developerblog.userService.model;

import com.developerblog.userService.ResponseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {
    private ResponseType responseType;

    private Collection<String> message;

    private Object result;

    private Object error;

    private int code;
}
