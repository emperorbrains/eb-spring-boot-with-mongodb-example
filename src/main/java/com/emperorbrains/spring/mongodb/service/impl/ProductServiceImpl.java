package com.emperorbrains.spring.mongodb.service.impl;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emperorbrains.spring.mongodb.persistence.Product;
import com.emperorbrains.spring.mongodb.persistence.dto.GenericRes;
import com.emperorbrains.spring.mongodb.service.IProductService;
import com.emperorbrains.spring.mongodb.utils.EmperorBrainsService;
import com.emperorbrains.spring.mongodb.utils.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author RajuKhunt
 *
 */

@Slf4j
@Service
public class ProductServiceImpl extends EmperorBrainsService implements IProductService {

	@Override
	public ResponseEntity<?> getNoteById() {
		return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getNoteRepository().findAll()),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getNoteById(String noteId) {
		try {
			log.info("PocServiceImpl findById :- {}", noteId);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(checkNoteByIdExting(noteId)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> createNote(Product note) {
		try {
			log.info("data : - {}", note.toString());
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getNoteRepository().save(note)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> updateNote(String noteId, @Valid Product noteDetails) {
		try {
			Product note = checkNoteByIdExting(noteId);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getNoteRepository().save(note)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<?> deleteNote(String noteId) {
		try {
			Product note = checkNoteByIdExting(noteId);
			repoServ.getNoteRepository().delete(note);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success("Note Deleted"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	public Product checkNoteByIdExting(String noteId) throws Exception {
		return repoServ.getNoteRepository().findById(noteId).orElseThrow(() -> new Exception("Note Id Not Found"));
	}
}
