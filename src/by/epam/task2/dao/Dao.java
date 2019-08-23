package by.epam.task2.dao;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.task2.enity.Note;
import by.epam.task2.enity.Notepad;
import by.epam.task2.logic.Logic;

public class Dao {

    private static Scanner x;

    public static void getContent() {

    }

    public static void addToListNotes(Notepad notepad) {
        String line = "";
        String[] word;
        try (BufferedReader br = new BufferedReader(new FileReader("src/by/epam/task2/resources/notes"))) {
            while ((line = br.readLine()) != null) {
                word = line.split("\\|");
                notepad.getListNotes().add(new Note(word[0], word[1], word[2], word[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToFile(String name, String date, String email, String mess) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            try (FileWriter fileWriter = new FileWriter("src/by/epam/task2/resources/notes", true)) {
                dateTimeFormatter.parse(date);
                String newLine = name + "|" + date + "|" + email + "|" + mess + "|" + "\n";
                fileWriter.write(newLine);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Mail entered incorrectly");
        }
    }

    public static List<Note> searchByName(String searchName) {

        List<Note> noteList = null;
        try {
            String[] values = null;
            x = new Scanner(new File("src/by/epam/task2/resources/notes"));
            x.useDelimiter("\\n");

            noteList = new ArrayList<>();
            while (x.hasNext()) {
                String line = x.next();

                values = line.split("\\|");

                if (values[0].equals(searchName)) {
                    Note note = new Note();

                    note.setName(values[0]);
                    note.setData(values[1]);
                    note.setEmail(values[2]);
                    note.setMessage(values[3]);

                    noteList.add(note);
                }
            }

            noteList.sort(new Comparator<Note>() {
                @Override
                public int compare(Note o1, Note o2) {
                    int nameSort = o1.getName().compareTo(o2.getName());
                    int dateSort = o1.getData().compareTo(o2.getData());
                    int emailSort = o1.getEmail().compareTo(o2.getEmail());
                    int messageSort = o1.getMessage().compareTo(o2.getMessage());

                    int result = 0;
                    if (nameSort == 0) {
                        if (dateSort == 0) {
                            if (emailSort == 0) {
                                result = messageSort;
                            } else {
                                result = emailSort;
                            }
                        } else {
                            result = dateSort;
                        }
                    } else {
                        result = nameSort;
                    }
                    return result;
                }
            });

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
        return noteList;
    }

    public static List<Note> searchByDate(String searchDate) {

        List<Note> noteList = null;
        try {
            String[] values = null;
            x = new Scanner(new File("src/by/epam/task2/resources/notes"));
            x.useDelimiter("\\n");

            noteList = new ArrayList<>();
            while (x.hasNext()) {
                String line = x.next();

                values = line.split("\\|");

                if (values[1].equals(searchDate)) {
                    Note note = new Note();

                    note.setName(values[0]);
                    note.setData(values[1]);
                    note.setEmail(values[2]);
                    note.setMessage(values[3]);

                    noteList.add(note);
                }
            }

            noteList.sort(new Comparator<Note>() {
                @Override
                public int compare(Note o1, Note o2) {
                    int nameSort = o1.getName().compareTo(o2.getName());
                    int dateSort = o1.getData().compareTo(o2.getData());
                    int emailSort = o1.getEmail().compareTo(o2.getEmail());
                    int messageSort = o1.getMessage().compareTo(o2.getMessage());

                    int result = 0;
                    if (nameSort == 0) {
                        if (dateSort == 0) {
                            if (emailSort == 0) {
                                result = messageSort;
                            } else {
                                result = emailSort;
                            }
                        } else {
                            result = dateSort;
                        }
                    } else {
                        result = nameSort;
                    }
                    return result;
                }
            });

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
        return noteList;
    }

    public static List<Note> searchByEmail(String searchEmail) {

        List<Note> noteList = null;
        try {
            String[] values = null;
            x = new Scanner(new File("src/by/epam/task2/resources/notes"));
            x.useDelimiter("\\n");

            noteList = new ArrayList<>();
            while (x.hasNext()) {
                String line = x.next();

                values = line.split("\\|");

                if (values[2].equals(searchEmail)) {
                    Note note = new Note();

                    note.setName(values[0]);
                    note.setData(values[1]);
                    note.setEmail(values[2]);
                    note.setMessage(values[3]);

                    noteList.add(note);
                }
            }

            noteList.sort(new Comparator<Note>() {
                @Override
                public int compare(Note o1, Note o2) {
                    int nameSort = o1.getName().compareTo(o2.getName());
                    int dateSort = o1.getData().compareTo(o2.getData());
                    int emailSort = o1.getEmail().compareTo(o2.getEmail());
                    int messageSort = o1.getMessage().compareTo(o2.getMessage());

                    int result = 0;
                    if (nameSort == 0) {
                        if (dateSort == 0) {
                            if (emailSort == 0) {
                                result = messageSort;
                            } else {
                                result = emailSort;
                            }
                        } else {
                            result = dateSort;
                        }
                    } else {
                        result = nameSort;
                    }
                    return result;
                }
            });

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
        return noteList;
    }

    public static List<Note> searchByMess(String searchMess) {

        List<Note> noteList = null;
        try {
            String[] values = null;
            x = new Scanner(new File("src/by/epam/task2/resources/notes"));
            x.useDelimiter("\\n");

            noteList = new ArrayList<>();
            while (x.hasNext()) {
                String line = x.next();

                values = line.split("\\|");

                if (values[3].equals(searchMess)) {
                    Note note = new Note();

                    note.setName(values[0]);
                    note.setData(values[1]);
                    note.setEmail(values[2]);
                    note.setMessage(values[3]);

                    noteList.add(note);
                }
            }

            noteList.sort(new Comparator<Note>() {
                @Override
                public int compare(Note o1, Note o2) {
                    int nameSort = o1.getName().compareTo(o2.getName());
                    int dateSort = o1.getData().compareTo(o2.getData());
                    int emailSort = o1.getEmail().compareTo(o2.getEmail());
                    int messageSort = o1.getMessage().compareTo(o2.getMessage());

                    int result = 0;
                    if (nameSort == 0) {
                        if (dateSort == 0) {
                            if (emailSort == 0) {
                                result = messageSort;
                            } else {
                                result = emailSort;
                            }
                        } else {
                            result = dateSort;
                        }
                    } else {
                        result = nameSort;
                    }
                    return result;
                }
            });

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
        return noteList;
    }


    public static String getNotesByName(Notepad notepad, String name) {
        List<Note> newNotesList = new ArrayList<Note>();
        for (int i = 0; i < notepad.getListNotes().size(); i++) {
            if (notepad.getListNotes().get(i).getName().equals(name)) {
                newNotesList.add(Logic.getNoteByName(notepad, notepad.getListNotes().get(i).getName()));
            }
        }
        return format(newNotesList);
    }

    private static String format(List<Note> noteList) {
        String str = "";
        for (int i = 0; i < noteList.size(); i++) {
            str += noteList.get(i) + "\n";
        }
        return str;
    }

}
