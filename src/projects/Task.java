package projects;

import main.DatabaseSupport;

import java.sql.Date;
import java.util.ArrayList;

public class Task {
    private ArrayList<Observer> observers = new ArrayList();
    private DatabaseSupport db = new DatabaseSupport();

    private int id;

    private String content;

    private Date deadline;

    private  boolean status;

    private int project_id;

    public Task(String content, Date deadline, int project_id){
        this.content = content;
        this.project_id = project_id;
        this.deadline = deadline;
    }

    public int getId(){
        return id;
    }

    public int getProjId(){
        return project_id;
    }

    public String getContent(){
        return content;
    }

    public Date getDeadline(){
        return deadline;
    }

    public boolean getStatus(){
        return status;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setStatus(boolean status){
        this.status = status;
        db.connect();
        db.updateAndDelete("UPDATE task SET status = " + status + " WHERE content = '" + this.content + "'");
        db.closeConnect();
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setDeadline(Date deadline){
        this.deadline = deadline;
    }

}
