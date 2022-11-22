import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ImageHtml{
    public static String getSource(String img, List<String>imgList, int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseHTML.header(depth));
        sb.append("<h2><a href=\"./index.html\">^^</a></h2>");
        sb.append("\n\t\t<table>\n\t\t\t<tr><td><h2><a href=\"");
        if (imgList.indexOf(img) == 0) {
            sb.append(img.substring(0,img.lastIndexOf('.')));
        } else {
            String elozo = imgList.get(imgList.indexOf(img)-1);
            sb.append(elozo.substring(0, elozo.lastIndexOf('.')));
        }
        sb.append(".html\"><<</a></h2></td>");
        sb.append(String.format("\n\t\t\t\t<td><h2>%s</h2></td>",img));
        sb.append("\n\t\t\t\t<td><h2><a href=\"");
        if (imgList.indexOf(img) == imgList.size()-1) {
            sb.append(img.substring(0,img.lastIndexOf('.')));
        } else {
            String kovetkezo = imgList.get(imgList.indexOf(img)+1);
            sb.append(kovetkezo.substring(0, kovetkezo.lastIndexOf('.')));
        }
        sb.append(".html\">>></a></h2></td>\n\t\t\t</tr>");
        sb.append("\n\t\t</table>\n\t\t<a href=\"");
        if (imgList.indexOf(img) == imgList.size()-1) {
            sb.append(img.substring(0,img.lastIndexOf('.')));
        } else {
            String kovetkezo = imgList.get(imgList.indexOf(img)+1);
            sb.append(kovetkezo.substring(0, kovetkezo.lastIndexOf('.')));
        }
        sb.append(String.format(".html\"><img src=\"%s\"></a>", img));
        sb.append(BaseHTML.closingTags);
        return sb.toString();
    }
    public static void createFile(String fname, String path, String source) {
        fname = fname.substring(0,fname.lastIndexOf('.'));
        try {
            FileWriter image = new FileWriter(path+"\\"+fname+".html");
            image.write(source);
            image.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }
}
