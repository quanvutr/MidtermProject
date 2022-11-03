package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.adapter.BannerMoviesPagerAdapter;
import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.adapter.MovieItemClickListener;
import com.example.myapplication.model.BannerMovies;
import com.example.myapplication.model.Movie;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout firstTab, secondTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> bannerMoviesList;
    List<Movie> moviesList;
    List<Movie> moviescomesoonList;
    RecyclerView MoviesRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MoviesRV = findViewById(R.id.Rv_movies);

        firstTab = findViewById(R.id.indicator);
        secondTab = findViewById(R.id.tabLayout);

        bannerMoviesList = new ArrayList<>();
        bannerMoviesList.add(new BannerMovies(1, "Naruto Movie - The Last", "https://www.crunchyroll.com/imgsrv/display/thumbnail/1200x675/catalog/crunchyroll/c62f3b44c06c98c5d9a93f4da93281d6.jpeg", ""));
        bannerMoviesList.add(new BannerMovies(2, "Harry Potter", "https://www.vintagemovieposters.co.uk/wp-content/uploads/2015/07/hpphilosopherquadlarge1.jpg", ""));
        bannerMoviesList.add(new BannerMovies(3, "The Lord of The Rings", "https://www.vintagemovieposters.co.uk/wp-content/uploads/2015/07/hpphilosopherquadlarge1.jpg", ""));
        bannerMoviesList.add(new BannerMovies(4, "The Lord of The Rings", "https://www.themedievallife.com/wp-content/uploads/2001/12/The-Lord-of-the-Rings-The-Fellowship-of-the-Ring-0051.jpg", ""));
        bannerMoviesList.add(new BannerMovies(5, "The Lord of The Rings", "https://www.vintagemovieposters.co.uk/wp-content/uploads/2015/07/hpphilosopherquadlarge1.jpg", ""));

        setBannerMoviesPagerAdapter(bannerMoviesList);

        moviesList = new ArrayList<>();
        moviesList.add(new Movie("Black Adam", R.drawable.black_adam, R.drawable.bg_blackadam));
        moviesList.add(new Movie("Lời Nguyền Tầm Da", R.drawable.curse));
        moviesList.add(new Movie("Cô Gái Đến Từ Quá Khứ", R.drawable.girlpass));
        moviesList.add(new Movie("Gulliver Du Ký", R.drawable.gulliver));

        setMoviesPagerAdapter(moviesList);

        moviescomesoonList = new ArrayList<>();
        moviescomesoonList.add(new Movie("Harry Potter Và Chiếc Cốc Lửa", R.drawable.harrypotter));
        moviescomesoonList.add(new Movie("Lyle Chú Cá Sấu Biết Hát", R.drawable.lyle));
        moviescomesoonList.add(new Movie("Chiến Binh Báo Đen 2: Wakanda Bất Diệt", R.drawable.wakanda));
        moviescomesoonList.add(new Movie("One Piece Film Red", R.drawable.onepiece));

        secondTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    setMoviesPagerAdapter(moviescomesoonList);
                }
                else {
                    setMoviesPagerAdapter(moviesList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this, bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        firstTab.setupWithViewPager(bannerMoviesViewPager);
    }
    private void setMoviesPagerAdapter(List<Movie> listMovies){
        MovieAdapter movieAdapter = new MovieAdapter(this,listMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        Intent intent = new Intent(this, MovieDetailActivity.class);

        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgUrl", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView, "sharedName");
        startActivity(intent, options.toBundle());

        Toast.makeText(this,"item checked : " + movie.getTitle(),Toast.LENGTH_LONG).show();
    }
}