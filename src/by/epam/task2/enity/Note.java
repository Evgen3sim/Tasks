package by.epam.task2.enity;

import java.util.Objects;

public class Note {
    private String name;
    private String data;
    private String email;
    private String message;

    public Note() {
    }

    public Note(String name, String data, String email, String message) {
        this.name = name;
        this.data = data;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(name, note.name) &&
                Objects.equals(data, note.data) &&
                Objects.equals(email, note.email) &&
                Objects.equals(message, note.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, data, email, message);
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\''  +
                '}' + "\n";
    }
}
