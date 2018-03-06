package com.example.win7.listview02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btndo;
    private TextView txtResult;
    private ListView lstPrefer;
    String[] Games = new String[]{"無人島求生記","三國志英雄傳","水滸傳","無限遠征隊"};
    int count;
        @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  取得介面元件
        btndo = (Button)findViewById(R.id.btndo);
        txtResult = (TextView)findViewById(R.id.txtResult);
        lstPrefer =(ListView)findViewById(R.id.lstPrefer);

        //  以多選範例建立 ArrayAdapter
        ArrayAdapter<String> adapterGames = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,Games);

        //  設定可多選
        lstPrefer.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //  設定 ListView 資料來源
        lstPrefer.setAdapter(adapterGames);

        //  取得選曲項目總數
        count = adapterGames.getCount();

        //  設定  Button原件 Click事件 的 listener為 btnDoListener
        btndo.setOnClickListener(btnDoListener);

        //  設定  lstPrefer 原件 ItemClick事件 的 listener為 lstPreferListener
        lstPrefer.setOnItemClickListener(lstPreferListener);

        lstPrefer.setSelector(R.drawable.green);   // 改變選取的背景色為圖片

        }
    //  定義 onClick方法
    private Button.OnClickListener btnDoListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            String selAll="";
            for(int p = 0 ; p < count; p++)
            {
                if(lstPrefer.isItemChecked(p))  //以核選
                    selAll += Games[p] + "  " ;
            }
            txtResult.setText(" 我最喜歡的遊戲是 : " + selAll);
        }
    };
    //  定義 onItemClick方法
    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            //  顯示 ListView內容
            String sel = parent.getItemAtPosition(position).toString();
            if(lstPrefer.isItemChecked(position))   //已選
            {
                setTitle("  目前選取:   " + sel);
            }
            else
            {
                setTitle("  取消選取:   " + sel);
            }
        }
    };
}
