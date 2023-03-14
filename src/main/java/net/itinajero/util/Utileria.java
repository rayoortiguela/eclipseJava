package net.itinajero.util;

import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	/**
	 * Metodo que guarda un archivo atraves de un formulario HTML al disco duro.
	 * @param multiPart
	 * @return
	 */
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();
		// Reemplazamos en el nombre de archivo los espacios por guiones.
		nombreOriginal = nombreOriginal.replace(" ", "-");
		// Agregamos al nombre del archivo 8 caracteres aleatorios para evitar duplicados.
		String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}

	/**
	 * Metodo para generar una cadena aleatoria de longitud N
	 * @param count
	 * @return
	 */
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
}