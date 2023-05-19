import java.util.*;

public class program {
    public static void main(String[] args) {
        ex01();
        ex02();

    }

    static void ex01() {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
        // человек может иметь несколько телефонов.

        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Иванов", "978636345656");
        phonebook.add("Петров", "45634637");
        System.out.println(phonebook.getByLastName("Иванов"));
        phonebook.add("Сидоров", "78467");
        phonebook.add("Петров", "34635737");
        phonebook.add("Иванов", "47567563");
        System.out.println(phonebook.getAllBook());
        System.out.println("Another style of printing");
        System.out.println(phonebook.getAllBook2());

    }

    static void ex02() {
        // Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова,
        // Анна Мусина, Анна Крутова, Иван Юрин,
        // Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова,
        // Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников,
        // Петр Петин, Иван Ежов.
        // Написать программу, которая найдет и выведет повторяющиеся имена с
        // количеством повторений. Отсортировать по убыванию популярности. Для
        // сортировки использовать TreeMap.

        String line = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, "
                +
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

        line = line.replace("/n", " ");
        line = line.replace(",", "");
        String[] words = line.split(" ");
        String[] names = new String[words.length / 2];
        int y = 0;
        for (int i = 0; i < names.length; i++) {
            names[i] = words[y];
            y = y + 2;
        }

        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());

        for (String name : names) {
            int count = frequency(names, name);
            if (map.containsKey(count)) {
                List<String> list = map.get(count);
                if (list.contains(name)) {
                    continue;
                } else {
                    list.add(name);
                }
            } else {
                List<String> list = new ArrayList<>();
                list.add(name);
                map.put(count, list);

            }
        }

        System.out.println(map);
    }

    static Integer frequency(String[] list, String element) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String el : list) {
            if (map.containsKey(el)) {
                int i = map.get(el);
                i = i + 1;
                map.remove(el);
                map.put(el, i);
            } else {
                map.put(el, 1);
            }
        }

        return map.get(element);

    }

}