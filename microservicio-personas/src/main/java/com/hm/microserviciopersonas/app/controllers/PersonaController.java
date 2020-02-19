package com.hm.microserviciopersonas.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hm.commonscapas.controllers.CommonController;
import com.hm.commonsmiembros.models.entity.Miembro;
import com.hm.commonsutils.exceptions.InconsistenciaException;
import com.hm.microserviciopersonas.app.models.entity.Persona;
import com.hm.microserviciopersonas.app.services.PersonaService;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@RestController
public class PersonaController extends CommonController<Persona, PersonaService> {

	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Persona persona, @PathVariable Long id) {
		Optional<Persona> o = service.findById(id);
		if (!(o.isPresent())) {
			return ResponseEntity.notFound().build();
		}
		
		Persona personaBd = o.get();
		
		personaBd.setNombre(persona.getNombre());
		personaBd.setApellido(persona.getApellido());
		personaBd.setDireccion(persona.getDireccion());
		personaBd.setFechaNacimiento(persona.getFechaNacimiento());
		personaBd.setEmail(persona.getEmail());
		personaBd.setTipoDocumento(persona.getTipoDocumento());
		personaBd.setNumeroDocumento(persona.getNumeroDocumento());
		personaBd.setProfesion(persona.getProfesion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personaBd));
	}
	
	@PutMapping("/{id}/asignar-miembros")
	public ResponseEntity<?> asignarAlumnos(@Valid @RequestBody List<Miembro> miembros, @PathVariable Long id){
		Optional<Persona> o = service.findById(id);
		Persona personaResponse = null;
		if (!(o.isPresent())) {
			return ResponseEntity.notFound().build();
		}
		Persona personaBd = o.get();
		miembros.forEach(m -> {
			personaBd.addMiembro(m);
		});
		try {
			personaResponse = service.save(personaBd);
		} catch (Exception ex) {
			throw new InconsistenciaException("Datos inconsistentes");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personaResponse));
	}
	
	@PutMapping("/{id}/eliminar-miembro")
	public ResponseEntity<?> eliminarAlumno(@Valid @RequestBody Miembro miembro, @PathVariable Long id){
		Optional<Persona> o = service.findById(id);
		Persona personaResponse = null;
		if (!(o.isPresent())) {
			return ResponseEntity.notFound().build();
		}
		Persona personaBd = o.get();
		
		personaBd.removeMiembro(miembro);
		
		try {
			personaResponse = service.save(personaBd);
		} catch (InconsistenciaException ex) {
			throw new InconsistenciaException("Datos inconsistentes");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personaResponse));
	}
}
