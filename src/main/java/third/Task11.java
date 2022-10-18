package third;

import java.io.*;
import java.util.Arrays;

public class Task11 {
    private static final String dir = "C:\\Users\\mi\\Downloads\\Telegram Desktop\\tmp";
    public static void main(String[] args){
        for(String s: getFilesWithExtension(dir,".pdf")){
            System.out.println(s);
        }
    }
    private static String[] getFilesWithExtension(String path, String extension){
        return new File(path).list(((dir1, name) -> name.endsWith(extension)));
    }
}
