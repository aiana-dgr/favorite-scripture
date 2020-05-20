package com.example.favoritescripture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {

    private static final String TAG = "DisplayScriptureActivity";

    static String scripture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        scripture = intent.getStringExtra(MainActivity.FAVORITE_SCRIPTURE);

        Log.d(TAG, "Received intent with " + scripture);

        // Capture the layout's TextView and set the string as its text
        TextView displayScripture = findViewById(R.id.favoriteScripture);
        displayScripture.setText(scripture);
    }

    /** Called when the user taps the Save Scripture button */
    public void saveScripture (View view) {
        SharedPreferences sharedPref = getSharedPreferences("savedScripture", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Scripture", scripture);
        editor.commit();

        // Toast appears to inform user that scripture has been saved
        Context context = getApplicationContext();
        Toast.makeText(this, "Favorite Scripture Data Saved!", Toast.LENGTH_LONG).show();
    }
}
