package com.bridgelabz.greetingsapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingNoteRepository extends JpaRepository<GreetingNote, Long> {
}
