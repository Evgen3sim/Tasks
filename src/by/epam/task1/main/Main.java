package by.epam.task1.main;

import java.util.Scanner;

import by.epam.task1.dao.Dao;
import by.epam.task1.enity.Catalog;

/*Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.
• Существующие роли: пользователь, администратор.
• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
книг в каталоге.
• Администратор может модифицировать каталог.
• *При добавлении описания книги в каталог оповещение о ней рассылается на
e-mail всем пользователям
• **При просмотре каталога желательно реализовать постраничный просмотр
• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
администратору на e-mail.
• Каталог книг хранится в текстовом файле.
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
не хранится в открытом виде*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();
        String str = "";
        while (!(str.equals("Y") && str.equals("y"))){
            System.out.println("1. Log in as user");
            System.out.println("2. Log in as admin");
            System.out.println("3. Add user");
            switch (str = scanner.nextLine()){
                case "1":
                    System.out.println("Enter login and password");
                    if (Dao.isUser(scanner.nextLine(), scanner.nextLine(), "false")){
                        asUser(scanner, catalog);
                    }
                    break;
                case "2":
                    System.out.println("Enter login and password");
                    if (Dao.isAdmin(scanner.nextLine(), scanner.nextLine())){
                        asAdmin(scanner, catalog);
                    }
                    break;
                case "3":
                    System.out.println("Enter login and password");
                    Dao.addUser(scanner.nextLine(), scanner.nextLine());
                    break;
            }
            scanner.nextLine();
        }
    }

    private static void asUser(Scanner scanner, Catalog catalog){
        String str = "";
        while (!(str.equals("Y") && str.equals("y"))){
            System.out.println("1. Show catalog");
            System.out.println("2. Search book");
            System.out.println("3. Back");
            switch (str = scanner.nextLine()){
                case "1":
                    Dao.addToList(catalog);
                    System.out.println(catalog.getBookList());
                    break;
                case "2":
                    System.out.println("Enter book name");
                   Dao.search(scanner.nextLine());
                    break;
                case "3":
                   return;
            }
            scanner.nextLine();
        }
    }

    private static void asAdmin(Scanner scanner, Catalog catalog){
        String str = "";
        while (!(str.equals("Y") && str.equals("y"))){
            System.out.println("1. Add book");
            System.out.println("2. Back");
            switch (str = scanner.nextLine()){
                case "1":
                    System.out.println("Enter name, author and format(true - electronic, false - paper)");
                    Dao.addBook(scanner.nextLine(), scanner.nextLine(), scanner.nextBoolean());
                    break;
                case "2":
                    return;
            }
            scanner.nextLine();
        }
    }
}
