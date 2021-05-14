package ch.bbzw.terminator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @SequenceGenerator(allocationSize = 1, name = "task_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private Date taskDate;

    @Column(nullable = false)
    private String taskTitel;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean taskDone;

    public Task(final long _userId, final Date _taskDate, final String _taskTitel, final String _description, final Boolean _taskDone) {
        this.userId = _userId;
        this.taskDate = _taskDate;
        this.taskTitel = _taskTitel;
        this.description = _description;
        this.taskDone = _taskDone;
    }

    public long getTaskId() {
        return id;
    }
    public long getUserID() {
        return userId;
    }
    public Date getTaskDate() {
        return taskDate;
    }
    public String getTaskTitel() {
        return taskTitel;
    }
    public String getDescription() {
        return description;
    }
    public Boolean getTaskDone() {
        return taskDone;
    }

    @Override
    public String toString() {
        return String.format("Task - Id: %d, userID: %d, taskDate: %s, taskTitel: %s, description: %s, taskDone: %d", id, userId, taskDate.toString(), taskTitel, description, taskDone);
    }
}
