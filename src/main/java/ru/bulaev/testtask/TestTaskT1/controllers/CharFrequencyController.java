package ru.bulaev.testtask.TestTaskT1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@RestController
public class CharFrequencyController {

    /**
     * Рассчитывает частоту встречи символов в заданной строке.
     *
     * @param input Строка, для которой нужно вычислить частоту символов.
     * @return Map, содержащая частоту встречи символов, отсортированную по убыванию.
     */
    @GetMapping("/charFrequency")
    public Map<Character, Long> getCharFrequency(@RequestParam String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
