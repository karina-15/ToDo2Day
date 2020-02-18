package edu.miracosta.cs134.kelias.todo2day.model;

public class Task {

    private int mId;
    private String mDescription;
    private boolean mIsDone;

    public Task(int mId, String mDescription, boolean mIsDone) {
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

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
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
