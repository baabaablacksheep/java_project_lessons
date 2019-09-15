package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

    public List<String[]> read(String filePath){
        List<String[]> data = new LinkedList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while( (line = br.readLine()) != null){
               String[] dataRecords = line.split(",");
               data.add(dataRecords);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
