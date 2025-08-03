package com.example.convertergame;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*") // Allow all origins - adjust for production
public class GameController {

    private Map<String, Converter> converters = new HashMap<>();
    private Player player = new Player();

    public GameController() {
        // Register converters
        addConverter(new MeterToKilometerConverter());
        addConverter(new LiterToMilliliterConverter());
        addConverter(new CelsiusToFahrenheitConverter());
    }

    private void addConverter(Converter conv) {
        converters.put(conv.getType(), conv);
    }

    // Endpoint to get list of converter types
    @GetMapping("/converters")
    public List<String> getConverters() {
        return converters.keySet().stream().collect(Collectors.toList());
    }

    // Convert endpoint
    @PostMapping(value = "/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> convert(@RequestBody Map<String, Object> request) {
        String type = (String) request.get("type");
        Double value = ((Number) request.get("value")).doubleValue();

        Converter conv = converters.get(type);
        if (conv == null) {
            return Map.of("error", "Invalid converter type");
        }

        double result = conv.convert(value);
        return Map.of("result", result, "unit", conv.getUnit());
    }

    // Check answer endpoint
    @PostMapping(value = "/answer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> checkAnswer(@RequestBody Map<String, Object> request) {
        String type = (String) request.get("type");
        Double value = ((Number) request.get("value")).doubleValue();
        Double userAnswer = ((Number) request.get("userAnswer")).doubleValue();

        Converter conv = converters.get(type);
        if (conv == null) {
            return Map.of("error", "Invalid converter type");
        }

        double actual = conv.convert(value);
        boolean correct = Math.abs(userAnswer - actual) < 0.01; // Allow small decimal error

        if (correct) {
            player.addPoints(10);
        }

        return Map.of("correct", correct, "actual", actual, "score", player.getScore());
    }
}
