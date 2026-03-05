package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. показать задачи");
            System.out.println("2. добавить задачу");
            System.out.println("3. удалить задачу");
            System.out.println("4. редактировать задачу");
            System.out.println("0. выход");
            System.out.print("выберите: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                showTasks();
            } else if (choice == 2) {
                addTask();
            } else if (choice == 3) {
                deleteTask();
            } else if (choice == 4) {
                editTask();
            } else if (choice == 0) {
                saveTasks();
                break;
            } else {
                System.out.println("ошибка");
            }
        }
        loadTasks();
    }


    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("нет задач");
        } else {
            System.out.println("\nзадачи:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }


    private static void addTask() {
        System.out.print("введите задачу: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("готово!");
        saveTasks();
    }


    private static void deleteTask() {
        showTasks();
        if (!tasks.isEmpty()) {
            System.out.print("номер для удаления: ");
            int num = scanner.nextInt() - 1;
            if (num >= 0 && num < tasks.size()) {
                tasks.remove(num);
                System.out.println("удалено!");
                saveTasks();
            } else {
                System.out.println("неверный номер!");
            }
        }
    }


    private static void editTask() {
        showTasks();
        if (!tasks.isEmpty()) {
            System.out.print("номер для редактирования: ");
            int num = scanner.nextInt() - 1;
            scanner.nextLine();
            if (num >= 0 && num < tasks.size()) {
                System.out.print("новый текст: ");
                String name = scanner.nextLine();
                tasks.set(num, new Task(name));
                System.out.println("готово!");
                saveTasks();
            } else {
                System.out.println("неверный номер!");
            }
        }
    }


    private static void saveTasks() {
        try {
            PrintWriter pw = new PrintWriter(FILE_NAME);
            for (Task s : tasks) {
                pw.println(s);
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("ошибка сохранения");
        }
    }


    private static void loadTasks() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = br.readLine()) != null) {
                String name = scanner.nextLine();
                tasks.add(new Task(name));
            }
            br.close();
        } catch (Exception e) {
        }
    }
}