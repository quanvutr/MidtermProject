package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description, tv_director, tv_type, tv_rated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        iniViews();
    }

    void iniViews(){
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgUrl");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_image);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageCover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);

        String movieDirector = getIntent().getExtras().getString("director");
        tv_director = findViewById(R.id.textDirector);
        tv_director.setText(movieDirector);

        String movieType = getIntent().getExtras().getString("type");
        tv_type = findViewById(R.id.textType);
        tv_type.setText(movieType);

        String movieRated = getIntent().getExtras().getString("rated");
        tv_rated = findViewById(R.id.textRated);
        tv_rated.setText(movieRated);

        String movieDesc = getIntent().getExtras().getString("description");
        tv_description = findViewById(R.id.detail_movie_desc);
        tv_description.setText(movieDesc);


    }
}