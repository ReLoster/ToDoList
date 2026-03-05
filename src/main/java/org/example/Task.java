package org.example;

public class Task {
    private String name;
    private boolean itDone;


    public Task(String name) {
        this.name = name;
        this.itDone = false;
    }

    public String getName() {
        return name;
    }

    public void setDone(boolean done) {
        itDone = done;
    }

    public String toString() {
        return name;
    }
}

