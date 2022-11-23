import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class BaseHTML {
    private int depth;
    private File file;

    public BaseHTML(int depth, File fname) {
        this.depth = depth;
        this.file = fname;
    }

    static String header(int depth) {
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

    @Override
    public String toString() {
        return this.file.toString();
    }

    public abstract String getSource();

    public void createFile(String source, File path, String fname) {
        try {
            FileWriter image = new FileWriter(path+"/"+fname+".html");
            image.write(source);
            image.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    public int getDepth() {
        return depth;
    }

    public File getFile() {
        return file;
    }
}