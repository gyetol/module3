package kr.co.dinner41.command;

public class ReviewInsertCommand {
    private int score;
    private String content;

    public ReviewInsertCommand(){}

    public ReviewInsertCommand(int score, String content) {
        this.score = score;
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
