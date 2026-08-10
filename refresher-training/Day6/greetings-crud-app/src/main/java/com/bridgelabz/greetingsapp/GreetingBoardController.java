package com.bridgelabz.greetingsapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingBoardController {

    private final GreetingNoteRepository repository;

    public GreetingBoardController(GreetingNoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("notes", repository.findAll());
        return "index";
    }

    @PostMapping("/notes")
    public String create(@RequestParam String senderName, @RequestParam String note) {
        repository.save(new GreetingNote(senderName, note));
        return "redirect:/";
    }

    @GetMapping("/notes/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("note", repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found: " + id)));
        return "view";
    }

    @GetMapping("/notes/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("note", repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found: " + id)));
        return "edit";
    }

    @PostMapping("/notes/{id}")
    public String update(@PathVariable Long id, @RequestParam String senderName, @RequestParam String note) {
        GreetingNote existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found: " + id));
        existing.setSenderName(senderName);
        existing.setNote(note);
        repository.save(existing);
        return "redirect:/";
    }

    @PostMapping("/notes/{id}/delete")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
