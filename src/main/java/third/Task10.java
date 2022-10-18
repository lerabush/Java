package third;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) throws Exception {
        String classpath = Task10.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        System.out.println("method reference:");
        System.out.println(Arrays.toString(getSubdirectories(classpath)));

        System.out.println("lambda expression:");
        System.out.println(Arrays.toString(getSubdirectoriesLambda(classpath)));

        System.out.println("anonymous inner class:");
        System.out.println(Arrays.toString(getSubdirectoriesInnerClass(classpath)));

    }

    private static File[] getSubdirectories(String path) {
        File[] dirs = new File(path).listFiles(File::isDirectory);
        return dirs == null ? new File[0] : dirs;
    }

    private static File[] getSubdirectoriesInnerClass(String path) {
        File[] dirs = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }
        });
        return dirs == null ? new File[0] : dirs;
    }

    private static File[] getSubdirectoriesLambda(String path) {
        File[] dirs = new File(path).listFiles(File::isDirectory);
        return dirs == null ? new File[0] : dirs;
    }
}
