package hu.nive.ujratervezes.kepesitovizsga6.finelongword;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FineLongWord {

    public char[] readFineLongWordFromFileAndGetItInAnArray(String filename) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(filename))){
            StringBuilder result=new StringBuilder(br.readLine());
            String line;
            while ((line=br.readLine())!= null){
                result.append(line.charAt(line.length()-1));
            }
            return result.toString().toCharArray();
        }catch (IOException ioe){
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}
