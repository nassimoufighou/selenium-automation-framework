package exceptions;

public class BrowserNotSupportedException extends RuntimeException {

    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser [%s] not supported.", browser));
    }

    public BrowserNotSupportedException(String browser, String os) {
        super(String.format("[%s] not supported in [%s]", browser, os));
    }
}
