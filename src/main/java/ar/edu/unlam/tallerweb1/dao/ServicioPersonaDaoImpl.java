package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersona;

@Service("servicioPersonaDao")
@Transactional
public class ServicioPersonaDaoImpl implements ServicioPersonaDao {
	
	@Inject
	private SessionFactory session;

	@Override
	public Boolean registrarPersona(Persona persona) {
		session.getCurrentSession().save(persona);
		return true;
		
	}
	
	@Override
	public Persona existePersona(Persona persona){
		return (Persona) session.getCurrentSession()
				.createCriteria(Persona.class)
				.add(Restrictions.eq("usuario", persona.getUsuario()))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listarPersonas() {
		return session.getCurrentSession()
			   .createCriteria(Persona.class)
			   .list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listarPersonasMenosUsuarioLogueado(Persona persona) {
		return session.getCurrentSession()
			   .createCriteria(Persona.class)
			   .add(Restrictions.not(Restrictions.eq("id", persona.getId())))
			   .list();
	}

	@Override
	public Boolean modificarPersona(Persona persona) {
		session.getCurrentSession()
		.saveOrUpdate(persona);
		return true;
	}

	@Override
	public Boolean eliminarPersona(Persona persona) {
		session.getCurrentSession()
		.delete(persona);
		return true;
	}

}
