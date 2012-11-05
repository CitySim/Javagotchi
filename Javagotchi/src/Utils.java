public class Utils {
	/**
	 * fügt links und rechts leerzeichnen an um einen String um ihn zu
	 * zentrieren
	 * 
	 * @param content
	 *            Der Inhalt der zentriert sein soll
	 * @param len
	 *            wie lang der String sein soll
	 * @return der zentrierte Screen
	 */
	public static String centerString(String content, int len) {
		content = padLeft(content, (len + content.length()) / 2);
		content = padRight(content, len);
		return content;
	}

	/**
	 * fügt zulange leerzeichen links an den content bis der eine bestimmte
	 * länge erreicht hat
	 * 
	 * @param content
	 *            der Inahlt
	 * @param len
	 *            die Ziel-Länge
	 * @return der content mit leerzeichen
	 */
	public static String padLeft(String content, int len) {
		while (content.length() < len) {
			content = " " + content;
		}
		return content;
	}

	/**
	 * fügt zulange leerzeichen rechts an den content bis der eine bestimmte
	 * länge erreicht hat
	 * 
	 * @param content
	 *            der Inahlt
	 * @param len
	 *            die Ziel-Länge
	 * @return der content mit leerzeichen
	 */
	public static String padRight(String content, int len) {
		while (content.length() < len) {
			content = content + " ";
		}
		return content;
	}

}
