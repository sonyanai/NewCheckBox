package jp.techacademy.son.newcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    LinearLayout layout;
    LinearLayout tohokuLayout;
    LinearLayout kantoLayout;
    LinearLayout tyubuLayout;
    LinearLayout kinkiLayout;
    LinearLayout tyugokuLayout;
    LinearLayout shikokuLayout;
    LinearLayout kyusyuLayout;
    ArrayList<String> tihoList = new ArrayList<String>();
    ArrayList<String> tohokuList = new ArrayList<String>();
    ArrayList<String> kantoList = new ArrayList<String>();
    ArrayList<String> tyubuList = new ArrayList<String>();
    ArrayList<String> kinkiList = new ArrayList<String>();
    ArrayList<String> tyugokuList = new ArrayList<String>();
    ArrayList<String> shikokuList = new ArrayList<String>();
    ArrayList<String> kyusyuList = new ArrayList<String>();
    int tihoNumber;

    public class ApiTask extends GetWeatherForecastTask {
        @Override
        protected void onPostExecute(WeatherForecast data) {
            super.onPostExecute(data);


            if (data != null) {

                for (WeatherForecast.Forecast forecast : data.forecastList) {

                    LinearLayout.LayoutParams checkBoxLayoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    checkBoxLayoutParams.setMargins(100, 0, 0, 0);

                    checkBox = new CheckBox(getApplicationContext());
                    checkBox.setId(Integer.parseInt(forecast.id));
                    checkBox.setText(forecast.name);
                    checkBox.setChecked(true);
                    checkBox.setLayoutParams(checkBoxLayoutParams);
                    layout.addView(checkBox);


                }
            } else if (exception != null) {
                Toast.makeText(getApplicationContext(), exception.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tihoList.add("東北地方");
        tihoList.add("関東地方");
        tihoList.add("中部地方");
        tihoList.add("近畿地方");
        tihoList.add("中国地方");
        tihoList.add("四国地方");
        tihoList.add("九州地方");

        tohokuList.add("北海道");
        tohokuList.add("青森県");
        tohokuList.add("岩手県");
        tohokuList.add("宮城県");
        tohokuList.add("秋田県");
        tohokuList.add("山形県");
        tohokuList.add("福島県");

        kantoList.add("茨城県");
        kantoList.add("栃木県");
        kantoList.add("群馬県");
        kantoList.add("埼玉県");
        kantoList.add("千葉県");
        kantoList.add("東京都");
        kantoList.add("神奈川県");

        tyubuList.add("新潟県");
        tyubuList.add("富山県");
        tyubuList.add("石川県");
        tyubuList.add("福井県");
        tyubuList.add("山梨県");
        tyubuList.add("長野県");
        tyubuList.add("岐阜県");
        tyubuList.add("静岡県");
        tyubuList.add("愛知県");

        kinkiList.add("三重県");
        kinkiList.add("滋賀県");
        kinkiList.add("京都府");
        kinkiList.add("大阪府");
        kinkiList.add("兵庫県");
        kinkiList.add("奈良県");
        kinkiList.add("和歌山県");

        tyugokuList.add("鳥取県");
        tyugokuList.add("島根県");
        tyugokuList.add("岡山県");
        tyugokuList.add("広島県");
        tyugokuList.add("山口県");

        shikokuList.add("徳島県");
        shikokuList.add("香川県");
        shikokuList.add("愛媛県");
        shikokuList.add("高知県");

        kyusyuList.add("福岡県");
        kyusyuList.add("佐賀県");
        kyusyuList.add("長崎県");
        kyusyuList.add("熊本県");
        kyusyuList.add("大分県");
        kyusyuList.add("宮崎県");
        kyusyuList.add("鹿児島県");
        kyusyuList.add("沖縄県");




        final ScrollView topLayout = new ScrollView(getApplicationContext());
        topLayout.setLayoutParams(new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT));
        setContentView(topLayout);

        layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        topLayout.addView(layout);


        //checkboxパラメータ
        LinearLayout.LayoutParams checkBoxLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        //areaパラメータ
        LinearLayout.LayoutParams areaLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        areaLayoutParams.setMargins(50,0,0,0);


        final CheckBox[] tihoCheckBox = new CheckBox[7];
        tihoNumber =0;
        for (final String tiho: tihoList){
            tihoCheckBox[tihoNumber] = new CheckBox(getApplicationContext());
            tihoCheckBox[tihoNumber].setId(tihoNumber);
            tihoCheckBox[tihoNumber].setText(tiho);
            tihoCheckBox[tihoNumber].setLayoutParams(checkBoxLayoutParams);
            layout.addView(tihoCheckBox[tihoNumber]);
            if (tihoNumber==0){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[0].isChecked()){
                            tohokuLayout.setVisibility(View.VISIBLE);
                        }else {
                            tohokuLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }else if (tihoNumber==1){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[1].isChecked()){
                            kantoLayout.setVisibility(View.VISIBLE);
                        }else {
                            kantoLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }else if (tihoNumber==2){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[2].isChecked()){
                            tyubuLayout.setVisibility(View.VISIBLE);
                        }else {
                            tyubuLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }else if (tihoNumber==3){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[3].isChecked()){
                            kinkiLayout.setVisibility(View.VISIBLE);
                        }else {
                            kinkiLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }else if (tihoNumber==4){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[4].isChecked()){
                            tyugokuLayout.setVisibility(View.VISIBLE);
                        }else {
                            tyugokuLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }else if (tihoNumber==5){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[5].isChecked()){
                            shikokuLayout.setVisibility(View.VISIBLE);
                        }else {
                            shikokuLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }else if (tihoNumber==6){
                tihoCheckBox[tihoNumber].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tihoCheckBox[6].isChecked()){
                            kyusyuLayout.setVisibility(View.VISIBLE);
                        }else {
                            kyusyuLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }



            if (tihoNumber==0){
                final CheckBox[] tohokuCheckBox = new CheckBox[7];
                int areaNumber = 101;
                //東北レイアウト
                tohokuLayout = new LinearLayout(getApplicationContext());
                tohokuLayout.setOrientation(LinearLayout.VERTICAL);
                tohokuLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                layout.addView(tohokuLayout);
                tohokuLayout.setVisibility(View.GONE);
                for (String tohoku: tohokuList){
                    tohokuCheckBox[areaNumber - 101] = new CheckBox(getApplicationContext());
                    tohokuCheckBox[areaNumber - 101].setId(areaNumber);
                    tohokuCheckBox[areaNumber - 101].setText(tohoku);
                    tohokuCheckBox[areaNumber - 101].setLayoutParams(areaLayoutParams);
                    tohokuLayout.addView(tohokuCheckBox[areaNumber - 101]);
                    areaNumber += 1;
                }
            }else if (tihoNumber==1) {
                final CheckBox[] kantoCheckBox = new CheckBox[7];
                int areaNumber = 108;
                //関東レイアウト
                kantoLayout = new LinearLayout(getApplicationContext());
                kantoLayout.setOrientation(LinearLayout.VERTICAL);
                kantoLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                kantoLayout.setVisibility(View.GONE);
                layout.addView(kantoLayout);
                for (String kanto : kantoList) {
                    kantoCheckBox[areaNumber - 108] = new CheckBox(getApplicationContext());
                    kantoCheckBox[areaNumber - 108].setId(areaNumber);
                    kantoCheckBox[areaNumber - 108].setText(kanto);
                    kantoCheckBox[areaNumber - 108].setLayoutParams(areaLayoutParams);
                    kantoLayout.addView(kantoCheckBox[areaNumber - 108]);
                    areaNumber += 1;
                }
            }else if (tihoNumber == 2) {
                final CheckBox[] tyubuCheckBox = new CheckBox[9];
                int areaNumber = 115;
                tyubuLayout = new LinearLayout(getApplicationContext());
                tyubuLayout.setOrientation(LinearLayout.VERTICAL);
                tyubuLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                tyubuLayout.setVisibility(View.GONE);
                layout.addView(tyubuLayout);
                    for (String tyubu : tyubuList) {
                        tyubuCheckBox[areaNumber - 115] = new CheckBox(getApplicationContext());
                        tyubuCheckBox[areaNumber - 115].setId(areaNumber);
                        tyubuCheckBox[areaNumber - 115].setText(tyubu);
                        tyubuCheckBox[areaNumber - 115].setLayoutParams(areaLayoutParams);
                        tyubuLayout.addView(tyubuCheckBox[areaNumber - 115]);
                        areaNumber += 1;
                    }
            }else if (tihoNumber == 3) {
                final CheckBox[] kinkiCheckBox = new CheckBox[7];
                int areaNumber = 124;
                kinkiLayout = new LinearLayout(getApplicationContext());
                kinkiLayout.setOrientation(LinearLayout.VERTICAL);
                kinkiLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                kinkiLayout.setVisibility(View.GONE);
                layout.addView(kinkiLayout);
                for (String kinki : kinkiList) {
                    kinkiCheckBox[areaNumber - 124] = new CheckBox(getApplicationContext());
                    kinkiCheckBox[areaNumber - 124].setId(areaNumber);
                    kinkiCheckBox[areaNumber - 124].setText(kinki);
                    kinkiCheckBox[areaNumber - 124].setLayoutParams(areaLayoutParams);
                    kinkiLayout.addView(kinkiCheckBox[areaNumber - 124]);
                    areaNumber += 1;
                }
            }else if (tihoNumber == 4) {
                final CheckBox[] tyugokuCheckBox = new CheckBox[5];
                int areaNumber = 131;
                tyugokuLayout = new LinearLayout(getApplicationContext());
                tyugokuLayout.setOrientation(LinearLayout.VERTICAL);
                tyugokuLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                tyugokuLayout.setVisibility(View.GONE);
                layout.addView(tyugokuLayout);
                for (String tyugoku : tyugokuList) {
                    tyugokuCheckBox[areaNumber - 131] = new CheckBox(getApplicationContext());
                    tyugokuCheckBox[areaNumber - 131].setId(areaNumber);
                    tyugokuCheckBox[areaNumber - 131].setText(tyugoku);
                    tyugokuCheckBox[areaNumber - 131].setLayoutParams(areaLayoutParams);
                    tyugokuLayout.addView(tyugokuCheckBox[areaNumber - 131]);
                    areaNumber += 1;
                }
            }else if (tihoNumber == 5) {
                final CheckBox[] shikokuCheckBox = new CheckBox[4];
                int areaNumber = 136;
                shikokuLayout = new LinearLayout(getApplicationContext());
                shikokuLayout.setOrientation(LinearLayout.VERTICAL);
                shikokuLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                shikokuLayout.setVisibility(View.GONE);
                layout.addView(shikokuLayout);
                for (String shikoku : shikokuList) {
                    shikokuCheckBox[areaNumber - 136] = new CheckBox(getApplicationContext());
                    shikokuCheckBox[areaNumber - 136].setId(areaNumber);
                    shikokuCheckBox[areaNumber - 136].setText(shikoku);
                    shikokuCheckBox[areaNumber - 136].setLayoutParams(areaLayoutParams);
                    shikokuLayout.addView(shikokuCheckBox[areaNumber - 136]);
                    areaNumber += 1;
                }
            }else if (tihoNumber == 6) {
                final CheckBox[] kyusyuCheckBox = new CheckBox[8];
                int areaNumber = 140;
                kyusyuLayout = new LinearLayout(getApplicationContext());
                kyusyuLayout.setOrientation(LinearLayout.VERTICAL);
                kyusyuLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                kyusyuLayout.setVisibility(View.GONE);
                layout.addView(kyusyuLayout);
                for (String kyusyu : kyusyuList) {
                    kyusyuCheckBox[areaNumber - 140] = new CheckBox(getApplicationContext());
                    kyusyuCheckBox[areaNumber - 140].setId(areaNumber);
                    kyusyuCheckBox[areaNumber - 140].setText(kyusyu);
                    kyusyuCheckBox[areaNumber - 140].setLayoutParams(areaLayoutParams);
                    kyusyuLayout.addView(kyusyuCheckBox[areaNumber - 140]);
                    areaNumber += 1;
                }
            }
            tihoNumber += 1;
        }

        Button button = new Button(getApplicationContext());
        button.setText("ok");
        button.setLayoutParams(checkBoxLayoutParams);
        layout.addView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //id=6のtextViewのtextを変更したい
                for (int v=0;v<7;v++){
                    tihoCheckBox[v].setChecked(false);
                }

            }
        });







                new ApiTask().execute("20");
    }
}
