package com.example.androidhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class MyDinary extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Dinary> mDinaryData;
    private DinarysAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dinary);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDinaryData = new ArrayList<>();
        mAdapter = new DinarysAdapter(this,mDinaryData);
        mRecyclerView.setAdapter(mAdapter);
        initializeData();
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mDinaryData.remove(viewHolder.getAdapterPosition());
                String title = ((TextView)(viewHolder.itemView.findViewById(R.id.title_item))).getText().toString();
                Log.d("deleteWhat",title);
                String privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
                File file = new File(privatePath);
                File[] childFile = file.listFiles();
                for(int i=0;i<childFile.length;i++){
                    Log.d("deleteNow",childFile[i].getName());
                    if(childFile[i].getName().equals(title)){
                        childFile[i].delete();
                        break;
                    }
                }
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);

    }

    private void initializeData(){
        //文件读取
        ArrayList<String> dinaryArrayLi = new ArrayList<String>();
        ArrayList<String> dinaryInfo = new ArrayList<String>();
        String privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
        //删除文件
//        File file1 = new File(privatePath);
//        File[] chFile = file1.listFiles();
//        for(File file2:chFile){
//            if(file2.exists()){
//                file2.delete();
//            }
//        }

        File file = new File(privatePath);
        File[] childFiles = file.listFiles();
        if(null!=childFiles){
            for(int i=0;i<childFiles.length;i++){
                Log.d("lxTest",childFiles[i].getName());
                Log.d("lxTest",""+childFiles[i].length());

                if(i==0){
                    try {
                        FileReader fr = new FileReader(childFiles[i]);
                        BufferedReader br = new BufferedReader(fr);
                        String str = "";
                        while((str = br.readLine())!=null){
                            Log.d("lx",str);
                        }
                    }catch(Exception e){
                        Log.d("lxTest","Error");
                    }
                }
            }
            Log.d("lxTest______",(""+childFiles.length));
            for(int i=0;i< childFiles.length;i++){
                Log.d("lxtest:",childFiles[i].getName());
                dinaryArrayLi.add(childFiles[i].getName());
                try {
                    FileReader fileReader = new FileReader(childFiles[i]);
                    BufferedReader bReader = new BufferedReader(fileReader);
                    String str = bReader.readLine();
                    if(str==null){
                        str = "";
                    }
                    if(str.length()>20){
                        str = str.substring(0,20);
                    }
                    dinaryInfo.add(str);
                    fileReader.close();
                    bReader.close();

                }catch(Exception e){
                    Log.d("lxTest",e.toString());
                }
            }
        }else{
            Log.d("lxTest","这个文件路径没有找到文件");
        }

        //String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.sports_images);

        //Clear the existing data (to avoid duplication)
        mDinaryData.clear();

        //Create the ArrayList of Sports objects with the titles and information about each sport
        for(int i=0;i<dinaryArrayLi.size();i++){
            mDinaryData.add(new Dinary(dinaryArrayLi.get(i),dinaryInfo.get(i),
                    sportsImageResources.getResourceId(i,0)));
        }

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }

    public void writeDinary(View view) {
        Intent intent = new Intent(MyDinary.this,writeMyDinary.class);
        startActivity(intent);
        /*
        String privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
        String text1 = "/dinary1.txt";
        String text2 = "/dinary2.txt";
        String text3 = "/dinary3.txt";
        String text4 = "/dinary4.txt";
        writeTxtToFile("i am so happy",privatePath,text1);
        writeTxtToFile("i am so happy",privatePath,text2);
        writeTxtToFile("i am so happy",privatePath,text3);
        writeTxtToFile("i am so happy",privatePath,text4);
        initializeData();
        */
    }


}