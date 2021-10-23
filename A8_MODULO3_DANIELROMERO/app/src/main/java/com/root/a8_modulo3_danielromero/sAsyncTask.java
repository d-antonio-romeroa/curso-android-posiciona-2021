package com.root.a8_modulo3_danielromero;

import android.widget.TextView;

import java.lang.ref.WeakReference;
import android.os.AsyncTask;
import java.util.Random;

public class sAsyncTask extends AsyncTask<Void, Void, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;

    // Constructor that provides a reference to the TextView from the MainActivity
    sAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */
    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10.
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 200;

        // Sleep for the random amount of time.
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result.
        return "Se ha ejecutado la revisión en un tiempo de " + s + " milisegundos!";
    }

    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
