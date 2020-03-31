package demo;

import users.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SorterDemo {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иванов Иван Иванович", 21, 403));
        students.add(new Student("Абриков Алекс Петрович", 20, 303));
        students.add(new Student("Петров Пётр Петрович", 18, 203));

        students.forEach(s -> System.out.printf("%s\t%d\t%d\n", s.getName(), s.getAge(), s.getGroupNumber()));
        System.out.println("\nСортировка по имени:");

        Map<String, Student> studentsSortByName = new TreeMap<>();
        students.forEach(s -> studentsSortByName.put(s.getName() + s.hashCode(), s));

        studentsSortByName.entrySet().forEach(s -> System.out.printf("%s\t%d\t%d\n",
                s.getValue().getName(),
                s.getValue().getAge(),
                s.getValue().getGroupNumber()));

        System.out.println("\nСортировка по возрасту в обратном порядке:");

        Map<String, Student> studentsSortByAge = new TreeMap<>(Collections.reverseOrder());
        students.forEach(s -> studentsSortByAge.put(s.getAge() + " " + s.hashCode(), s));

        studentsSortByAge.entrySet().forEach(s -> System.out.printf("%s\t%d\t%d\n",
                s.getValue().getName(),
                s.getValue().getAge(),
                s.getValue().getGroupNumber()));
    }

}
