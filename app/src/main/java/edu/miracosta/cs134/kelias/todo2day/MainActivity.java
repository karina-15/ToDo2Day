package edu.miracosta.cs134.kelias.todo2day;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import edu.miracosta.cs134.kelias.todo2day.model.DBHelper;
import edu.miracosta.cs134.kelias.todo2day.model.Task;

public class MainActivity extends AppCompatActivity {

    // Create a reference to the database
    private DBHelper mDB;
    private List<Task> mAllTasks;

    private EditText descriptionEditText;
    private ListView taskListView;
    private TaskListAdapter mTaskListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // wire up the views
        descriptionEditText = findViewById(R.id.taskEditText);
        taskListView = findViewById(R.id.taskListView);

        mDB = new DBHelper(this);
        // mDB.clearAllTasks();

        mDB.addTask(new Task("Complete HW 4"));
        mDB.addTask(new Task("Review show-and-tell speech"));
        mDB.addTask(new Task("Study for Quiz #2 for c++"));
        mDB.addTask(new Task("Study for test tomorrow morning"));

        mAllTasks = mDB.getAllTasks();

        // Instantiate the ListAdapter
        mTaskListAdapter = new TaskListAdapter(this, R.layout.task_item, mAllTasks);
        // connect the ListView with the ListAdapter
        taskListView.setAdapter(mTaskListAdapter);

        // for debugging
/*        // Let's loop through them and print them to the log
        for (Task t : mAllTasks) {
            Log.i("ToDo2Day", t.toString());
        }

        // Let's create some dummy data and add it to database to test if it currently works
        mDB.addTask(new Task("Complete HW 4"));
        mDB.addTask(new Task("Review show-and-tell speech"));
        mDB.addTask(new Task("Study for Quiz #2 for c++"));
        mDB.addTask(new Task("Study for test tomorrow morning"));*/
    }

    public void addTask(View v)
    {
        // Let's extract the description from the EditText
        String description = descriptionEditText.getText().toString();

        // id = -1, description = User input, isDone = false;
        Task newTask = new Task(description);
        long id = mDB.addTask(newTask);
        newTask.setId(id);
        // Add the new task to the list
        mAllTasks.add(newTask);
    }

    // only want database to close after closing app not while using the app
    // Ctrl + o - onDestroy to close database when app is closed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDB.close();
    }
}
