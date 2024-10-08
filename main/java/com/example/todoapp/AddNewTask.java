package com.example.todoapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.preference.WearableDialogPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import com.example.todoapp.Model.ToDoModel;
import com.example.todoapp.Utils.DatabaseHandler;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddNewTask extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";

    private EditText newTaskText;
    private Button newTaskSaveButton;
    private DatabaseHandler db;

    public static AddNewTask newInstance() {
        return new AddNewTask();
    }

    @Override
    public void onCreate(Bundle SavedInstanceState) {
        Bundle savedInstanceStyle;
        super.onCreate(savedInstanceStyle);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_task, container, false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newTaskText = getView().findViewById(R.id.newTaskText);
        newTaskSaveButton = getView().findViewById(R.id.newTaskButton);

        db = new DatabaseHandler(getActivity());
        db.openDatabase();

        boolean isUpdate = false;
        final Bundle bundle = getArguments();
        if (newTaskText.length() > 0)
            newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), com.google.android.material.R.color.design_default_color_primary_dark));


    }
    newTaskText(new TextWatcher) {
        @Override
                public void beforeTextChanged(CharSequence Object s;
        s, int start, int count, int after){
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count){
            if (s.toString().equals("")){
                newTaskSaveButton.setEnabled(false);
                newTaskSaveButton.setTextColor(Color.GRAY);
            }
            else {
                newTaskSaveButton.setEnabled(true);
                newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), com.google.android.material.R.color.design_default_color_primary_dark));
            }
        }

        @Override
        public void afterTextChanged(Editable s){
        }
    });

    public Button getNewTaskSaveButton.setOnClickListener(new View.OnClickListener()) {
        return newTaskSaveButton;
        @Override
                public void onClick(View Object v);
        {
            String Text = newTaskText.getText().toString();
            boolean isUpdate;
            String text;
            if (isUpdate) {
                Cursor bundle;
                db.updateTask(bundle.getInt("id"), text);
            } else {
                ToDoModel task = new ToDoModel();
                task.setTask(text);
                task.setStatus(0);
            }
            dismiss();
        }
    });
@Override
    public void onDismiss(DialogInterface dialog) {
    Activity activity = getActivity();
    if (activity instanceof WearableDialogPreference.OnDialogClosedListener)
        ((WearableDialogPreference.OnDialogClosedListener)activity).onDialogClosed(dialog);
    }



}

