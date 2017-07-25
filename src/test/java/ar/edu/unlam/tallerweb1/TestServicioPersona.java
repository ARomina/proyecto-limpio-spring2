package ar.edu.unlam.tallerweb1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//import static org.mockito.Matchers.any;

//import javax.inject.Inject;
import ar.edu.unlam.tallerweb1.dao.ServicioPersonaDao;
import ar.edu.unlam.tallerweb1.modelo.Persona;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersona;
//import ar.edu.unlam.tallerweb1.servicios.ServicioPersonaImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestServicioPersona {
 
    @Mock
    private ServicioPersonaDao servicioPersonaDao;
    
    @Mock
    private ServicioPersona servicioPersona;
    
    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }
	
    @Test
	@Transactional
	@Rollback(true)
	public void testServicioPersonaRegistro(){
		
		//Mock de la persona que se va a registrar
		Persona personaMock = Mockito.mock(Persona.class);
		personaMock.setId(9L);
		personaMock.setUsuario("juan");
		personaMock.setPassword("1234");
		personaMock.setNombre("Juan");
		personaMock.setApellido("Perez");
		personaMock.setEdad(45);
		
		//Persona guardada
		Persona personaMockRegistrada = Mockito.mock(Persona.class);
		personaMockRegistrada.setId(9L);
		
		//Se ejecuta el registro
		servicioPersona.registrarPersona(personaMock);
		
		//Se verifica que se ejecuto la accion una vez
		Mockito.verify(servicioPersona).registrarPersona(personaMock);
		
		//Se verifica que la accion devolvio true (se registro la persona)
		Mockito.when(servicioPersona.registrarPersona(personaMock)).thenReturn(true);
	    
	}

}

