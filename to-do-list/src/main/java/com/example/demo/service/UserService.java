package com.example.demo.service;

import com.example.demo.dto.request.RequestCreateUserDto;
import com.example.demo.dto.response.ResponsePaginationUserDto;
import com.example.demo.dto.response.ResponseUserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = new UserMapper();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(RequestCreateUserDto dto){
        var checkEmailExists = userRepository.findByEmail(dto.email());
        if (checkEmailExists != null){
            throw new RuntimeException("Email already exists");
        }
        userRepository.save(userMapper.toModel(dto));
    }

    public ResponseUserDto findById(Long id){
        var user = userRepository.findById(id);
        return userMapper.toDto(user);
    }

    public ResponsePaginationUserDto findAllUsers(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        var result = userRepository.findAll(pageable);
        return userMapper.toPaginationDto(result);
    }
}
