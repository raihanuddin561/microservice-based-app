package com.developerblog.userService.service.impl;

import com.developerblog.userService.dto.UserDto;
import com.developerblog.userService.entity.UserEntity;
import com.developerblog.userService.model.request.UserRequestModel;
import com.developerblog.userService.model.response.UserResponseModel;
import com.developerblog.userService.repository.UserRepository;
import com.developerblog.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * implementation of userService interface
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    /**
     * method for creating user
     *
     * @param requestModel UserRequestModel
     * @return UserResponseModel
     */
    @Override
    public UserResponseModel createUser(UserRequestModel requestModel) {
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(requestModel, UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = mapper.map(userDto,UserEntity.class);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return mapper.map(savedUserEntity,UserResponseModel.class);
    }
}
