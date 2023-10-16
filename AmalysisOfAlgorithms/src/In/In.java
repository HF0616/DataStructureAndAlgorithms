package In;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class In {
    public static int[] readInts(String filename) throws IOException{
        List<Integer> integer = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line=reader.readLine())!=null){
                String[] words = line.split(" ");
                for(String word : words){
                    try{
                        int number = Integer.parseInt(word);
                        integer.add(number);
                    }catch (NumberFormatException e){
                        System.err.println("Invalid number:"+line);
                    }
                }

            }
        }
        int[] result = new int[integer.size()];
        for(int i=0;i<integer.size();i++){
            result[i]= integer.get(i);
        }
        return result;
    }
}
