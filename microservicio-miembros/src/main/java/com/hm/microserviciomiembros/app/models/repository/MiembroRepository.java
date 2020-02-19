package com.hm.microserviciomiembros.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.hm.commonsmiembros.models.entity.Miembro;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
public interface MiembroRepository extends CrudRepository<Miembro, Long> {

}
