package club.tennis.tenol.exception;

public class WrongRequestException extends Exception {
    public WrongRequestException(String message) {
        super(message);
    }
    public WrongRequestException(Exception e) {
        super(e);
    }
}
