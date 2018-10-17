package com.example.yaowang.youtubeplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button btnplay;

    private static final String TAG = "MainAcivity";

    YouTubePlayer.OnInitializedListener onInitializedListener;

    YoutubeServiceNew service = new YoutubeServiceNew();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.view);
        btnplay=(Button) findViewById(R.id.button);

        Log.d(TAG, "oncreate is starting");
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "on click: done initialising");
                youTubePlayer.loadPlaylist("https://www.youtube.com/watch?v=eCKzNkW5GMI");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "on click: failed to initialise");
            }
        };

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "on click: initialising youtube player");
                youTubePlayerView.initialize(service.getApi(),onInitializedListener);
            }
        });
    }
}
