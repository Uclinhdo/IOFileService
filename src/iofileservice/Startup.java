/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iofileservice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author linhdo
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        TextFormatStrategy formatter = new CustomGarageFormat();
        String filePath = "src" + File.separatorChar + "custom_garage_format.txt";
        TextReaderStrategy readerApp = new TextFileReader(filePath,formatter);
        TextWriterStrategy writerApp = new TextFileWriter(filePath,formatter);
        FileService fileService = new FileService(readerApp,writerApp);
        
        List<Map<String,String>> result = fileService.readFile();
        fileService.writeFile(result);
        System.out.println(result);
    }
    
}
