package com.example.backend.Service;

import com.example.backend.Model.CsvData;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
//    public List<CsvData> readCsvFile(String filePath) throws IOException {
//        List<CsvData> csvDataList = new ArrayList<>();
//        CSVReader csvReader = null;
//
//        try {
//            csvReader = new CSVReaderBuilder(new FileReader(filePath))
//                    .withCSVParser(new CSVParserBuilder()
//                            .withSeparator(',')
//                            .build())
//                    .build();
//
//            CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder<CsvData>(csvReader)
//                    .withType(CsvData.class)
//                    .build();
//
//            csvDataList = csvToBean.parse();
//
//            // You now have a List of CsvData objects
//
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // Close the reader
//            if (csvReader != null) {
//                csvReader.close();
//            }
//        }
//
//        return csvDataList;
//    }



    public List<CsvData> csvRead(String filePath){

        List<CsvData> records = new ArrayList<>();
        boolean mark = true;

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
            String line = br.readLine();
            //to skip first line
            line=br.readLine();
            while (line != null) {
                String[] values = line.split(",");
                CsvData standort = CsvData.builder()
                        .field1(values[0])
                        .field2(values[1])
                        .build();
                records.add(standort);
                line=br.readLine();
            }
            return records;
        }
        catch (IOException ex) {

            System.out.println(ex.getMessage() + "Error");
            return null;
        }
    }
}
