package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ServicioPersonaDao;
import ar.edu.unlam.tallerweb1.modelo.Persona;

@Service("servicioPersona")
@Transactional
public class ServicioPersonaImpl implements ServicioPersona {
	
	@Inject
	ServicioPersonaDao servicioPersonaDao;

	@Override
	public Boolean registrarPersona(Persona persona) {
		return servicioPersonaDao.registrarPersona(persona);
	}

	@Override
	public Persona existePersona(Persona persona) {
		return servicioPersonaDao.existePersona(persona);
	}
	
	@Override
	public List<Persona> listarPersonasMenosUsuarioLogueado(Persona persona){
		return servicioPersonaDao.listarPersonasMenosUsuarioLogueado(persona);
	}

	@Override
	public List<Persona> listarPersonas() {
		return servicioPersonaDao.listarPersonas();
	}

	@Override
	public Boolean modificarPersona(Persona persona) {
		return servicioPersonaDao.modificarPersona(persona);
	}

	@Override
	public Boolean eliminarPersona(Persona persona) {
		return servicioPersonaDao.eliminarPersona(persona);
	}

}
