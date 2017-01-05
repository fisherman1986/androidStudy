package com.xdtdz.study.androidstudy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FirstActivity.this, "你点击了Button1", Toast.LENGTH_SHORT).show();
            }
        });
        Button buttonIntent1=(Button)findViewById(R.id.buttonIntent1);
        buttonIntent1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Button buttonIntent2=(Button)findViewById(R.id.buttonIntent2);
        buttonIntent2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent("com.xdtdz.study.androidstudy.ACTION_START");
                intent.addCategory("android.intent.category.MY_CATEGORY");
                startActivity(intent);
            }
        });
        Button buttonIntentInternetView=(Button)findViewById(R.id.buttonIntentInternetView);
        buttonIntentInternetView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button buttonIntentOpenThird=(Button)findViewById(R.id.buttonIntentOpenThird);
        buttonIntentOpenThird.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });//

        Button buttonIntentOpenThirdPara=(Button)findViewById(R.id.buttonIntentOpenThirdPara);
        buttonIntentOpenThirdPara.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String data="Hello NewActivity";
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
        Button buttonIntentOpenThirdBackPara=(Button)findViewById(R.id.buttonIntentOpenThirdBackPara);
        buttonIntentOpenThirdBackPara.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
               startActivityForResult(intent,1);
            }
        });

        Button buttonDialog=(Button)findViewById(R.id.buttonDialog);
        buttonDialog.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:if(resultCode==RESULT_OK){
                String returnData=data.getStringExtra("data_return");
                Log.d(TAG, "onActivityResult: "+returnData);
            }break;
            default:break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.iteml_add:
                Toast.makeText(this,"你点击了ADD",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteml_remove:
                Toast.makeText(this,"你点击了Remove",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return true;
    }
}
