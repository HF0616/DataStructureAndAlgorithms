package StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StdIn {
    private static Scanner scanner;

    public static void openFile(String fileName){
        try{
            scanner = new Scanner(new File(fileName));
        }catch (FileNotFoundException e){
            System.out.println("文件没有找到："+fileName);
            System.exit(1);
        }
    }

    public static boolean isEmpty(){
        return !scanner.hasNext();
    }
    public static int readInt(){
        return scanner.nextInt();
    }
    public static double readDouble(){
        return scanner.nextDouble();
    }
    public static String readString(){
        return scanner.next();
    }
    public static boolean readBoolean(){
        return scanner.nextBoolean();
    }
    public static void close(){
        scanner.close();
    }


}
