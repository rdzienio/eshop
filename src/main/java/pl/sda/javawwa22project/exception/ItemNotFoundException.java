package pl.sda.javawwa22project.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException() {
    }

    public ItemNotFoundException(final String message) {
        super(message);
    }

    public ItemNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(final Throwable cause) {
        super(cause);
    }
}
