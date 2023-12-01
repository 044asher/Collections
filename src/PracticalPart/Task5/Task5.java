package PracticalPart.Task5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        final int arraySize = 1_000_000;
        Random random = new Random();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < arraySize; i++) {
            int randNum = random.nextInt();
            arrayList.add(randNum);
            linkedList.add(randNum);
        }

        testingTime(arrayList, "ArrayList");
        testingTime(linkedList, "LinkedList");

        }

        public static void testingTime(List<Integer> list, String name) {
            long startTime, endTime;
            int index = list.size() / 2 - 3100;


            System.out.println("\nТестируем: " + name + ":");

            // Тестируем добавление в конец списка:
            startTime = System.nanoTime();
            list.add(15);
            endTime = System.nanoTime();
            System.out.println("Добавление в конец " + name + ":\t" + (endTime - startTime) + " nano sec.");

            // Тестируем добавление в первую половину списка
            startTime = System.nanoTime();
            list.add(index, 15);
            endTime = System.nanoTime();
            System.out.println("Добавление в первую половину " + name + ":\t" + (endTime - startTime) + " nano sec.");

            // Тестируем получение элемента с конца списка
            startTime = System.nanoTime();
            list.get(list.size() - 1);
            endTime = System.nanoTime();
            System.out.println("Получение элемента с конца " + name + ":\t" + (endTime - startTime) + " nano sec.");

            // Получение элемента из первой половины
            startTime = System.nanoTime();
            list.get(index);
            endTime = System.nanoTime();
            System.out.println("Получение элемента с первой половины " + name + ":\t" + (endTime - startTime) + " nano sec.");

            // Удаление элемента с конца списка
            startTime = System.nanoTime();
            list.remove(list.size() - 1);
            endTime = System.nanoTime();
            System.out.println("Удаление элемента с конца " + name + ":\t" + (endTime - startTime) + " nano sec.");

            // Удаление элемента с первой половины списка
            startTime = System.nanoTime();
            list.remove(index);
            endTime = System.nanoTime();
            System.out.println("Удаление элемента с первой половины " + name + ":\t" + (endTime - startTime) + " nano sec.");

        }
    }
