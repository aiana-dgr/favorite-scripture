package com.example.favoritescripture;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String FAVORITE_SCRIPTURE = "com.example.favoritescripture.MESSAGE";
    private static final String TAG = "MainActivity";
    public final static String scriptureHolder = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Load Scripture button */
    public void loadScripture (View view) {
        SharedPreferences sharedPref = getSharedPreferences("savedScripture", Context.MODE_PRIVATE);
        String scripture = sharedPref.getString("Scripture", scriptureHolder);
        TextView loadScripture = findViewById(R.id.load);
        loadScripture.setText(scripture);
}

    /** Called when the user taps the Submit Button */
    public void submitScripture(View view) {
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        EditText editBook = (EditText) findViewById(R.id.editText);
        EditText editChapter = (EditText) findViewById(R.id.editText2);
        EditText editVerse = (EditText) findViewById(R.id.editText3);
        String book = editBook.getText().toString();
        String chapter = editChapter.getText().toString();
        String verse = editVerse.getText().toString();
        String scripture = book + " " + chapter + ":" + verse;
        intent.putExtra(FAVORITE_SCRIPTURE, scripture);

        Log.d(TAG, "About to create intent with " + scripture);
        startActivity(intent);
    }
}
