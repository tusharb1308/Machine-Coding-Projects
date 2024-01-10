package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.exception;

public class GroupNotFoundException extends Exception{
    public GroupNotFoundException(){}

    public GroupNotFoundException(String message){
        super(message);
    }

    public GroupNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
