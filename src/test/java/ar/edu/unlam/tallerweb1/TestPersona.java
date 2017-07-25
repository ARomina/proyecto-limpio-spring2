package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

//import org.hibernate.SessionFactory;
import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito.*; 
import org.mockito.Mockito;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Persona;

//public class testPersona extends SpringTest{
public class TestPersona{

	@Test
	@Transactional
	@Rollback(true)
	public void crearPersona(){
		
		//Creo un mock de la clase a testear
		Persona personaMock = Mockito.mock(Persona.class);
		
		//y lo que pasa al hacer los get
		Mockito.when(personaMock.getId()).thenReturn(8L);
		Mockito.when(personaMock.getUsuario()).thenReturn("luciana");
		Mockito.when(personaMock.getPassword()).thenReturn("1234");
		Mockito.when(personaMock.getNombre()).thenReturn("Luciana");
		Mockito.when(personaMock.getApellido()).thenReturn("Perez");
		Mockito.when(personaMock.getEdad()).thenReturn(34);
		
		//los testeos para ver si devuelven lo que tienen que devolver
		assertEquals(personaMock.getUsuario(), "luciana");
		assertEquals(personaMock.getPassword(), "1234");
		assertEquals(personaMock.getNombre(), "Luciana");
		assertEquals(personaMock.getApellido(), "Perez");
		assertEquals(Integer.valueOf(34), personaMock.getEdad());
		
	}	
	
}
