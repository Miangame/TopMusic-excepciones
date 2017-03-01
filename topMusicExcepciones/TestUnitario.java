package topMusicExcepciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test que comprueba que los títulos, autores y años de las canciones son
 * válidos.
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class TestUnitario {
	TopMusic lista = new TopMusic();

	@Before
	public void startClass() {
		try {
			lista.aniadirCancion(0, (new Cancion("Me too", "The B-52's", 2000)));
			lista.aniadirCancion(1, (new Cancion("Don´t let me down", "Jain", 2017)));
			lista.aniadirCancion(2, (new Cancion("19 días y 500 noches", "Joaquín Sabina", 2000)));
		} catch (AutorNoValidoException e) {
			System.err.println("\n" + e.getMessage());
		} catch (FechaNoValidaException e) {
			System.err.println("\n" + e.getMessage());
		} catch (CancionNoValidaException e) {
			System.err.println("\n" + e.getMessage());
		} catch (PosicionNoValidaException e) {
			System.err.println("\n" + e.getMessage());
		}
	}

	@Test
	public void comprobarTitulos() {
		Assert.assertEquals("Me too", lista.get(0).getTitulo().toString());
		Assert.assertEquals("Don´t let me down", lista.get(1).getTitulo().toString());
		Assert.assertEquals("19 días y 500 noches", lista.get(2).getTitulo().toString());
	}

	@Test
	public void comprobarAutores() {
		Assert.assertEquals("The B-52's", lista.get(0).getArtista().toString());
		Assert.assertEquals("Jain", lista.get(1).getArtista().toString());
		Assert.assertEquals("Joaquín Sabina", lista.get(2).getArtista().toString());
	}

	@Test
	public void comprobarAnios() {
		Assert.assertEquals(2000, lista.get(0).getAnioGrabacion());
		Assert.assertEquals(2017, lista.get(1).getAnioGrabacion());
		Assert.assertEquals(2000, lista.get(2).getAnioGrabacion());
	}

}
