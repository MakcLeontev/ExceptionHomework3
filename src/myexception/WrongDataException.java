package myexception;

public class WrongDataException extends RuntimeException {
    public WrongDataException(String message) {
        super("неверные данные: " + message);
    }
}
