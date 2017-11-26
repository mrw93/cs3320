package edu.txstate.cs3320.toman.weaver.utils;

public class HTMLTags {
	public static final String HTML_HEADER_START = "<!DOCTYPE html> \n" + "<html>\n" + "<head>\n"
			+ "<meta charset=\"ISO-8859-1\">\n";

	public static final String HTML_HEADER_END = "<style> \n" + "h1 {text-align:center;} \n" + "</style> \n"
			+ "</head>  \n";

	public static final String TITLE_START = "<title>";
	public static final String TITLE_END = "</title>";

	public static final String HTML_START = "<html>";
	public static final String HTML_END = "</html>";

	public static final String BODY_START = "<body>";
	public static final String BODY_END = "</body>";

	public static final String H1_START = "<h1>";
	public static final String H1_END = "</h1>";

	public static final String H2_START = "<h2>";
	public static final String H2_END = "</h2>";

	public static final String H3_START = "<h3>";
	public static final String H3_END = "</h3>";

	public static final String H4_START = "<h4>";
	public static final String H4_END = "</h4>";

	public static final String H5_START = "<h5>";
	public static final String H5_END = "</h5>";

	public static final String H6_START = "<h6>";
	public static final String H6_END = "</h6>";

	public static final String UNORDERED_LIST_START = "<ul>";
	public static final String UNORDERED_LIST_END = "</ul>";

	public static final String LIST_ITEM_START = "<li>";
	public static final String LIST_ITEM_END = "</li>";

	public static final String PARAGRAPH_START = "<p>";
	public static final String PARAGRAPH_END = "</p>";
	public static final String BOLD_START = "<b>";
	public static final String BOLD_END = "</b>";
	public static final String ITALICS_START = "<i>";
	public static final String ITALICS_END = "</i>";

	public final static String LINE_BREAK = "<br>";

	public static String createHTMLHeaderWithBookmark(int headerLevel, String bookmark) {
		StringBuilder stringBuilder = new StringBuilder("<h");
		stringBuilder.append(headerLevel);
		stringBuilder.append(" id=\"");
		stringBuilder.append(bookmark);
		stringBuilder.append("\">");
		return stringBuilder.toString();
	}

	public static String createHTMLLinkToFile(String linkFile, String linkText) {
		StringBuilder stringBuilder = new StringBuilder("<a href= \"");
		stringBuilder.append(linkFile).append("\"> ");
		stringBuilder.append(linkText);
		stringBuilder.append("</a>");
		return stringBuilder.toString();
	}

	public static String createHTMLLinkToBookmark(String linkFile, String bookmark, String linkText) {
		StringBuilder stringBuilder = new StringBuilder("<a href= \"");
		stringBuilder.append(linkFile).append("#");
		stringBuilder.append(bookmark).append("\"> ");
		stringBuilder.append(linkText);
		stringBuilder.append("</a>");
		return stringBuilder.toString();
	}

}
