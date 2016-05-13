package projects;

import java.sql.Date;

public class Project {
    private int id;

    private String name;

    private Date begin;

    private Date deadline;

    public Project(String name, Date begin, Date deadline){
        this.name = name;
        this.begin = begin;
        this.deadline = deadline;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Date getBegin(){
        return begin;
    }

    public Date getDeadline(){
        return deadline;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBegin(Date begin){
        this.begin = begin;
    }

    public void setDeadline(Date deadline){
        this.deadline = deadline;
    }

}
