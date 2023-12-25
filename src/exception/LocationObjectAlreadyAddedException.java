package exception;

public class LocationObjectAlreadyAddedException extends RuntimeException{
    public LocationObjectAlreadyAddedException(){}
    public LocationObjectAlreadyAddedException(String msg){
        super(msg);
    }
}
