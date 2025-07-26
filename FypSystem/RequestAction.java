package FypSystem;

public abstract class RequestAction {
    public String name;
    public abstract void display();
    public abstract boolean approve();
    public abstract boolean reject();
}

