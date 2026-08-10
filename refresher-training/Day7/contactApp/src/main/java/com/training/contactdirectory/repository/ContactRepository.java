package com.training.contactdirectory.repository;

import com.training.contactdirectory.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmailAddress(String emailAddress);
}
