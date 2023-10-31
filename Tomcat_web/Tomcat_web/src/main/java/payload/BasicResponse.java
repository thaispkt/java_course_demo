package payload;

public class BasicResponse {
    private int statusCode;
    private String message;
    private Object data; // do sau này mình sẽ trả về list user, list product, ... do ko biết
    // trước data type của JSON list trả về

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
