package by.epam.task1.dao;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import by.epam.task1.enity.Book;
import by.epam.task1.enity.Catalog;


public class Dao {

    private static Scanner x;

    public static void addBook(String name, String author, Boolean electron){

        try (FileWriter fileWriter = new FileWriter("src/by/epam/task1/resources/catalog", true)){
            String newLine = name + "|" + author + "|" + electron + "\n";
            fileWriter.write(newLine);
            fileWriter.flush();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static java.util.List<Book> addToList(Catalog catalog){
        String line = " ";
        String[] word;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/by/epam/task1/resources/catalog"))){
            while ((line = bufferedReader.readLine()) != null){
                word = line.split("\\|");
                catalog.getBookList().add(new Book(word[0], word[1], word[2]));

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return catalog.getBookList();
    }

    public static void search(String searchName){
        boolean found = false;
        String name = " "; String author = " "; String electrinoc = " ";
        try {
            x = new Scanner(new File("src/by/epam/task1/resources/catalog"));
            x.useDelimiter("[|,\n]");

            while (x.hasNext() && !found){
                name = x.next();
                author = x.next();
                electrinoc = x.next();

                if (name.equals(searchName)){
                    found = true;
                }
            }

            if (found){
                System.out.println(name + "|" + author + "|" + electrinoc);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAdmin(String login, String password){
        boolean found = false;
        String tempUserName = "";
        String tempPassword = "";
        String admin = "";

        try {
            x = new Scanner(new File("src/by/epam/task1/resources/users"));
            x.useDelimiter("[|\n]");
            while (x.hasNext() && !found) {
                tempUserName = x.next();
                tempPassword = x.next();
                admin = x.next();
                if (tempUserName.trim().equals(login.trim()) && tempPassword.trim().equals(password.trim()) && admin.trim().equals("true")) {
                    found = true;
                }
            }
            x.close();
            System.out.println(found);
        } catch (Exception e){
            System.out.println("Error");
        }
        return found;
    }
    public static boolean isUser(String login, String password, String admin){
        boolean found = false;
        String tempUserName = "";
        String tempPassword = "";
        String tempAdmin = "";

        try {
            x = new Scanner(new File("src/by/epam/task1/resources/users"));
            x.useDelimiter("[|\n]");
            while (x.hasNext() && !found) {
                tempUserName = x.next();
                tempPassword = x.next();
                tempAdmin = x.next();
                if (tempUserName.trim().equals(login.trim()) && tempPassword.trim().equals(password.trim()) && admin.trim().equals(admin.trim())) {
                    found = true;
                }
            }
            x.close();
            System.out.println(found);
        } catch (Exception e){
            System.out.println("Error");
        }
        return found;
    }

    public static void addUser(String login, String password){
        try {
            // String name = " ";
            File sttText = new File("src/by/epam/task1/resources/users");
            FileOutputStream is = new FileOutputStream(sttText, true);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(login + "|" + password + "|" + "false" + "\n");
            w.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
