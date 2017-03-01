package topMusicExcepciones;

import utiles.Menu;
import utiles.Teclado;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones mÃ¡s
 * escuchadas. El usuario podrÃ¡:
 * <ul>
 * <li>a. AÃ±adir una canciÃ³n (en una posiciÃ³n) al TopMusic.</li>
 * <li>b. Sacar un elemento del TopMusic.</li>
 * <li>c. Subir un puesto en el TopMusic.</li>
 * <li>d. Bajar un puesto en el TopMusic.</li>
 * <li>e. Mostrar la lista TopMusic.</li>
 * <li>f. Mostrar la canciÃ³n mÃ¡s escuchada. Sobre la canciÃ³n se almacenarÃ¡
 * el tÃ­tulo, artista o grupo y aÃ±o de grabaciÃ³n.</li>
 * </ul>
 * 
 * @author Miguel Ã�ngel GavilÃ¡n Merino
 *
 */
public class TestTopMusic {

	static TopMusic lista = new TopMusic();

	public static void main(String[] args) {
		String[] opciones = { "Añadir cancion (en una posición) al TopMusic", "Sacar elemento del TopMusic",
				"Subir un puesto en el TopMusic", "Bajar un puesto en el TopMusic", "Mostrar la lista del TopMusic",
				"Mostrar la canción más escuchada", "Salir" };

		Menu menu = new Menu("\n---TOP MUSIC---", opciones);
		int opcion;

		do {
			opcion = menu.gestionar();

			switch (opcion) {
			case 1:
				addSong();

				break;

			case 2:
				deleteSong();

				break;

			case 3:
				upSong();
				break;

			case 4:
				downSong();
				break;

			case 5:
				showList();
				break;

			case 6:
				topList();
				break;

			default:
				System.out.println("\nSALIENDO...");
				break;
			}
		} while (opcion != 7);

	}// main()

	/**
	 * Muestra la canci�n top de la lista. No la muestra si est� vacia
	 */
	private static void topList() {
		if (lista.isEmpty()) {
			System.out.println("La lista est� vac�a. Por favor introduzca elementos.");
		} else {
			System.out.println("\nEl top de la lista es: " + lista.topLista());
		}
	}

	/**
	 * Muestra la lista si no est� vacia
	 */
	private static void showList() {
		if (lista.isEmpty()) {
			System.out.println("La lista est� vac�a. Por favor introduzca elementos.");
		} else {
			System.out.println(lista);
		}
	}

	/**
	 * Baja la canci�n un puesto
	 */
	private static void downSong() {

		try {
			System.out.println(lista.bajarPuesto(lista.listarCanciones()));
		} catch (PosicionNoValidaException e) {
			// TODO Auto-generated catch block
			System.err.println("\n" + e.getMessage());
		}

	}

	/**
	 * Sube la canci�n un puesto
	 */
	private static void upSong() {
		// if (lista.isEmpty()) {
		// System.out.println("La lista est� vac�a. Por favor introduzca
		// elementos.");
		// } else {
		try {
			System.out.println(lista.subirPuesto(lista.listarCanciones()));
		} catch (PosicionNoValidaException e) {
			System.err.println("\n" + e.getMessage());
		}
		// }
	}

	/**
	 * Si la lista no est� vacia, borra una canci�n indicada por posici�n
	 */
	private static void deleteSong() {
		if (lista.isEmpty()) {
			System.out.println("La lista est� vac�a. Por favor introduzca elementos.");
		} else {
			try {
				System.out.println(lista.eliminarCancion(lista.listarCanciones()));
			} catch (PosicionNoValidaException e) {
				System.err.println("\n" + e.getMessage());
			}
		}
	}

	/**
	 * A�ade una canci�n a la lista siempre que la posici�n sea v�lida
	 */
	private static void addSong() {
		int posicion;
		do {
			posicion = Teclado.leerEntero("\nIntroduzca la posici�n deseada entre 1 y " + (lista.size() + 1) + ": ");
		} while (!lista.esPosicionValida(posicion - 1));
		try {
			System.out.println(lista.aniadirCancion(posicion - 1, crearCancion()));
		} catch (PosicionNoValidaException e) {
			System.err.println("\n" + e.getMessage());
		}
	}

	/**
	 * Devuelve una cancion una vez validada por el getInstance()
	 * 
	 * @return Cancion
	 */
	private static Cancion crearCancion() {
		String titulo;
		String artista;
		int anioGrabacion;
		Cancion cancion = null;

		do {
			titulo = Teclado.leerCadena("\n\tTitulo cancion: ");
			artista = Teclado.leerCadena("\tArtista: ");
			anioGrabacion = Teclado.leerEntero("\tAnio de grabacion: ");
			try {
				cancion = new Cancion(titulo, artista, anioGrabacion);
			} catch (AutorNoValidoException e) {
				System.err.println("\n" + e.getMessage());
			} catch (FechaNoValidaException e) {
				System.err.println("\n" + e.getMessage());
			} catch (CancionNoValidaException e) {
				System.err.println("\n" + e.getMessage());
			}
		} while (cancion == null);

		return cancion;
	}

}
