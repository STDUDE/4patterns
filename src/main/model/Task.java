package main.model;

import java.sql.Date;

/**
 * Created by Antony on 13.05.2016.
 */
public class Task {
    private int id;
    private String content;
    private int project;
    private Date deadline;
    private boolean status;

    public Task(int id, String content, int project, Date deadline, boolean status){
        this.id = id;
        this.content = content;
        this.project = project;
        this.deadline = deadline;
        this.status = status;
    }

    public Task(String content, int project, Date deadline, boolean status){
        this.content = content;
        this.project = project;
        this.deadline = deadline;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getProject() {
        return project;
    }

    public boolean isFinished() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (!status)
            return "Содержание задания: " + content + "\nDeadline: "+ deadline + "\nСтатус: ВЫПОЛНЯЕТСЯ";
        else
            return "Сожержание задания: " + content + "\nDeadline: "+ deadline + "\nСтатус: ЗАВЕРШЕН";
    }
}
