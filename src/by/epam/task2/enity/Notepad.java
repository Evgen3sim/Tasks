package by.epam.task2.enity;

import java.util.ArrayList;
import java.util.List;

public class Notepad {

    List<Note> listNotes = new ArrayList<Note>();

    public List<Note> getListNotes() {
        return listNotes;
    }

    public void setListNotes(List<Note> listNotes) {
        this.listNotes = listNotes;
    }

    @Override
    public String toString() {
        return "Notepad{" +
                "listNotes=" + listNotes +
                '}';
    }
}
