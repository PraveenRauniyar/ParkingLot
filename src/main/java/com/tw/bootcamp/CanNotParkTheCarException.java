package com.tw.bootcamp;

public class CanNotParkTheCarException extends Throwable {
    /**
     * Constructs a new throwable with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     * <p>
     * <p>The {@link #fillInStackTrace()} method is called to initialize
     * the stack trace data in the newly created throwable.
     */
    public CanNotParkTheCarException(String message) {
        super("Can not park the car : "+ message);
    }
}
