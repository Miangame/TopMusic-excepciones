package topMusicExcepciones;

import java.util.ArrayList;

import utiles.Menu;

/**
 * Clase TopMusic que crea un arrayList de canciones y tiene los métodos para
 * manejar una lista de canciones que se pueden subir, bajar añadir o eliminar
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public class TopMusic {
	/**
	 * Lista para almacenar canciones
	 */
	private ArrayList<Cancion> lista;

	public TopMusic() {
		lista = new ArrayList<Cancion>();
	}

	boolean isEmpty() {
		return lista.isEmpty();
	}

	/**
	 * Muestra la canciÃ³n que estÃ¡ en el top
	 * 
	 * @param lista
	 */
	Cancion topLista() {
		if (lista.size() == 0)
			return null;

		return lista.get(0);
	}

	/**
	 * Baja un puesto una canciÃ³n elegida
	 * 
	 * @param lista
	 * @throws PosicionNoValidaException
	 */
	String bajarPuesto(int posicion) throws PosicionNoValidaException {

		if (lista.size() == 0 || posicion - 1 < 0 || posicion >= lista.size())
			throw new PosicionNoValidaException("La posición no es correcta");

		/*
		 * Cancion aux = lista.get(posicion); lista.set(posicion,
		 * lista.get(posicion - 1));
		 * 
		 * lista.set(posicion - 1, aux);
		 */
		lista.add(lista.remove(posicion - 1));
		return "\nSe ha bajado un puesto";

	}

	/**
	 * Sube un puesto una canciÃ³n elegida
	 * 
	 * @param lista
	 * @throws PosicionNoValidaException
	 */
	String subirPuesto(int posicion) throws PosicionNoValidaException {
		if (lista.size() == 0 || posicion < size() || posicion - 1 == 0 || posicion > size())
			throw new PosicionNoValidaException("La posición no es correcta");

		/*
		 * Cancion aux = lista.get(cancion - 2); lista.set(cancion - 2,
		 * lista.get(cancion - 1)); lista.set(cancion - 1, aux);
		 */

		lista.add(posicion - 2, lista.remove(posicion - 1));
		return "\nSe ha subido un puesto";
	}

	/**
	 * Elimina una canciÃ³n de la lista
	 * 
	 * @param lista
	 * @throws PosicionNoValidaException
	 */
	String eliminarCancion(int posicion) throws PosicionNoValidaException {
		if (lista.isEmpty() || posicion - 1 < 0 || posicion > lista.size())
			throw new PosicionNoValidaException("La posición no es correcta");

		return "\nSe ha borrado la canción: " + lista.remove(posicion - 1);

	}

	/**
	 * AÃ±ade una canciÃ³n a la lista
	 * 
	 * @param lista
	 */
	String aniadirCancion(int posicion, Cancion cancion) {
		if (!esPosicionValida(posicion)) {
			return null;
		}
		lista.add(posicion, cancion);
		return "\nSe ha añadido una canción";
	}

	/**
	 * Genera un menÃº con las canciones
	 * 
	 * @param lista
	 * @return OpciÃ³n elegida del menÃº
	 */
	int listarCanciones() {
		if (lista.isEmpty())
			return -1;

		int i = 0;
		String[] opciones = new String[lista.size()];

		for (Cancion cancion : lista) {
			opciones[i] = cancion.toString();
			i++;
		}
		Menu menuCanciones = new Menu("\n---Menú Canciones---", opciones);

		return menuCanciones.gestionar();
	}

	/**
	 * Devuelve el tama�o de la lista
	 * 
	 * @return Tama�o de la lista
	 */
	int size() {
		return lista.size();
	}

	/**
	 * Indica si una posici�n es v�lida o no
	 * 
	 * @param posicion
	 * @return True si es v�lida. False si no es v�lida
	 */
	boolean esPosicionValida(int posicion) {
		if (posicion < 0 || posicion > size())
			return false;

		return true;
	}

	public Cancion get(int posicion) {
		return lista.get(posicion);
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		int i = 0;
		if (lista.isEmpty())
			cadena.append("\nLa lista estÃ¡ vacia. Por favor introduzca alguna canciÃ³n");

		for (Cancion cancion : lista) {
			cadena.append("\n\t" + ++i + ". " + cancion);
		}
		return cadena.toString();
	}

	/**
	 * Muestra la lista de las canciones
	 * 
	 * @param lista
	 */
	// StringBuilder mostrarLista() {
	// StringBuilder cadena = new StringBuilder();
	// int i = 0;
	// if (lista.isEmpty())
	// cadena.append("\nLa lista estÃ¡ vacia. Por favor introduzca alguna
	// canciÃ³n");
	//
	// for (Cancion cancion : lista) {
	// cadena.append("\n\t" + ++i + ". " + cancion);
	// }
	// return cadena;
	// }
}
