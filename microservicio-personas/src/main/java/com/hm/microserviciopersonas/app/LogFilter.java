package com.hm.microserviciopersonas.app;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hm.commonsmiembros.models.entity.LogTraza;
import com.hm.commonsutils.wrappers.MultiReadRequest;
import com.hm.commonsutils.wrappers.MultiReadResponse;
import com.hm.microserviciopersonas.app.models.repository.LogTrazaRepository;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Component
@Order(1)
public class LogFilter implements Filter {
	
	private static List<String> paths = Arrays.asList("/","asignar-miembros","eliminar-miembro");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);
	
	@Autowired
	private LogTrazaRepository logTrazaRepository;


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		MultiReadRequest wrapperRequest = new MultiReadRequest((HttpServletRequest) request);
		MultiReadResponse wrapperResponse = new MultiReadResponse((HttpServletResponse) response);
		StringBuilder builder = new StringBuilder();
		String respuesta = null;
		if ("/".equals(wrapperRequest.getRequestURI())
				|| wrapperRequest.getRequestURI().contains(paths.get(1))
				|| wrapperRequest.getRequestURI().contains(paths.get(2))) {
			wrapperRequest.getReader().lines()
			.forEach(l -> builder.append(l.replace("\t", "")));
			LOGGER.info("Request: " + builder.toString());
			
	        try {
	        	chain.doFilter(wrapperRequest, wrapperResponse);
	        	wrapperResponse.flushBuffer();
	        } finally {
	            byte[] copy = wrapperResponse.getCopy();
	            respuesta = new String(copy, response.getCharacterEncoding());
	            LOGGER.info("Respuesta: " + respuesta); // Do your logging job here. This is just a basic example.
	        }
	        logTrazaRepository.save(new LogTraza(wrapperRequest.getMethod(), wrapperRequest.getRequestURI(), builder.toString(), respuesta));
		} else {
			chain.doFilter(request, response);
		}
		
		
	}

}
