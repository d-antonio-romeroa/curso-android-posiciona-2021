package com.root.a12_modulo3_danielromero;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity for entering a word.
 */

public class DeleteWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";

    private  EditText mEditWordView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_word);
        mEditWordView = findViewById(R.id.edit_word);

        final Button button = findViewById(R.id.button_delete);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}