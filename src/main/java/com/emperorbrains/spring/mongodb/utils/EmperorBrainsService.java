package com.emperorbrains.spring.mongodb.utils;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.emperorbrains.spring.mongodb.repository.RepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author RajuKhunt
 *
 */

public class EmperorBrainsService {

	@Autowired
	public HttpServletRequest httpServletReq;

	@Autowired
	public RepositoryService repoServ;

	@Autowired
	public ObjectMapper mapper;

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public static boolean isNullOrEmptyOrNullValue(String str) {
		if (str != null && !str.isEmpty() && !str.equalsIgnoreCase("null"))
			return false;
		return true;
	}

	public Optional<Integer> getIntegerHeader(String name) throws Exception {
		String headerValue = httpServletReq.getHeader(name);

		if (isNullOrEmpty(headerValue))
			throw new Exception(name + " Not Found");

		return Optional.of(Integer.parseInt(headerValue));
	}

	public Optional<String> getStringrHeader(String name) throws Exception {
		String headerValue = httpServletReq.getHeader(name);

		if (isNullOrEmpty(headerValue))
			throw new Exception(name + " Not Found");

		return Optional.of(headerValue);
	}

	public String removeMultipleSpace(String e) {
		return e.trim().replaceAll("\\s+", " ");
	}
}
