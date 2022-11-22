public class BaseHTML {
    public static String closingTags = "\n\t<body>\n<html>";
    public static String header(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<meta charset=\"UTF-8\">\n\t</head>");
        sb.append("\n\t<body>\n\t\t<h1><a href=\"");
        sb.append(backRelative(depth));
        sb.append("./index.html\">Start page</a></h1>\n\t\t<hr>");
        return sb.toString();
    }
    private static String backRelative(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("../");
        }
        return sb.toString();
    }
}