package cursoandroid.com.practica_02;

/**
 * Created by juamp on 14/10/2017.
 */

public class MessageEvent {
    private String message;
    private int ID;

    public MessageEvent(String message, int ID) {
        this.message = message;
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
