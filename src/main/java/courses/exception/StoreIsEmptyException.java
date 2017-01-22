package courses.exception;

/**
 * Created by Vitalii on 21.01.2017.
 */
public class StoreIsEmptyException extends Exception {
    public StoreIsEmptyException(String message) {
        super("Store is empty please add some products");
    }
}
