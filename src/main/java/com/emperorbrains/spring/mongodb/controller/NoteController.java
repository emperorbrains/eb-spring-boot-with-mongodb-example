package com.emperorbrains.spring.mongodb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emperorbrains.spring.mongodb.persistence.Product;
import com.emperorbrains.spring.mongodb.service.IProductService;

/**
 * @author RajuKhunt Created by RajuKhunt on 10-Feb-2021
 */

@RestController
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	private IProductService noteService;

	@GetMapping("/")
	public ResponseEntity<?> getAllNotes() {
		return noteService.getNoteById();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getNoteById(@PathVariable(value = "id") String noteId) {
		return noteService.getNoteById(noteId);
	}

	@PostMapping("/")
	public ResponseEntity<?> createNote(@Valid @RequestBody Product note) {
		return noteService.createNote(note);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateNote(@PathVariable(value = "id") String noteId, @Valid @RequestBody Product noteDetails) {
		return noteService.updateNote(noteId, noteDetails);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") String noteId) {
		return noteService.deleteNote(noteId);
	}
}
