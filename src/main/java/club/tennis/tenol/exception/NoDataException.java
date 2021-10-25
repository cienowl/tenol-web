package club.tennis.tenol.exception;

public class NoDataException extends Exception {
    public NoDataException(String message) {
        super(message);
    }
    public NoDataException(Exception e) {
        super(e);
    }
}
