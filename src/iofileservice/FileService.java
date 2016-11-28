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
public class FileService {
    private TextReaderStrategy reader;
    private TextWriterStrategy writer;

    public FileService() {
    }

    public FileService(TextReaderStrategy reader, TextWriterStrategy writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public List<Map<String,String>> readFile() throws IOException{
            return reader.readFile();
    }
     public void writeFile(List<Map<String,String>> dataFile) throws IOException{
         writer.writeFile(dataFile);
     }
    public final TextReaderStrategy getReader() {
        return reader;
    }

    public final void setReader(TextReaderStrategy reader) {
        this.reader = reader;
    }

    public final TextWriterStrategy getWriter() {
        return writer;
    }

    public final void setWriter(TextWriterStrategy writer) {
        this.writer = writer;
    }
   
    public static void main(String[] args) throws IOException {
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
