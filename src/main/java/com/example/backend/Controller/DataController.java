package com.example.backend.Controller;

import com.example.backend.Model.CsvData;
import com.example.backend.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class DataController {
        @Autowired
        DataService dataService;

        @GetMapping("/read")
        public ResponseEntity readCsv(){
            try {
                String filePath = "src/main/data/dataset.csv";
                List<CsvData> graphDataList = dataService.csvRead(filePath);
                return new ResponseEntity(graphDataList, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>("Error reading CSV file", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
