package com.example.dipto.firebasebasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.firebasebtn)
    Button firebasebtn;
    @BindView(R.id.firebaseEditTextName)
    EditText firebaseEditTextName;
    @BindView(R.id.firebaseEditTextEmail)
    EditText firebaseEditTextEmail;
    @BindView(R.id.nextActivityBtn)
    Button nextActivityBtn;


    private DatabaseReference mDatabaseReference;
    private String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @OnClick(R.id.firebasebtn)
    public void onFireBaseBtnClicked() {

        // 1. create a child in root object
        // 2. assign some value to child object

        name = firebaseEditTextName.getText().toString().trim();
        email = firebaseEditTextEmail.getText().toString().trim();

        HashMap<String, String> storedValue = new HashMap<String, String>();
        storedValue.put("Name", name);
        storedValue.put("Email", email);

        //mDatabaseReference.child("Name").setValue(name);

        mDatabaseReference.push().setValue(storedValue).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Stored Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.nextActivityBtn)
    public void onNextActivityBtnClicked() {
        Intent intent = new Intent(MainActivity.this, RetrievDataActivity.class) ;
        startActivity(intent);
    }
}
