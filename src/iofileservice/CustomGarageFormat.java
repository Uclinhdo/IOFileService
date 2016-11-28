/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iofileservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author linhdo
 */
public class CustomGarageFormat implements TextFormatStrategy {
     private final String CRLF = "\n";
     //private final String SEPARATOR = ":";
     private static final String TOTAL_HOURS = "Hours Parked";
     private static final String TOTAL_FEES = "Fee Collected";
     
    @Override
     public String encode(List<Map<String,String>> data){
         //data validation
         if(data == null || data.size() == 0){
            throw new IllegalArgumentException("Error: Data could not be found! ");
        }
         Map<String,String> sourceData = data.get(0);
         String totalHours = sourceData.get(TOTAL_HOURS);
         String totalFees = sourceData.get(TOTAL_FEES);
         return  totalHours +  CRLF + totalFees +  CRLF;
     }
    @Override
     public List<Map<String,String>> decode(List<String> dataFromFile){
         
         String sTotalHours = dataFromFile.get(0);
         String sTotalFees = dataFromFile.get(1);
         List<Map<String,String>> appData = new ArrayList<>();
         Map<String,String> record = new HashMap<>();
         record.put(TOTAL_HOURS, sTotalHours);
         record.put(TOTAL_FEES, sTotalFees);
         appData.add(record);
        
        return appData;
     }
     
     //Testing
//     public static void main(String[] args) {
//        CustomGarageFormat formatObj = new CustomGarageFormat();
//        //encode testing
////        List<Map<String,String>> dataFromApp = new ArrayList<>();
////        Map<String,String> record = new HashMap<>();
////        record.put(TOTAL_HOURS, "45.50");
////        record.put(TOTAL_FEES, "80.25");
////        dataFromApp.add(record);
////        String formatted = formatObj.encode(dataFromApp);
////        System.out.println(formatted);
//
//        //decode testing
//        List<String> dataFromFile = Arrays.asList("45.50","80.25");
//        List<Map<String,String>> appData = formatObj.decode(dataFromFile);
//        System.out.println(appData);
//    }
     
     
}
