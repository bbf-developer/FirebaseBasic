package com.example.dipto.firebasebasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RetrievDataActivity extends AppCompatActivity {

    @BindView(R.id.showUserName)
    TextView showUserName;

    private FirebaseDatabase mFireBaseDataBase ;
    private String mTextViewString ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retriev_data);
        ButterKnife.bind(this);

    }
}
