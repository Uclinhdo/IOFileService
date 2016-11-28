/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iofileservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author linhdo
 */
public class TextFileReader implements TextReaderStrategy {
    private TextFormatStrategy formatter;
    private String filePath;

    public TextFileReader(String filePath) {
        setFilePath(filePath);
    }

    public TextFileReader(String filePath,TextFormatStrategy formatter) {
        this.formatter = formatter;
        setFilePath(filePath);
    }
    
    @Override
    public List<Map<String,String>> readFile() throws IOException{
        File dataFile = new File(filePath);
        BufferedReader in = new BufferedReader(new FileReader(dataFile));
        List<String> lines = new ArrayList<>();
        String line = in.readLine();
        while(line != null){
            lines.add(line);
            line = in.readLine();
        }
        in.close();
        return formatter.decode(lines);
        }
        
    

    @Override
    public final TextFormatStrategy getFormatter() {
        return formatter;
    }

    @Override
    public final void setFormatter(TextFormatStrategy formatter) {
        this.formatter = formatter;
    }

    @Override
    public final String getFilePath() {
        return filePath;
    }

    @Override
    public final void setFilePath(String filePath) {
        if(filePath == null || filePath.isEmpty()){
            throw new IllegalArgumentException("Data could not be found!");
        }else{
        this.filePath = filePath;
        }
    }
    
    //testing
//    public static void main(String[] args) throws IOException {
//        TextFileReader readerApp = new TextFileReader("src" 
//                + File.separatorChar 
//                + "custom_garage_format.txt",
//                new CustomGarageFormat());
//        
//        List<Map<String,String>> temp = readerApp.readFile();
//        System.out.println(temp);
//    }
    
    
}
