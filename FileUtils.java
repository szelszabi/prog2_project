import java.io.File;
import java.util.Arrays;

public class FileUtils {

    public static void bejar(IndexHTML dir) {
        System.out.print("Current dir.: ");
        System.out.println(dir.toString());

        File[] files = dir.getFile().listFiles();
        Arrays.sort(files);
        for (File file : files) {
            if (file.isDirectory()) {
                dir.dirList.add(file);
            } else if (isImage(file)) {
                dir.imgList.add(file);
            }
        }

        dir.dirList.sort(null);
        dir.imgList.sort(null);
        dir.createFile(dir.getSource(), dir.getFile(), "index");

        int i = 0;
        for (File imgFile : dir.imgList) {
            ImageHTML img = new ImageHTML(
                dir.getDepth(),
                imgFile, 
                i == 0 ? imgFile : dir.imgList.get(i-1),
                i == dir.imgList.size()-1 ? imgFile : dir.imgList.get(i+1));
            img.createFile(img.getSource(), dir.getFile(), img.getFile().getName().substring(0,img.getFile().getName().lastIndexOf(".")));
            i++;
        }

        for (File mappa : dir.dirList) {
            bejar(new IndexHTML(dir.getDepth() + 1, mappa));
        }
    }
    

    public static boolean isImage(File file) {
        String[] extensions = {"jpg", "jpeg", "gif", "png"};
        String fextension = file.toString();
        fextension = fextension.substring(fextension.lastIndexOf('.')+1).toLowerCase();
        for (String s : extensions) {
            if(s.equals(fextension)) return true;
        }
        return false;
    }
}
