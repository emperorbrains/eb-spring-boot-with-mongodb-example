package com.emperorbrains.spring.mongodb.listener;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author RajuKhunt
 * 
 */

@Component
public class SystemLoggedInUserAuditorAware implements AuditorAware<String> {

	@Autowired
	public HttpServletRequest httpServletReq;

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("ADMIN");
	}
}
