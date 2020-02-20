package edu.miracosta.cs134.kelias.todo2day.model;

public class Task {

    private long mId;   // use long for 64 unique primary key
    private String mDescription;
    private boolean mIsDone;

    public Task(long mId, String mDescription, boolean mIsDone) {
        this.mId = mId;
        this.mDescription = mDescription;
        this.mIsDone = mIsDone;
    }

    public Task(String description, boolean isDone){
        this(-1, description, isDone);
    }

    public Task(String description){
        this(-1, description, false);
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public boolean isIsDone() {
        return mIsDone;
    }

    public void setIsDone(boolean mIsDone) {
        this.mIsDone = mIsDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "mId=" + mId +
                ", mDescription='" + mDescription + '\'' +
                ", mIsDone=" + mIsDone +
                '}';
    }
}
