package JavaLabs.FistSem.Lab5.matrix;

public class BadRangeMatrixException extends RuntimeException{
    private String cause;

    BadRangeMatrixException(String cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return this.cause;
    }
}
