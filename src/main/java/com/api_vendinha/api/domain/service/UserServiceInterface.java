package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;

public interface UserServiceInterface {
    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto getUser(Long id);

    UserResponseDto update(Long id, UserRequestDto userRequestDto);

    UserResponseDto updateStatus(Long id, UserRequestDto userRequestDto);
}
