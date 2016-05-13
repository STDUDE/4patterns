package main;

import main.model.Employee;
import main.model.Project;
import main.model.Task;
import main.requests.IRequest;
import main.requests.RequestCreator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Antony on 13.05.2016.
 */
public class Work {
    private static String choice;
    private static String choiceBook;
    private static Scanner sc = new Scanner(System.in);
    private static RequestCreator requestCreator = new RequestCreator();
    private static IRequest iRequest;

    public static void runConsol() throws ClassNotFoundException, SQLException {
        while (true) {
            printMenu();
            choice = sc.nextLine();
            if (choice.compareTo("1") == 0) {
                dataView();
            } else if (choice.compareTo("2") == 0) {
                dataAdd();
            } else if (choice.compareTo("3") == 0) {
                dataUpdate();
            } else if (choice.compareTo("4") == 0) {
                return;
            }
        }
    }

    public static void dataView() throws SQLException {
        while (true) {
            printMenu1();
            choice = sc.nextLine();
            if (choice.compareTo("1") == 0) {
                iRequest = requestCreator.ConcreteRequestCreator("SelectEmployeesReq");
                iRequest.GenerateRequest();
                ArrayList employees = iRequest.GetResponse();
                iRequest = requestCreator.ConcreteRequestCreator("SelectTasksReq");
                iRequest.GenerateRequest();
                ArrayList tasks = iRequest.GetResponse();
                iRequest = requestCreator.ConcreteRequestCreator("SelectProjectsReq");
                iRequest.GenerateRequest();
                ArrayList projects = iRequest.GetResponse();
                System.out.println("\n\nСПИСОК РАБОТНИКОВ\n");
                for (Object employee : employees)  System.out.println(employee.toString());
                System.out.println("\nСПИСОК ЗАДАЧ\n");
                for (Object task : tasks)  System.out.println(task.toString());
                System.out.println("\nСПИСОК ПРОЕКТОВ\n\n");
                for (Object project : projects)  System.out.println(project.toString());
            } else if (choice.compareTo("2") == 0) {

            } else if (choice.compareTo("3") == 0) {

                return;
            }
        }
    }

    public static void dataAdd(){
        while (true) {
            printMenu2();
            choice = sc.nextLine();
            if (choice.compareTo("1") == 0) {

            } else if (choice.compareTo("2") == 0) {

            } else if (choice.compareTo("3") == 0) {

            } else if (choice.compareTo("4") == 0) {

                return;
            }
        }
    }

    public static void dataUpdate(){
        while (true) {
            printMenu3();
            choice = sc.nextLine();
            if (choice.compareTo("1") == 0) {

            } else if (choice.compareTo("2") == 0) {
                return;
            }
        }
    }

    public static void printMenu() {//метод вывода меню на экран
        System.out.println("Введите ваш выбор:");
        System.out.println("1.Просмотр данных");
        System.out.println("2.Добавление данных");
        System.out.println("3.Редактирование данных");
        System.out.println("4.Выйти");
    }
    public static void printMenu1() {//метод вывода меню на экран
        System.out.println("Введите ваш выбор:");
        System.out.println("1.Просмотр данных в виде таблицы");
        System.out.println("2.Просмотр данных в виде списка");
        System.out.println("3.Назад");
    }
    public static void printMenu2() {//метод вывода меню на экран
        System.out.println("Введите ваш выбор:");
        System.out.println("1.Добавление проекта");
        System.out.println("2.Добавление таска");
        System.out.println("3.Добавление работника");
        System.out.println("4.Назад");
    }
    public static void printMenu3() {//метод вывода меню на экран
        System.out.println("Введите ваш выбор:");
        System.out.println("1.Обновить статус задачи");
        System.out.println("2.Назад");
    }
}
