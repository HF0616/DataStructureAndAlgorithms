package Dynamic_Connectivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadNumberFromFile {

    private String filePath = null;
    private ArrayList<ArrayList> arr = null;

    public ReadNumberFromFile(String pwd) {
        filePath = pwd;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "/home/hf/Learning/github/Algorithms_And_DataStructures/Data/tinyUF.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String words[] = line.split(("\\s+"));
                ArrayList<Integer> ar = new ArrayList<Integer>();
                for (String word : words) {
                    try {
                        int number = Integer.parseInt(word);
                        ar.add(number);
                    } catch (NumberFormatException e) {

                    }
                }
//                arr.add(ar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
