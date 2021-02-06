package ru.java2;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Задание 1
        String[] words = {
                "Яблоко",
                "Апельсин",
                "Груша",
                "Мандарин",
                "Манго",
                "Яблоко",
                "Черешня",
                "Слива",
                "Яблоко",
                "Мандарин",
                "Груша"
        };


        Set<String> set = new HashSet<>(Arrays.asList(words));
        set.forEach(i -> System.out.print(i + " "));
        System.out.println();
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            int val = map.getOrDefault(word, 0) + 1;
            map.put(word, val);
        }
        map.forEach((k, v) -> System.out.println(k+" : "+v));

        // Задание 2

        Catalog catalog = new Catalog();

        catalog.add("Иванов", "8-916-111-11-11");
        catalog.add("Соболев", "8-916-222-11-11");
        catalog.add("Петров", "8-916-333-11-11");
        catalog.add("Сидоров", "8-916-444-11-11");
        catalog.add("Иванов", "8-916-555-11-11");
        catalog.add("Петров", "8-916-666-11-11");
        catalog.add("Плужников", "8-916-777-11-11");

        System.out.println(catalog.get("Петров"));


    }
}
