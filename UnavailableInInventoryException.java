package phantasianbistrodemo;

public class UnavailableInInventoryException extends Exception{

    public UnavailableInInventoryException() {
    }

    public UnavailableInInventoryException(String msg) {
        super(msg);
    }
}
