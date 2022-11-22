import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static List<String> imgList = new ArrayList<>();
    public static List<String> dirList = new ArrayList<>();

    public static void bejar(File dir, File currentPath, int depth) {
        if (dir != null) {
            System.out.print("Current dir.: ");
            System.out.println(dir.toString());
            File[] files = dir.listFiles();
            Arrays.sort(files);
            for (File file : files) {
                if (file.isFile() && isImage(file)) {
                    imgList.add(file.getName());
                } else if (file.isDirectory()) {
                    dirList.add(file.getName());
                }
            }
            imgList.sort(null);
            dirList.sort(null);
            String source = IndexHTML.getSource(dirList, imgList, depth);
            IndexHTML.createFile(dir, source);
            for (String img : imgList) {
                String imageSource = ImageHtml.getSource(img, imgList, depth);
                ImageHtml.createFile(img, currentPath.toString(), imageSource);
            }
            imgList.clear();
            dirList.clear();
            for (File directory : dir.listFiles()) {
                if (directory.isDirectory()) {
                    bejar(directory, directory.getAbsoluteFile(), depth+1);
                }
            }
        }
    }

    private static boolean isImage(File file) {
        String[] extensions = {"jpg", "jpeg", "gif", "png"};
        String fextension = file.toString();
        fextension = fextension.substring(fextension.lastIndexOf('.')+1).toLowerCase();
        for (String s : extensions) {
            if(s.equals(fextension)) return true;
        }
        return false;
    }
}
