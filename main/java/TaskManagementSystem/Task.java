package TaskManagementSystem;

public class Task {
    int taskId;
    String desc;
    String due_date;
    boolean completed;

    public Task(int taskId, String desc, String due_date, boolean completed) {
        this.taskId = taskId;
        this.desc = desc;
        this.due_date = due_date;
        this.completed = completed;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", desc='" + desc + '\'' +
                ", due_date='" + due_date + '\'' +
                ", completed=" + completed +
                '}';
    }
}
