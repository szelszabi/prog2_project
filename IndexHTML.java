import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class IndexHTML {
    public static String getSource(List<String>dirList, List<String>imgList, int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseHTML.header(depth));
        sb.append("\n\t\t<h2>Directories:</h2>\n\t\t<ul>");
        if(depth != 0) {
            sb.append("\n\t\t\t<li><a href=\"..\\index.html\"><<</a></li>");
        }
        for (String directory : dirList) {
            sb.append(String.format("\n\t\t\t<li><a href=\"%s\\index.html\">%s</a></li>", directory, directory));
        }
        sb.append("\n\t\t</ul>\n\t\t<hr>\n\t\t<h2>Images:</h2>\n\t\t<ul>");
        for (String fajl : imgList) {
            String fs = fajl.substring(0, fajl.lastIndexOf('.'));
            sb.append(String.format("\n\t\t\t<li><a href=\"%s.html\">%s</a></li>", fs, fajl));
        }
        sb.append("\n\t\t</ul>");
        sb.append(BaseHTML.closingTags);
        return sb.toString();
    }
    public static void createFile(File path, String source) {
        try {
            FileWriter image = new FileWriter(path.toString()+"\\"+"index.html");
            image.write(source);
            image.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }
}
