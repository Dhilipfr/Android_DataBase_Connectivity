package com.example.dhilipkumaran.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);
    EditText gmail,facebook,outlook,ymail;
    Button UpdateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gmail = (EditText)findViewById(R.id.txtGmail);
        facebook = (EditText)findViewById(R.id.txtFaceBook);
        outlook = (EditText)findViewById(R.id.txtOutlook);
        ymail = (EditText)findViewById(R.id.txtYmail);
        UpdateButton = (Button)findViewById(R.id.btnUpdate);

        final Integer count = helper.GetCount();
        if (count>0){
            SummaryDetails details = new SummaryDetails();
            details = helper.getDetailById();
            gmail.setText(details.Gmail);
            facebook.setText(details.FaceBook);
            outlook.setText(details.OutLook);
            ymail.setText(details.YMail);
        }
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummaryDetails detials = new SummaryDetails();
                detials.setId(0);
                detials.setGmail(gmail.getText().toString());
                detials.setFaceBook(facebook.getText().toString());
                detials.setOutLook(outlook.getText().toString());
                detials.setYMail(ymail.getText().toString());
                if (count > 0){
                    helper.UpdateDetailById(detials);
                }else{
                    helper.InsertPassowrds(detials);
                }
            }
        });
    }
}
