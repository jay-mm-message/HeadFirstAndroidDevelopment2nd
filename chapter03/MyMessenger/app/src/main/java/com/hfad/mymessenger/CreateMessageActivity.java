package com.hfad.mymessenger;

import android.app.Activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessage(View view) {
//        EditText messageView = (EditText)findViewById(R.id.message);
//        String messageText = messageView.getText().toString();

        //Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        EditText input = (EditText) findViewById(R.id.message);
        String query = input.getText().toString();
        intent.putExtra(SearchManager.QUERY, query);
        //intent.putExtra(Intent.EXTRA_TEXT, messageText);
//        intent.putExtra(Intent.EXTRA_TEXT, messageText);
//        String chooserTitle = getString(R.string.chooser);
//        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);

//
//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        intent.putExtra("message", messageText);
        Intent ChosenIntent = Intent.createChooser(intent, "Search query...");

        //startActivity(intent);
        startActivity(ChosenIntent);
    }
}
