package com.training.contactdirectory.service;

import com.training.contactdirectory.dto.ContactCreateRequest;
import com.training.contactdirectory.dto.ContactResponse;

import java.util.List;

public interface ContactService {

    ContactResponse createContact(ContactCreateRequest request);

    List<ContactResponse> getAllContacts();

    ContactResponse getContactById(Long id);
}
