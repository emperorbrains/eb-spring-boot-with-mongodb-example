package com.emperorbrains.spring.mongodb.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.emperorbrains.spring.mongodb.persistence.Product;

/**
 * @author RajuKhunt
 *
 */

public interface IProductService {

	/**
	 * @return Notes
	 */
	public ResponseEntity<?> getNoteById();

	/**
	 * @param noteId
	 * @return Note
	 */
	public ResponseEntity<?> getNoteById(String noteId);

	/**
	 * @param note
	 * @return
	 */
	public ResponseEntity<?> createNote(Product note);

	/**
	 * @param noteId
	 * @param noteDetails
	 * @return
	 */
	public ResponseEntity<?> updateNote(String noteId, @Valid Product noteDetails);

	/**
	 * @param noteId
	 * @return
	 */
	public ResponseEntity<?> deleteNote(String noteId);

}
