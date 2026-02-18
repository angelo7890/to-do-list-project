package com.example.demo.mapper;

import com.example.demo.dto.request.RequestCreateUserDto;
import com.example.demo.dto.response.ResponsePaginationUserDto;
import com.example.demo.dto.response.ResponseUserDto;
import com.example.demo.enums.UserTypeEnum;
import com.example.demo.model.UserModel;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public class UserMapper {

    public UserModel toModel(RequestCreateUserDto dto) {
        return new UserModel(dto.name(), dto.email(), dto.password(), UserTypeEnum.USER);
    }

    public ResponseUserDto toDto(Optional<UserModel> user) {
        return user.map(userModel -> new ResponseUserDto(userModel.getName(), userModel.getEmail())).orElse(null);
    }

    public ResponsePaginationUserDto toPaginationDto(Page<UserModel> users) {
        List<ResponseUserDto> content = users.stream().map(
                userModel -> new ResponseUserDto(userModel.getName(), userModel.getEmail())
        ).toList();
        return new ResponsePaginationUserDto(content, users.getTotalPages(), users.getTotalElements(), users.getSize(), users.getNumber());
    }
}
