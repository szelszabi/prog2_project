import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IndexHTML extends BaseHTML {
    public List<File> dirList = new ArrayList<>();
    public List<File> imgList = new ArrayList<>();

    public IndexHTML(int depth, File fname) {
        super(depth, fname);
    }

    @Override
    public String getSource() {
        StringBuilder sb = new StringBuilder();
        sb.append(header(this.getDepth()));
        sb.append("\n\t\t<h2>Directories:</h2>\n\t\t<ul>");
        if(this.getDepth() != 0) {
            sb.append("\n\t\t\t<li><a href=\"../index.html\"><<</a></li>");
        }
        for (File directory : dirList) {
            sb.append(String.format("\n\t\t\t<li><a href=\"%s/index.html\">%s</a></li>", directory.getName(), directory.getName()));
        }
        sb.append("\n\t\t</ul>\n\t\t<hr>\n\t\t<h2>Images:</h2>\n\t\t<ul>");
        for (File fajl : imgList) {
            String fs = fajl.getName().substring(0, fajl.getName().lastIndexOf('.'));
            sb.append(String.format("\n\t\t\t<li><a href=\"%s.html\">%s</a></li>", fs, fajl.getName()));
        }
        sb.append("\n\t\t</ul>");
        sb.append("\n\t<body>\n<html>");
        return sb.toString();
    }

}
