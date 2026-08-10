package com.training.contactdirectory.service;

import com.training.contactdirectory.dto.ContactCreateRequest;
import com.training.contactdirectory.dto.ContactResponse;
import com.training.contactdirectory.entity.ContactEntity;
import com.training.contactdirectory.exception.ContactNotFoundException;
import com.training.contactdirectory.exception.DuplicateContactException;
import com.training.contactdirectory.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ContactResponse createContact(ContactCreateRequest request) {
        if (contactRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new DuplicateContactException("Phone number already in use: " + request.getPhoneNumber());
        }
        if (contactRepository.existsByEmailAddress(request.getEmailAddress())) {
            throw new DuplicateContactException("Email address already in use: " + request.getEmailAddress());
        }

        ContactEntity entity = ContactEntity.builder()
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .emailAddress(request.getEmailAddress())
                .build();

        return toResponse(contactRepository.save(entity));
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ContactResponse getContactById(Long id) {
        ContactEntity entity = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("No contact found with id: " + id));
        return toResponse(entity);
    }

    private ContactResponse toResponse(ContactEntity entity) {
        return ContactResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .emailAddress(entity.getEmailAddress())
                .build();
    }
}
