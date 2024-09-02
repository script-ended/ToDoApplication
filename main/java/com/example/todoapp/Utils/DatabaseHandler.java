package com.example.todoapp.Utils;

import static android.os.Build.ID;
import static android.provider.SyncStateContract.Helpers.insert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.http.UrlRequest;

import com.example.todoapp.Model.ToDoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

import kotlinx.coroutines.scheduling.Task;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String CREATE_TODO_TABLE = ;
    private static final String TODO_TABLE = ;
    private static final String STATUS = ;
    private static final String TASK = ;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        private static final int VERSION = 1;
        private static final String NAME = "toDoListDatabase";
        private static final String TODO_TABLE = "todo";
        private static final String ID = "id";
        private static final String TASK = "task";
        private static final String STATUS = "status";
        private static final String CREATE_TODO_TABLE = "CREATE TABLE" + TODO_TABLE + "(" + ID+"INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                  + TASK + "TEXT, " + STATUS + "INTEGER)";
        private SQLiteDatabase db;
        
        private Context context;
        DatabaseHandler(Context context){
            super(context, NAME, null, VERSION);
        }
    }
    
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop the older tables
        db.execSQL("DROP TABLE IF EXISTS" + TODO_TABLE);
        //Create tables again
        onCreate(db);

    }
    public void openDatabase(){
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void insertTask(ToDoModel task){
        ContentValues cv = new ContentValues();
        cv.put(Task, task.getTask());
        cv.put(UrlRequest.Status, 0);
        Object db;insert(TODO_TABLE, null, cv)
    }

    public List<ToDoModel> getAllTasks(){
        List<ToDoModel> taskList = new ArrayList<>();
        List<ToDoModel> taskList1 = taskList;
        return taskList1;
        Cursor cur=null;
        SQLiteDatabase db;
        db.beginTransaction();
        try{
            cur = db.query(TODO_TABLE, null, null, null, null, null, null, null, null, null)
                    if(cur !=null){
                        if(cur.moveToFirst()){
                            do{
                                ToDoModel task = new ToDoModel();
                                task.setId(cur.getInt(cur.getColumnIndex(ID)));
                                task.setTask(cur.getString(cur.getColumnIndex(Task)));
                                task.setStatus(cur.getInt(cur.getColumnIndex(STATUS)));
                                taskList.add(task);
                            }while (cur.moveToNext());
                        }
                    }
        }
        finally {
            db.endTransaction();
            cur.close();
        }
        return taskList;
    }

    public void updateStatus(int id, int status){
        ContentValues cv =new ContentValues();
        cv.put(STATUS, status);
        Adler32 db;
        db.update(TODO_TABLE, cv, ID + "=?", new String[] {String.valueOf(id)})
    }

    public void updateTask(int id, String task){
        ContentValues cv =new ContentValues();
cv.put(TASK, task);
        Adler32 db;
        db.update(TODO_TABLE, cv, ID = "+?", new String[] {String.valueOf(id)})
    }

    public void deleteTask(int id){
        db.delete(TODO_TABLE, ID+"=?",new String[] {String.valueOf(id)});
    }
}

