package kr.co.dinner41.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class ReviewVO {
    private int id;
    private StoreVO store;
    private UserVO user;
    private double score;
    private Timestamp date;

    public ReviewVO() {
    }

    public ReviewVO(int id, StoreVO store, UserVO user, double score, Timestamp date) {
        this.id = id;
        this.store = store;
        this.user = user;
        this.score = score;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StoreVO getStore() {
        return store;
    }

    public void setStore(StoreVO store) {
        this.store = store;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReviewVO{" +
                "id=" + id +
                ", store=" + store +
                ", user=" + user +
                ", score=" + score +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewVO reviewVO = (ReviewVO) o;
        return id == reviewVO.id &&
                Double.compare(reviewVO.score, score) == 0 &&
                Objects.equals(store, reviewVO.store) &&
                Objects.equals(user, reviewVO.user) &&
                Objects.equals(date, reviewVO.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, store, user, score, date);
    }
}
