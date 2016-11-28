/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iofileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author linhdo
 */
public class TextFileWriter implements TextWriterStrategy {
    private TextFormatStrategy formatter;
    private String filePath;

    public TextFileWriter(String filePath) {
        setFilePath(filePath);
    }

    public TextFileWriter(String filePath,TextFormatStrategy formatter) {
        this.formatter = formatter;
        setFilePath(filePath);
    }

    @Override
    public void writeFile(List<Map<String,String>> dataFile) throws IOException{
         boolean append = true;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath, append)));
        out.print(formatter.encode(dataFile));
        out.close();
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
//    public static void main(String[] args) {
//        TextFileWriter writerApp = new TextFileWriter("src" 
//                + File.separatorChar 
//                + "custom_garage_format.txt");
//       Map<String,String> temp = writerApp.writeFile();
//        
//                
//    }
    
    
}
