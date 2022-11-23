import java.io.File;

public class ImageHTML extends BaseHTML{
    protected File elotteLevo;
    protected File rakovetkezo;
    
    public ImageHTML(int depth, File fname, File elotteLevo, File rakovetkezo) {
        super(depth, fname);
        this.elotteLevo = elotteLevo;
        this.rakovetkezo = rakovetkezo;
    }

    @Override
    public String getSource() {
        StringBuilder sb = new StringBuilder();
        sb.append(header(this.getDepth()));
        sb.append("<h2><a href=\"./index.html\">^^</a></h2>");
        sb.append("\n\t\t<table>\n\t\t\t<tr><td><h2><a href=\"");
        sb.append(String.format("%s.html\"><<</a></h2></td>", this.elotteLevo.getName().substring(0,this.elotteLevo.getName().lastIndexOf("."))));
        sb.append(String.format("\n\t\t\t\t<td><h2>%s</h2></td>",this.getFile().getName().substring(0,this.getFile().getName().lastIndexOf("."))));
        sb.append("\n\t\t\t\t<td><h2><a href=\"");
        sb.append(String.format("%s.html\">>></a></h2></td>\n\t\t\t</tr>", this.rakovetkezo.getName().substring(0, this.rakovetkezo.getName().lastIndexOf("."))));
        sb.append("\n\t\t</table>\n\t\t<a href=\"");
        sb.append(String.format("%s.html\"><img style=\"width: 25%%;\" src=\"%s\"></a>", this.rakovetkezo.getName().substring(0, this.rakovetkezo.getName().lastIndexOf(".")), this.getFile().getName()));
        sb.append("\n\t<body>\n<html>");
        return sb.toString();
    }
}
