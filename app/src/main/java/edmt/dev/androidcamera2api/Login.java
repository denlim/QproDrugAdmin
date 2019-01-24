package edmt.dev.androidcamera2api;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {


    public static String username1;

    private Button button;
    TextView username,password;

    RelativeLayout rellay1, rellay2;


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);
        username = (TextView) findViewById(R.id.usernamelogin);
        password = (TextView) findViewById(R.id.passwordlogin);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        button = (Button) findViewById(R.id.Login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Login.this,username.getText().toString(),Toast.LENGTH_SHORT).show();
                new loginapp(username.getText().toString(),password.getText().toString()).execute();
            }
        });
        button = (Button) findViewById(R.id.RegisterApp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenRegisterApp();
            }
        });
        button = (Button) findViewById(R.id.LupaPW);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenLupaPassword();
            }
        });

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 4000);


    }

    class loginapp extends AsyncTask<String, String, String>
    {
        private String username, password;

        public loginapp(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        protected String doInBackground(String... strings) {


            CallSoap cs = new CallSoap();

            String data = cs.LoginApps(username,password);

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
            if(s.equals("True"))
                OpenMainActivity();
            else {
                //Toast.makeText(Login.this, s, Toast.LENGTH_SHORT).show();
                Toast.makeText(Login.this,"Your Username or Password is Wrong !!!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void OpenMainActivity(){
        username1 = username.getText().toString();
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
    public void OpenRegisterApp(){
        Intent intent = new Intent(this, RegisterApp.class);
        startActivity(intent);
    }
    public void OpenLupaPassword(){
        Intent intent = new Intent(this, LupaPassword.class);
        startActivity(intent);
    }
}
