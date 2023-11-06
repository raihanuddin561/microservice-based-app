package com.developerblog.userService.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {
    private static ModelMapper mapper;

    public ModelMapper initMapper() {
        return mapper == null ? new ModelMapper() : mapper;
    }
}
