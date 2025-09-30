package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Customer {

    private String id;
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> tags = new HashSet<>();
    private ArrayList<String> notes = new ArrayList<>();

    public boolean addEmail(String email){
        return emails.add(email);
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kund id='" + id + '\'' +
                ", namn='" + name + '\'' +
                ", mejl=" + emails +
                ", taggar=" + tags +
                ", anteckningar=" + notes;
    }

    public boolean removeEmail(String email){
        return emails.remove(email);

    }

    public boolean addTag(String tag){
        return tags.add(tag);
    }

    public boolean addNote(String note){
        return notes.add(note);
    }

    public String condensedInfo() {
        return "Kund id='" + id + '\'' +
                ", namn='" + name + '\'' +
                ", mejl=" + emails +
                ", antal taggar=" + tags.size() +
                ", antal anteckningar=" + notes.size();
    }

}
