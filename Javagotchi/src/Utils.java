public class Utils {
	public static String centerString(String content, int len) {
		content = padLeft(content, (len + content.length()) / 2);
		content = padRight(content, len);
		return content;
	}

	public static String padLeft(String content, int len) {
		while (content.length() < len) {
			content = " " + content;
		}
		return content;
	}

	public static String padRight(String content, int len) {
		while (content.length() < len) {
			content = content + " ";
		}
		return content;
	}

}
