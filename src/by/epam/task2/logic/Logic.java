package by.epam.task2.logic;

import by.epam.task2.enity.Note;
import by.epam.task2.enity.Notepad;

public class Logic {

    public static void addNote(Notepad notepad, Note note){
        notepad.getListNotes().add(note);
    }

    public static void removeNote(Notepad notepad ,Note note){
        notepad.getListNotes().add(note);
    }

    public static Note getNoteByName(Notepad notepad, String name){
        Note note = null;
        if (name != null){
            for (int i = 0; i < notepad.getListNotes().size(); i++) {
                if (notepad.getListNotes().get(i).equals(name)){
                    note = notepad.getListNotes().get(i);
                    break;
                }

            }
        }
        return note;
    }
}
