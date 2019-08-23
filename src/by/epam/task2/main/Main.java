package by.epam.task2.main;

import java.util.Scanner;

import by.epam.task2.dao.Dao;
import by.epam.task2.enity.Notepad;

/*Блокнот. Разработать консольное приложение, работающее с Заметками в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
Общие пояснения к практическому заданию.
• В начале работы приложения данные должны считываться из файла, в конце
работы – сохраняться в файл.
• У пользователя должна быть возможность найти запись по любому параметру
или по группе параметров (группу параметров можно определить самостоятельно), получить требуемые записи в отсортированном виде, найти записи, текстовое поле которой содержит определенное слово, а также добавить новую запись.
• Особое условие: поиск, сравнение и валидацию вводимой информации осуществлять с использованием регулярных выражений.
• Особое условие: проверку введенной информации на валидность должен осуществлять код, непосредственно добавляющий информацию.*/

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notepad notepad = new Notepad();
        System.out.println(notepad.getListNotes());
        Dao.addToListNotes(notepad);


        String str = " ";
        while (!(str.equals("Y") && str.equals("y"))){
            System.out.println("1. add note");
            System.out.println("2. search note");
            System.out.println("3. get note list");
            switch (str = scanner.nextLine()){
                case "1":
                    System.out.println("Enter note name, date, email and message, ");
                    Dao.addToFile(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    break;
                case "2":
                    search(scanner);
                    break;
                case "3":
                    System.out.println(notepad.getListNotes());
                    break;
            }
            scanner.nextLine();
        }
    }

    private static void search(Scanner scanner){
        String str = "";
        Notepad notepad = new Notepad();


        while (!(str.equals("Y") && str.equals("y"))){
            System.out.println("1. Search by name");
            System.out.println("2. Search by date");
            System.out.println("3. Search by eMail");
            System.out.println("4. Search by messange");
            System.out.println("5. back");

            switch (str = scanner.nextLine()){
                case "1":
                    System.out.println("Enter name note");
                    System.out.println(Dao.searchByName(scanner.nextLine()));
                    break;
                case "2":
                    System.out.println("Enter date note");
                    System.out.println(Dao.searchByDate(scanner.nextLine()));
                    break;
                case "3":
                    System.out.println("Enter email note");
                    System.out.println(Dao.searchByEmail(scanner.nextLine()));
                    break;
                case "4":
                    System.out.println("Enter mess note");
                    System.out.println(Dao.searchByMess(scanner.nextLine()));
                    break;
                case "5":
                    return;
            }
            scanner.nextLine();
        }
    }
}
