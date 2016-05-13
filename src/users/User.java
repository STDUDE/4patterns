package users;

import main.DatabaseSupport;
import projects.Observer;
import projects.Task;

public class User extends Observer{
    private String fname;
    private String lname;
    private String post;
    private int task;
    private Task taskObj;
    private DatabaseSupport db = new DatabaseSupport();

    public User(String fname, String lname, String post, int task, Task taskObj){
        this.fname = fname;
        this.lname = lname;
        this.post = post;
        this.task = task;
        this.taskObj = taskObj;
        if(this.taskObj != null)
            this.taskObj.attach(this);
    }

    @Override
    public void update() {
        if(taskObj.getStatus() == true) {
            task = -1;
            db.connect();
            db.updateAndDelete("UPDATE employee SET task = -1 WHERE fname = '" + fname + "' AND lname = '" + lname + "'");
            db.closeConnect();
        }
    }

    public String getFName(){
        return fname;
    }

    public String getLName(){
        return lname;
    }

    public String getPost(){
        return post;
    }

    public int getTask(){
        return task;
    }

    public void setFName(String fname){
        this.fname = fname;
    }

    public void setLName(String lname){
        this.lname = lname;
    }

    public void setPost(String post){
        this.post = post;
    }

    public void setTask(int task){
        this.task = task;
    }

    public String toString(){
        return fname + " - " + lname + " - " + post;
    }

}
