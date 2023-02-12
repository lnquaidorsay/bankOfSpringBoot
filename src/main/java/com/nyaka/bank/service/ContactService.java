package com.nyaka.bank.service;

import com.nyaka.bank.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto> {
    List<ContactDto> findAllByUserId(Integer userId);
}
