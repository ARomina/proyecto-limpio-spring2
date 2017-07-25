package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersona;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@RestController
public class ControladorRegistro {
	
	@Inject
	private ServicioPersona servicioPersona;
	
	@RequestMapping("/homePersona")
	public ModelAndView homePersona(@ModelAttribute("persona")Persona persona,
									HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioLogueado", request.getSession().getAttribute("usuarioLogueado"));
		if(request.getSession().getAttribute("usuarioLogueado") != null){
			Persona personaLogueada = (Persona)request.getSession().getAttribute("usuarioLogueado");
			List<Persona> listaPersonas = servicioPersona.listarPersonasMenosUsuarioLogueado(personaLogueada);
			modelo.put("listaPersonas", listaPersonas);
		}
			return new ModelAndView("homePersona", modelo);
			
	}
	
	@RequestMapping("/registro")
	public ModelAndView pantallaRegistro(){
		ModelMap modelo = new ModelMap();
		Persona persona = new Persona();
		modelo.put("persona", persona);
		return new ModelAndView("registro", modelo);
	}
	
	@RequestMapping(path = "/procesarRegistro", method = RequestMethod.POST)
	public ModelAndView procesarRegistro(@ModelAttribute("persona")Persona persona){
		ModelMap modelo = new ModelMap();
		if(servicioPersona.existePersona(persona) == null){
			Boolean resultado = servicioPersona.registrarPersona(persona);
			if(resultado){
				String mensaje = "¡El registro fue exitoso!";
				modelo.put("mensaje", mensaje);
				return new ModelAndView("mensajeRegistroEliminacion", modelo);
			}else{
				String mensaje = "No se pudo procesar el registro";
				modelo.put("mensaje", mensaje);
				return new ModelAndView("mensajeRegistroEliminacion", modelo);
			}
		}else{
			String mensaje = "Ese usuario ya existe";
			modelo.put("mensaje", mensaje);
			return new ModelAndView("mensaje", modelo);
		}
	}
	
	@RequestMapping("/loginPersona")
	public ModelAndView loginPersona(){
		ModelMap modelo = new ModelMap();
		Persona persona = new Persona();
		modelo.put("persona", persona);
		return new ModelAndView("loginPersona", modelo);
	}
	
	@RequestMapping(path = "/procesarLogin", method = RequestMethod.POST)
	public ModelAndView procesarLogin(@ModelAttribute("persona") Persona persona,
									  HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		if(servicioPersona.existePersona(persona) != null){
			Persona personaBuscada = servicioPersona.existePersona(persona);
			request.getSession().setAttribute("usuarioLogueado", personaBuscada);
			modelo.put("personaBuscada", personaBuscada);
			return new ModelAndView ("redirect:/homePersona", modelo);
		}else{
			String mensaje = "Usuario o contraseña incorrectos";
			modelo.put("mensaje", mensaje);
			return new ModelAndView("mensaje", modelo);
		}
	}
	
	@RequestMapping(path = "/verDatosUsuarioSesion")
	public ModelAndView verDatosUsuarioLogueado(HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		if(request.getSession().getAttribute("usuarioLogueado") != null){
			modelo.put("usuarioLogueado", request.getSession().getAttribute("usuarioLogueado"));
		}
			return new ModelAndView("verDatosUsuarioSesion", modelo);
		
	}
	
	@RequestMapping("/modificarPersona")
	public ModelAndView modificarPersona(@ModelAttribute("persona")Persona persona,
									HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioLogueado", request.getSession().getAttribute("usuarioLogueado"));
		return new ModelAndView("modificarPersona", modelo);
			
	}
	
	@RequestMapping(path = "/procesaModificar", method = RequestMethod.POST)
	public ModelAndView procesaModificar(@ModelAttribute("persona")Persona persona,
			                             HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioLogueado", request.getSession().getAttribute("usuarioLogueado"));
		Boolean resultado = servicioPersona.modificarPersona(persona);
		if(resultado){
			request.getSession().setAttribute("usuarioLogueado", persona);
			return new ModelAndView("redirect:/verDatosUsuarioSesion", modelo);
		}else{
			String mensaje = "No se pudieron modificar los datos";
			modelo.put("mensaje", mensaje);
			return new ModelAndView("mensaje", modelo);
		}
		
	}
	
	@RequestMapping("/eliminarPersona")
	public ModelAndView eliminarPersona(@ModelAttribute("persona")Persona persona,
									    HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioLogueado", request.getSession().getAttribute("usuarioLogueado"));
		return new ModelAndView("eliminarPersona", modelo);
			
	}
	
	@RequestMapping("/procesaEliminar")
	public ModelAndView procesaEliminar(@ModelAttribute("persona")Persona persona,
			                             HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		modelo.put("usuarioLogueado", request.getSession().getAttribute("usuarioLogueado"));
		Persona personaLogueada = (Persona)request.getSession().getAttribute("usuarioLogueado");
		Boolean resultado = servicioPersona.eliminarPersona(personaLogueada);
		if(resultado){
			request.getSession().removeAttribute("usuarioLogueado");
			String mensaje = "Su usuario ha sido eliminado exitosamente";
			modelo.put("mensaje", mensaje);
			return new ModelAndView("mensajeRegistroEliminacion", modelo);
		}else{
			String mensaje = "No se pudo eliminar el usuario";
			modelo.put("mensaje", mensaje);
			return new ModelAndView("mensajeEliminacionError", modelo);
		}
		
	}
	
	@RequestMapping("/salir")
	public ModelAndView salir(HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		request.getSession().removeAttribute("usuarioLogueado");
		return new ModelAndView("homePersona", modelo);
	}
	
}
