package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.PedidoRepository;
import com.api_vendinha.api.Infrastructure.repository.UserRepository;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.Pedido;
import com.api_vendinha.api.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            PedidoRepository pedidoRepository
    ) {
        this.userRepository = userRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = new User();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCpf_cnpj(userRequestDto.getCpf_cnpj());
        user.setIs_active(Boolean.TRUE);

        User savedUser = userRepository.save(user);

        List<Pedido> pedidos = userRequestDto.getPedidoRequestDtos().stream().map(dto -> {
            Pedido pedido = new Pedido();
            pedido.setUser(savedUser);
            pedido.setQtde(dto.getQtde());
            pedido.setPreco(dto.getPreco());

            return pedido;
        } ).collect(Collectors.toList());

        pedidoRepository.saveAll(pedidos);

        return getUserResponse(savedUser);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User userExist = userRepository.findById(id).orElseThrow();

        return getUserResponse(userExist);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        User userExist = userRepository.findById(id).orElseThrow();
        userExist.setName(userRequestDto.getName());
        userExist.setEmail(userRequestDto.getEmail());
        userExist.setPassword(userRequestDto.getPassword());
        userExist.setCpf_cnpj(userRequestDto.getCpf_cnpj());
        userExist.setIs_active(userRequestDto.getIs_active());

        userRepository.save(userExist);

        return getUserResponse(userExist);
    }

    @Override
    public UserResponseDto updateStatus(Long id, UserRequestDto userRequestDto) {
        User userExist = userRepository.findById(id).orElseThrow();
        userExist.setIs_active(userRequestDto.getIs_active());

        userRepository.save(userExist);

        return getUserResponse(userExist);
    }

    private UserResponseDto getUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setCpf_cnpj(user.getCpf_cnpj());
        userResponseDto.setIs_active(user.getIs_active());

        return userResponseDto;
    }
}
