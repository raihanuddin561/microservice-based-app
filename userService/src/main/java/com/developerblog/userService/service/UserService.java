package com.developerblog.userService.service;

import com.developerblog.userService.model.request.UserRequestModel;
import com.developerblog.userService.model.response.UserResponseModel;

/**
 * userService interface
 */
public interface UserService {
    /**
     * method for creating user
     *
     * @param requestModel UserRequestModel
     * @return UserResponseModel
     */
    UserResponseModel createUser(UserRequestModel requestModel);
}
