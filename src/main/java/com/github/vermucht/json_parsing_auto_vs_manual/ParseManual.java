package com.github.vermucht.json_parsing_auto_vs_manual;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Parsing JSON fully manually */
@RestController
@SuppressWarnings("unchecked")
public class ParseManual {
    @PostMapping("/manual")
    public String parseManual(@RequestBody String string) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(string, Map.class);
            Request data = new Request();
            data.value = (int) jsonMap.get("value");
            return Integer.toString(data.value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
