package com.example.backend.Model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CsvData {
        private String field1;

        private String field2;
}
