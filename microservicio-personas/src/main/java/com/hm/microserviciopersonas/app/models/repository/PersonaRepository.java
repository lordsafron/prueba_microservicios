package com.hm.microserviciopersonas.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.hm.microserviciopersonas.app.models.entity.Persona;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
