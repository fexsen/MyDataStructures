package JavaLabs.FistSem.Lab5.matrix;

public class MulMatrixException extends RuntimeException{
    private String cause;

    MulMatrixException(String cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return this.cause;
    }
}
