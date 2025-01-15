package com.example.xmltojson.services;

import com.example.xmltojson.models.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XmlService {
    public Map<String, Object> convertAndSaveXmlData(String xmlData) throws Exception {
        var xmlMapper = new XmlMapper();
        Data data = xmlMapper.readValue(xmlData, Data.class);

        var objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(data);

        saveToFile(jsonData, data.getType());

        Map<String, Object> wrappedData = new HashMap<>();
        wrappedData.put("Data", data);
        return wrappedData;
    }

    private void saveToFile(String jsonData, String type) throws IOException {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String filename = type + "-" + date + ".log";
        Path filePath = Paths.get(filename);

        int recordCount = 0;
        if (Files.exists(filePath)) {
            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                String firstLine = reader.readLine();

                if (firstLine != null)
                    recordCount = Integer.parseInt(firstLine.trim());
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            if (recordCount == 0)
                writer.write("0\n");

            recordCount++;
            writer.write(jsonData + "\n");
        }

        List<String> lines = Files.readAllLines(filePath);
        lines.set(0, String.valueOf(recordCount));
        Files.write(filePath, lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

}
