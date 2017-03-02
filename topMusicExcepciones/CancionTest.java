package topMusicExcepciones;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CancionTest {
	
	@Test
	public void test1() throws AutorNoValidoException, FechaNoValidaException, CancionNoValidaException {
		Cancion cancion = new Cancion("Me too", "The B-52's", 2000);
		Assert.assertEquals("Me too", cancion.getTitulo().toString());
		Assert.assertEquals("The B-52's", cancion.getArtista());
		Assert.assertEquals(2000, cancion.getAnioGrabacion());
		Assert.assertNotSame("Hola", cancion.getTitulo());
	}
	
	@Test
	public void test2() throws AutorNoValidoException, FechaNoValidaException, CancionNoValidaException {
		Cancion cancion = new Cancion("Don´t let me down", "Jain", 2017);
		Assert.assertEquals("Don´t let me down", cancion.getTitulo());
		Assert.assertEquals("Jain", cancion.getArtista());
		Assert.assertEquals(2017, cancion.getAnioGrabacion());
		Assert.assertNotSame("Hola", cancion.getArtista());
	}
	
	@Test
	public void test3() throws AutorNoValidoException, FechaNoValidaException, CancionNoValidaException {
		Cancion cancion = new Cancion("19 días y 500 noches", "Joaquín Sabina", 2000);
		Assert.assertEquals("19 días y 500 noches", cancion.getTitulo());
		Assert.assertEquals("Joaquín Sabina", cancion.getArtista());
		Assert.assertEquals(2000, cancion.getAnioGrabacion());
		Assert.assertNotSame(1900, cancion.getAnioGrabacion());
	}

}
