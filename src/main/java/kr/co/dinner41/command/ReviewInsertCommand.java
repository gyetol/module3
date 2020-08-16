package kr.co.dinner41.command;

public class ReviewInsertCommand {
    private String score;
    private String content;
    private String storeId;
    private String orderId;

    public ReviewInsertCommand(){}

    public ReviewInsertCommand(String score, String content, String storeId, String orderId) {
        this.score = score;
        this.content = content;
        this.storeId = storeId;
        this.orderId = orderId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
