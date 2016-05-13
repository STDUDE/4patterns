package projects;

public abstract class Observer {
    protected Task subject;
    public abstract void update();
}
