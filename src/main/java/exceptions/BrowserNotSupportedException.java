package exceptions;

public class BrowserNotSupportedException extends RuntimeException {

    public BrowserNotSupportedException(String browser) {
        super(String.format("[%s] browser not supported in [%s].", browser, System.getProperty("os.name")));
    }
}
