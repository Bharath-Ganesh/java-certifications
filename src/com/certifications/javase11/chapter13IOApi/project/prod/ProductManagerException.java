package src.com.certifications.javase11.chapter13IOApi.project.prod;

//3. Create a custom exception class, ProductManagerException
/*
This is a Checked exception as it extends the Exception class.
For Unchecked Exception, it should extends RuntimeException or Error class.
 */
public class ProductManagerException extends Exception{

    public ProductManagerException() {
        super();
    }

    public ProductManagerException(String message) {
        super(message);
    }

    public ProductManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
