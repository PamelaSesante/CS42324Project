
package phantasianbistrodemo;

public class NotEnoughMoneyException extends Exception{

    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String msg) {
        super(msg);
    }
}
