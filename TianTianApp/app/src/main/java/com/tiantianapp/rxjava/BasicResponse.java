package com.tiantianapp.rxjava;

/**
 *
 */
public class BasicResponse<T> {

    private int error_code;
    private String reason;
    private T content;
    private boolean error;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCode() {
        return error_code;
    }

    public void setCode(int code) {
        this.error_code = code;
    }

    public String getMessage() {
        return reason;
    }

    public void setMessage(String message) {
        this.reason = message;
    }
}
