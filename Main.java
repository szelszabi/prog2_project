import java.io.File;

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
        FileUtils.bejar(fajl, fajl.getParentFile(), 0);
    }
}