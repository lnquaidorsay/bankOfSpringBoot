package com.nyaka.bank.service;

import com.nyaka.bank.dto.AuthenticationRequest;
import com.nyaka.bank.dto.AuthenticationResponse;
import com.nyaka.bank.dto.LightUserDto;
import com.nyaka.bank.dto.UserDto;

public interface UserService  extends AbstractService<UserDto>{
    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);

    AuthenticationResponse register(UserDto user);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    Integer update(LightUserDto userDto);
}
