package com.mbasa.webhooktask;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebhookController {

    @PostMapping("/webhook")
    public ResponseEntity<Map<String, char[]>> processData(@RequestBody DataRequest request) {

        String input = request.getData();

        if (input == null || input.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        Map<String, char[]> response = new HashMap<>();
        response.put("word", chars);

        return ResponseEntity.ok(response);
    }
}