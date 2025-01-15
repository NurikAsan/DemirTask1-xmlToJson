package com.example.xmltojson.controllers;

import com.example.xmltojson.services.XmlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class XmlToJsonController {
    private final XmlService xmlService;

    @PostMapping("/process")
    public ResponseEntity<Map<String, Object>> processXml(@RequestBody String xmlData) {

        try {

            return ResponseEntity.ok(xmlService.convertAndSaveXmlData(xmlData));

        } catch (Exception e) {

            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "An error occurred while processing XML data");
            errorResponse.put("message", "Incorrect xml data");

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }

    }

}
