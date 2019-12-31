package com.bw.dukaibin1231.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.dukaibin1231.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.code)
    ImageView code;
    @BindView(R.id.weixin)
    Button weixin;
    @BindView(R.id.qq)
    Button qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowActivity.this, "王乔喻", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
