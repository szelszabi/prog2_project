import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("A singular argument is required!");
            System.exit(1);
        }
        File fajl = new File(args[0]);
        if (fajl.isFile()) {
            System.err.println("The given argument is not a directory!");
            System.exit(3);
        }
        if (!fajl.exists()) {
            System.err.println("Directory/file does not exist!");
            System.exit(2);
        }
        File[] files = fajl.listFiles();
        List<File> dirList = new ArrayList<>();
        List<File> imgList = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                dirList.add(file);
            }
            else if (FileUtils.isImage(file)) {
                imgList.add(file);
            }
        }
        IndexHTML root = new IndexHTML(0, fajl);
        FileUtils.bejar(root);
    }
}