package com.example.androidhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidhomework.ReadFileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class writeMyDinary extends AppCompatActivity {
    private EditText titleEdit;
    private EditText dinaryEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_my_dinary);
        titleEdit = (EditText) findViewById(R.id.editTitle);
        dinaryEdit = (EditText) findViewById(R.id.editDinary);
        if(getIntent().hasExtra("txtName")){
            Log.d("lxTest","有一个Extra");
            String str = getIntent().getStringExtra("txtName");
            String privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
            privatePath = privatePath+"/"+str;
            String dinaryContent = "";
            try{
                File file = new File(privatePath);
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(read);
                String bufferLine;
                while((bufferLine = br.readLine())!=null){
                    dinaryContent = dinaryContent + bufferLine;
                }
                dinaryEdit.setText(dinaryContent);
                read.close();
            }catch(Exception e){
                Log.d("lxTest","读取文件出现问题");
            }
            str = str.substring(0,str.indexOf(".txt"));
            titleEdit.setText(str);

        }else{
            Log.d("lxTest","没有一个Extra");
        }

    }

    public void endEditDinary(View view) {
        String privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
        String title = titleEdit.getText().toString();
        String dinary = dinaryEdit.getText().toString();
        Log.d("dinary Content is",dinary);
        title = title+".txt";
        File file = new File(privatePath);
        File[] childFile = file.listFiles();
        boolean titleExist = false;
        for(int i=0;i<childFile.length;i++){
            if(childFile[i].getName().equals(title)){
                titleExist = true;
            }
        }
        if(childFile.length>=10&&titleExist==false){
            Toast toast = Toast.makeText(this, "日记数量超出上限", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.LEFT,0, 0);
            toast.show();
        }else{
            ReadFileHelper.writeTxtToFile(dinary,privatePath,title);
        }
        Intent intent = new Intent(this,MyDinary.class);
        startActivity(intent);
    }
}
