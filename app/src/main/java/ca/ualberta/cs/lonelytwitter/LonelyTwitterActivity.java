package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is a class responsible to running Lonely
 * Twitter. It handles various other classes.
 *
 * @author team x
 * @version 1.0
 * @see Tweet
 * @see Tweetable
 * @see CurrentMood
 * @since 1.0
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		clearButton.setOnClickListener(new View.OnClickListener() {
			/**
			 * Called when clear button is clicked
			 *
			 * @param v	v holds the properties of the button
			 */
			public void onClick(View v) {
				tweets.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Called when save button is clicked
			 *
			 * @param v holds the properties of the button
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				// saveInFile(text, new Date(System.currentTimeMillis()));

				tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
				saveInFile();

//				Tweet tweet = new ImportantTweet("");
//				Tweet tweet1 = new NormalTweet("Hi");
//
//				try {
//					tweet.setMessage("Hello");
//				} catch (TweetTooLongException e) {
//					// e.printStackTrace();
//				}

//				Tweetable tweet3 = new ImportantTweet("-");
//				tweet3.addMood(new Sad());
//				tweet3.addMood(new Happy());
//				ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
//				tweetList.add(tweet);
//				tweetList.add(tweet1);
//				Log.d("TAG Lonely Thing", tweet3.getMoods());
				// Log.d("", "The isImportant method on tweet1 returns " + tweet1.isImportant());
				// finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method is responsible for the old tweets to be loaded
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method saves the tweets so when the app the reopened,
	 * the tweets will not be reset.
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}