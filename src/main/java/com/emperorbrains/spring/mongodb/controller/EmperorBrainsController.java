package com.emperorbrains.spring.mongodb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emperorbrains.spring.mongodb.persistence.dto.GenericRes;
import com.emperorbrains.spring.mongodb.utils.ResponseUtils;

/**
 * @author RajuKhunt
 * 
 */

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmperorBrainsController {

	@Autowired
	public HttpServletRequest httpServletReq;

	@GetMapping("/")
	public GenericRes<?> index() {
		return ResponseUtils.success("EmperorBrains Spring Boot With MongoDB Service is up and running");
	}
}
