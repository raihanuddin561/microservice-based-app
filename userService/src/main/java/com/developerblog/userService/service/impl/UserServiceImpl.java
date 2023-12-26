package com.developerblog.userService.service.impl;

import com.developerblog.userService.entity.UserEntity;
import com.developerblog.userService.exceptions.UserCreationException;
import com.developerblog.userService.model.request.UserRequestModel;
import com.developerblog.userService.model.response.UserResponseModel;
import com.developerblog.userService.repository.UserRepository;
import com.developerblog.userService.service.UserService;
import com.developerblog.userService.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.developerblog.userService.constants.ErrorMessages.USER_CREATION_DATA_INTEGRITY_ERROR;
import static com.developerblog.userService.constants.ErrorMessages.USER_CREATION_UNEXPECTED_ERROR;

/**
 * implementation of userService interface
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperUtils mapper;

    /**
     * method for creating user
     *
     * @param requestModel UserRequestModel
     * @return UserResponseModel
     */
    @Override
    public UserResponseModel createUser(UserRequestModel requestModel) {
        ModelMapper modelMapper = mapper.initMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(requestModel, UserEntity.class);
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setPassword(requestModel.getPassword());
        try {
            UserEntity savedUserEntity = userRepository.save(userEntity);
            return modelMapper.map(savedUserEntity, UserResponseModel.class);
        } catch (DataIntegrityViolationException ex) {
            throw new UserCreationException(USER_CREATION_DATA_INTEGRITY_ERROR);
        } catch (Exception ex) {
            throw new UserCreationException(USER_CREATION_UNEXPECTED_ERROR);
        }
    }
}
