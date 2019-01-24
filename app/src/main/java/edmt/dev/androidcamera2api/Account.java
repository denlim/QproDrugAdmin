package edmt.dev.androidcamera2api;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends Activity {

    TextView name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_account);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        new account(Login.username1).execute();
    }

    class account extends AsyncTask<String, String, String>
    {
        private String username, password;

        public account(String username) {
            this.username = username;
        }

        @Override
        protected String doInBackground(String... strings) {

            CallSoap cs = new CallSoap();
            String data = cs.Account(username);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
            String data[] = s.split("#");
            name.setText(data[1]);
            email.setText(data[0]);
        }
    }
}
