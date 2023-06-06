package com.example.traveling2023_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ParisActivity extends AppCompatActivity {


    private static  boolean isLike =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paris);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        isLike = false;

        Boolean isDesp = getIntent().getBooleanExtra("isDescription",true);
        String optText = getIntent().getStringExtra("optionalText");
        int fs = getIntent().getIntExtra("optionalFontSize",24);

        TextView tv = (TextView) findViewById(R.id.parisDesp);
        TextView ot = (TextView) findViewById(R.id.parisOptText);
        TextView it = (TextView) findViewById(R.id.likeText);

        it.setText(null);

        if(isDesp){
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, fs);
            tv.setVisibility(View.VISIBLE);
            ot.setText(optText);
            ot.setTextSize(TypedValue.COMPLEX_UNIT_SP, fs);
            ot.setVisibility(View.VISIBLE);
        }
        else{
            tv.setVisibility(View.INVISIBLE);
            ot.setVisibility(View.INVISIBLE);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.likeFab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView tv = (TextView) ParisActivity.this.findViewById(R.id.likeText);
                if (!isLike){
                    tv.setText("I like it");
                    isLike = true;
                }else {
                    tv.setText("");
                    isLike = false;
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLike",isLike);

        Intent mIntent = new Intent();
        mIntent.putExtras(bundle);

        setResult(RESULT_OK,mIntent);
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            Bundle bundle = new Bundle();
            bundle.putBoolean("isLike", isLike);

            Intent mintent = new Intent();
            mintent.putExtras(bundle);

            setResult(RESULT_OK, mintent);
            finish();
            return true;
        }
        if (id == R.id.action_settings){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}