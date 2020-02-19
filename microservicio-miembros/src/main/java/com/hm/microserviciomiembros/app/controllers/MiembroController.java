package com.hm.microserviciomiembros.app.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hm.commonscapas.controllers.CommonController;
import com.hm.commonscapas.services.CommonService;
import com.hm.commonsmiembros.models.entity.Miembro;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@RestController
public class MiembroController extends CommonController<Miembro, CommonService<Miembro>> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Miembro miembro, @PathVariable Long id) {
		Miembro miembroBd = null;
		Optional<Miembro> o = service.findById(id);
		
		if (!(o.isPresent())) {
			return ResponseEntity.notFound().build();
		}
		
		miembroBd = o.get();
		miembroBd.setNombre(miembro.getNombre());
		miembroBd.setApellido(miembro.getApellido());
		miembroBd.setFechaNacimiento(miembro.getFechaNacimiento());
		miembroBd.setNumeroDocumento(miembro.getNumeroDocumento());
		miembroBd.setTipoDocumento(miembro.getTipoDocumento());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(miembroBd));
	}

}
