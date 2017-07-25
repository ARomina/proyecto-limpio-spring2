package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Persona;

public interface ServicioPersonaDao {
	
	Boolean registrarPersona (Persona persona);
	Persona existePersona (Persona persona);
	List<Persona> listarPersonasMenosUsuarioLogueado(Persona persona);
	List<Persona> listarPersonas();
	Boolean modificarPersona(Persona persona);
	Boolean eliminarPersona(Persona persona);

}
