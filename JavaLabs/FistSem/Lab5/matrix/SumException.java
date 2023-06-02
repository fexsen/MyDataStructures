package JavaLabs.FistSem.Lab5.matrix;

public class SumException extends RuntimeException{
    private String cause;

    SumException(String cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return this.cause;
    }
}
