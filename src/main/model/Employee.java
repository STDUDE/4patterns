package main.model;

/**
 * Created by Antony on 13.05.2016.
 */
public class Employee {
    private int id;
    private String fname;
    private String lname;
    private String post;
    private int task;

    public Employee(int id, String fname, String lname, String post, int task){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.post = post;
        this.task = task;
    }

    public Employee(String fname, String lname, String post, int task){
        this.fname = fname;
        this.lname = lname;
        this.post = post;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPost() {
        return post;
    }

    public int getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setTask(int task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Имя и фамилия: " + fname + " " + lname + " \nДолжность: " + post + "";
    }
}
