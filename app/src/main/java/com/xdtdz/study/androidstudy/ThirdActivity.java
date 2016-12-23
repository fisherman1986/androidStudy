package com.xdtdz.study.androidstudy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.i(TAG, "onCreate: "+data);
        Button buttonIntentInternetViewConfig=(Button)findViewById(R.id.buttonIntentInternetViewConfig);
        buttonIntentInternetViewConfig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        Button buttonBackData=(Button)findViewById(R.id.buttonBackData);
        buttonBackData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.putExtra("data_return","hello backdata");
                setResult(RESULT_OK,intent);
                //setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("data_return","hello backdata");
        setResult(RESULT_OK,intent);
        //setResult(RESULT_CANCELED,intent);
        finish();
    }
}
