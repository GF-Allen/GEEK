package com.alenbeyond.runoob.test;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alenbeyond.runoob.R;
import com.alenbeyond.runoob.rx.ApiManager;
import com.alenbeyond.runoob.rx.MyObserver;
import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SujinActivity extends AppCompatActivity {

    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_stuff)
    TextView tvStuff;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sujin);
        ButterKnife.bind(this);
        player = new MediaPlayer();
        tvDes.setMovementMethod(ScrollingMovementMethod.getInstance());
        ApiManager.getObSujinDes("http://isujin.com/5990", new MyObserver<SuJinDes>() {
            @Override
            public void onNext(SuJinDes suJinDes) {
                String content = suJinDes.getContent();
                tvDes.setText(Html.fromHtml(content));
                tvStuff.setText(suJinDes.getStuff());
                tvTitle.setText(suJinDes.getTitle());
                try {
                    player.setDataSource(suJinDes.getMusic());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Glide.with(SujinActivity.this).load(suJinDes.getImages().get(0))
                        .asBitmap().centerCrop().into(ivImage);
            }
        });
    }

    public void startPlay(View view) {
        if (player.isPlaying()) {
            player.pause();
        } else {
            player.start();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null && player.isPlaying()) {
            player.stop();
            player.release();
            player = null;
        }
    }
}
