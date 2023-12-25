package exception;

public class SpaceOccupiedException extends RuntimeException{
    public SpaceOccupiedException(){}
    public SpaceOccupiedException(String msg){
        super(msg);
    }
}
