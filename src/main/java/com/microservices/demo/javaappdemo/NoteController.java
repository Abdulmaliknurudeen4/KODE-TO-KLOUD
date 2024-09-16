package com.microservices.demo.javaappdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService; // Assuming you have a service layer for handling business logic

    @GetMapping("/notes")
    public String getNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        model.addAttribute("note", new Note()); // Used for form binding
        return "notes";
    }

    @PostMapping("/notes")
    public String createNote(@ModelAttribute Note note, RedirectAttributes redirectAttributes) {
        noteService.createNote(note);
        redirectAttributes.addFlashAttribute("message", "Note created successfully!");
        redirectAttributes.addFlashAttribute("alertType", "success");
        return "redirect:/notes";
    }

    @PostMapping("/notes/{id}")
    public String deleteNote(@PathVariable String id, RedirectAttributes redirectAttributes) {
        noteService.deleteNoteById(id);
        redirectAttributes.addFlashAttribute("message", "Note deleted successfully!");
        redirectAttributes.addFlashAttribute("alertType", "success");  // Add alert type
        return "redirect:/notes";
    }
}
