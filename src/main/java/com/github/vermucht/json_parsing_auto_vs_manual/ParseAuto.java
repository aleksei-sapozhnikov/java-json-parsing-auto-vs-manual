package com.github.vermucht.json_parsing_auto_vs_manual;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Auto parsing by framework */
@RestController
public class ParseAuto {
    @PostMapping("/auto")
    public String auto(@RequestBody Request data) {
        return Integer.toString(data.value);
    }
}
