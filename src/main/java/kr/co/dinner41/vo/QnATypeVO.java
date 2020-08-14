package kr.co.dinner41.vo;

import java.util.Objects;

public class QnATypeVO {
    private int id;
    private String name;

    public QnATypeVO() {
    }

    public QnATypeVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QnATypeVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QnATypeVO qnATypeVO = (QnATypeVO) o;
        return id == qnATypeVO.id &&
                Objects.equals(name, qnATypeVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
