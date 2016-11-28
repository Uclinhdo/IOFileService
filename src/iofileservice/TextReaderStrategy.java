/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iofileservice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author linhdo
 */
public interface TextReaderStrategy {

    public abstract String getFilePath();

    public abstract TextFormatStrategy getFormatter();

    public abstract List<Map<String, String>> readFile() throws IOException;

    public abstract void setFilePath(String filePath);
   
    public abstract void setFormatter(TextFormatStrategy formatter);
    
}
