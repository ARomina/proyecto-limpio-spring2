package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Persona;

public interface ServicioPersona {
	
	Boolean registrarPersona(Persona persona);
	Persona existePersona(Persona persona);
	List<Persona> listarPersonasMenosUsuarioLogueado(Persona persona);
	List<Persona> listarPersonas();
	Boolean modificarPersona(Persona persona);
	Boolean eliminarPersona(Persona persona);
	
}
