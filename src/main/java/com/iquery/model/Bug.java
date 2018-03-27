package com.iquery.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.persistence.*;

@Entity
@Table(name = "bug")
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "summary", nullable = false)
    @NotEmpty(message = "Please provide summary")
    private String summary;


    @Column(name = "priority", nullable = false)
    @NotEmpty(message = "Please provide priority")
    private String priority;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User assignee;

    @Column(name = "description")
    private String description;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String username) {
        this.summary = summary;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

}
