package users;

import main.DatabaseSupport;

public class Manager implements Command{
    private User user;

    DatabaseSupport db = new DatabaseSupport();

    public Manager(User user){
        this.user = user;
    }

    @Override
    public void setToTask(int task) {
        user.setTask(task);
        db.connect();
        db.updateAndDelete("UPDATE employee SET task = " + task + " WHERE fname = '" + user.getFName() + "' AND lname = '" + user.getLName()+"'");
        db.closeConnect();
    }

}