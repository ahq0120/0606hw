package com.example.traveling2023_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.traveling2023_2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private int likecount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setIcon(R.mipmap.travel_icon);

        NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker);
        np.setEnabled(false);
        np.setMaxValue(48);
        np.setMinValue(12);
        np.setValue(24);

        CheckBox cb = (CheckBox)findViewById(R.id.cbDescription);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText et = (EditText) MainActivity.this.findViewById(R.id.optText);
                NumberPicker np = (NumberPicker) MainActivity.this.findViewById(R.id.numberPicker);
                if(isChecked){
                    et.setEnabled(true);
                    np.setEnabled(true);
                }else {
                    et.setEnabled(false);
                    np.setEnabled(false);
                }
            }
        });

        Button btnParis=(Button)findViewById(R.id.btnParis);
        btnParis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cbDesp = (CheckBox)findViewById(R.id.cbDescription);
                EditText et = (EditText)findViewById(R.id.optText);
                NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ParisActivity.class);
                intent.putExtra("isDescription",cbDesp.isChecked());
                intent.putExtra("optionalTest",et.getText().toString());
                intent.putExtra("optionalFontSize", np.getValue());
                startActivityForResult(intent, 100);
            }
        });

        Button btnZurich=(Button)findViewById(R.id.btnZurich);
        btnZurich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ZurichActivity.class);
                startActivity(intent);
            }
        });

        Button btnAsiaCities=(Button)findViewById(R.id.btnAsiaCities);
        btnAsiaCities.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent();
            @Override
            public void onClick(View v) {
                intent.setAction("asia.city_6_3");
                intent = intent.createChooser(intent,"Please pick a city");
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //@Override
   // public boolean onSupportNavigateUp() {
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //return NavigationUI.navigateUp(navController, appBarConfiguration)
               // || super.onSupportNavigateUp();
   // }
      @Override
    protected void onPause(){
        super.onPause();
          SharedPreferences appSharedPrefs = getSharedPreferences("pre_value",MODE_PRIVATE);
          SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();

          CheckBox cb = (CheckBox) findViewById(R.id.cbDescription);
          EditText et = (EditText) findViewById(R.id.optText);
          NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
          prefsEditor.putBoolean("cbvalue", cb.isChecked());
          prefsEditor.putString("opttextvalue", et.getText().toString());
          prefsEditor.putInt("npvalue", np.getValue());
          prefsEditor.commit();
      }

      @Override
    protected void onResume(){
        super.onResume();

        SharedPreferences appSharedPrefs = getSharedPreferences("pre_value", MODE_PRIVATE);

        CheckBox cb = (CheckBox) findViewById(R.id.cbDescription);
        EditText et = (EditText) findViewById(R.id.optText);
        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);

        Boolean cbChecked = appSharedPrefs.getBoolean("cbvalue", false);
        String optext = appSharedPrefs.getString("opttextvalue","");
        int npv = appSharedPrefs.getInt("npvalue",24);

        if(cbChecked){
            cb.setChecked(true);
            et.setEnabled(true);
            np.setEnabled(true);
            et.setText(optext);
            np.setValue(npv);
        }
        else {
            cb.setChecked(false);
            et.setEnabled(false);
            np.setEnabled(false);
        }
      }

      @Override
    protected  void  onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode==100)
        {
            boolean isLike = data.getBooleanExtra("isLike",false);
            if (isLike)
                likecount++;
            TextView tv = (TextView) MainActivity.this.findViewById(R.id.likeCount);
            tv.setText(""+likecount);
        }
      }
}