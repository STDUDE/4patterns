package main.model;

import java.util.Date;

/**
 * Created by Antony on 13.05.2016.
 */
public class Project {
    private int id;
    private String name;
    private Date begin;
    private Date deadline;

    public Project(int id, String name, Date begin, Date deadline){
        this.id = id;
        this.name = name;
        this.begin = begin;
        this.deadline = deadline;
    }

    public Project(String name, Date begin, Date deadline){
        this.name = name;
        this.begin = begin;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Наименование: " + name + "\nDeadline: "+ deadline;
    }
}
