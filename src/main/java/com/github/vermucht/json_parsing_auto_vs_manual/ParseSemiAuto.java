package com.github.vermucht.json_parsing_auto_vs_manual;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Parsing JSON semi-automatically */
@RestController
public class ParseSemiAuto {
    @PostMapping("/auto_semi")
    public String SemiAuto(@RequestBody String string) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Request data = objectMapper.readValue(string, Request.class);
            return Integer.toString(data.value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
