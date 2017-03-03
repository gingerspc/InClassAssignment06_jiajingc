package com.example.android.inclassassignment05_mengqid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


import static android.media.CamcorderProfile.get;

public class ResultActivity extends AppCompatActivity {

    String all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        ArrayList students = (ArrayList) intent.getSerializableExtra(MainActivity.INTENT_STUDENT_LIST);

        all = "";

        for (int i = 0; i < students.size(); i++) {
            Student s = (Student) students.get(i);
            all += s.toString() + "\n";
        }

        TextView studentView = (TextView) findViewById(R.id.result_view);
        studentView.setText(all);
    }

    public void share(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Student Record - " + Calendar.getInstance().getTime().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, all);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }

    }

    public void back(View view)
    {
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);

    }

}

