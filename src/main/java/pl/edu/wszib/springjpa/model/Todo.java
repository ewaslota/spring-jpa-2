package pl.edu.wszib.springjpa.model;

import jakarta.persistence.*;

@Entity
public class Todo {
    public enum TodoStatus {
        NEW,
        IN_PROGRESS,
        COMPLETED
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String dueDate;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }
}
