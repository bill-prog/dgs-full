package com.digitalgamestore.dgsbe.exception;

public class ResponseException extends RuntimeException {
    public ResponseException() {
        super();
    }

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }


}
