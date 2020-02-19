package com.hm.microserviciopersonas.app.services;

import org.springframework.stereotype.Service;

import com.hm.commonscapas.services.CommonServiceImpl;
import com.hm.microserviciopersonas.app.models.entity.Persona;
import com.hm.microserviciopersonas.app.models.repository.PersonaRepository;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@Service
public class PersonaServiceImpl extends CommonServiceImpl<Persona, PersonaRepository> implements PersonaService {

}
