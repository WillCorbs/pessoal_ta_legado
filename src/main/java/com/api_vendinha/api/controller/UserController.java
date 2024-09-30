package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto salvar(@RequestBody UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(
            @PathVariable Long id
    ) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(
            @PathVariable Long id,
            @RequestBody UserRequestDto userRequestDto
    ) {
        return userService.update(id, userRequestDto);
    }

    @PutMapping("/{id}/status")
    public UserResponseDto updateStatus(
            @PathVariable Long id,
            @RequestBody UserRequestDto userRequestDto
    ) {
        return userService.updateStatus(id, userRequestDto);
    }
}
