package topMusicExcepciones;

import java.util.Calendar;

/**
 * Clase Cancion con título, autor y año de grabación que son comprobados
 * mediante expresiones regulares y lanzan excepciones en caso de error
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public class Cancion {

	private static Calendar fecha = Calendar.getInstance();

	/**
	 * Año actual
	 */
	private static int anioActual = fecha.get(Calendar.YEAR);

	/**
	 * TÃ­tulo de la canciÃ³n
	 */
	private String titulo;

	/**
	 * Artista de la canciÃ³n
	 */
	private String artista;

	/**
	 * AÃ±o de la canciÃ³n
	 */
	private int anioGrabacion;

	/**
	 * Constructor de la clase canciÃ³n
	 * 
	 * @param titulo
	 * @param artista
	 * @param anioGrabacion
	 * @throws CancionNoValidaException
	 */
	public Cancion(String titulo, String artista, int anioGrabacion)
			throws AutorNoValidoException, FechaNoValidaException, CancionNoValidaException {

		setArtista(artista);
		setAnioGrabacion(anioGrabacion);
		setTitulo(titulo);

	}

	private static boolean comprobarAnio(int anioGrabacion) {
		return anioGrabacion >= 1900 && anioGrabacion <= anioActual;
	}

	private static boolean comprobarTituloAutor(String titulo) {
		return titulo.matches("([\\-´',a-zA-ZáéíóúÁÉÍÓÚñÑ0-9]+\\s?)+");
	}

	public String getTitulo() {
		return titulo;
	}

	public String getArtista() {
		return artista;
	}

	public int getAnioGrabacion() {
		return anioGrabacion;
	}

	private void setTitulo(String titulo) throws CancionNoValidaException {
		if (comprobarTituloAutor(titulo)) {
			this.titulo = titulo;
		} else {
			throw new CancionNoValidaException("El título no es correcto");
		}
	}

	private void setArtista(String artista) throws AutorNoValidoException {
		if (comprobarTituloAutor(artista)) {
			this.artista = artista;
		} else {
			throw new AutorNoValidoException("El autor no es correcto");
		}
	}

	private void setAnioGrabacion(int anioGrabacion) throws FechaNoValidaException {
		if (comprobarAnio(anioGrabacion)) {
			this.anioGrabacion = anioGrabacion;
		} else {
			throw new FechaNoValidaException("La fecha no es correcta");
		}
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artista=" + artista + ", anioGrabacion=" + anioGrabacion + "]";
	}

}
