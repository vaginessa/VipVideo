package com.yangyouwang.myvip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yangyouwang.util.ProperTies;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private boolean isQuit = false;
    private String url = null;
    private String data = null;
    private Intent intent=null;
    private Spinner spinner;
    private EditText et_url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    //初始化
    private void init() {
        et_url = (EditText) findViewById(R.id.et_url);
        spinner = (Spinner) findViewById(R.id.spinner_text);
    }

    public void click(View v) {
        if(TextUtils.isEmpty(et_url.getText())) {
            Toast.makeText(MainActivity.this,"URL不能为空!", Toast.LENGTH_LONG).show();
        }else if(Patterns.WEB_URL.matcher(et_url.getText()).matches()){
            Properties proper = ProperTies.getProperties(getApplicationContext());
            switch ((String)spinner.getSelectedItem()){
                case "接口一":
                    data = proper.getProperty("url01");
                    break;
                case "接口二":
                    data = proper.getProperty("url02");
                    break;
                case "接口三":
                    data = proper.getProperty("url03");
                    break;
                case "接口四":
                    data = proper.getProperty("url04");
                    break;
                case "接口五":
                    data = proper.getProperty("url05");
                    break;
                case "接口六":
                    data = proper.getProperty("url06");
                    break;
                case "接口七":
                    data = proper.getProperty("url07");
                    break;
                case "接口八":
                    data = proper.getProperty("url08");
                    break;
                case "接口九":
                    data = proper.getProperty("url09");
                    break;
                case "接口十":
                    data = proper.getProperty("url10");
                    break;
                case "接口十一":
                    data = proper.getProperty("url11");
                    break;
                case "接口十二":
                    data = proper.getProperty("url12");
                    break;
                case "接口十三":
                    data = proper.getProperty("url13");
                    break;
                case "接口十四":
                    data = proper.getProperty("url14");
                    break;
            }
            url =data + et_url.getText().toString();
            intent = new Intent();
            intent.setClass(MainActivity.this, VideoActivity.class);
            intent.putExtra("Url", url);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"URL错误,请重新输入!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (!isQuit) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            isQuit = true;
            //这段代码意思是,在两秒钟之后isQuit会变成false
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        isQuit = false;
                    }
                }
            }).start();
        } else {
            System.exit(0);
        }
    }
}