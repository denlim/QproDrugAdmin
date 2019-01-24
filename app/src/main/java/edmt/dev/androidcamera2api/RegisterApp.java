package edmt.dev.androidcamera2api;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterApp extends Activity {

    EditText name,password,parid,tgl,bln,thn;
    RadioButton pria,wanita;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register_app);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        name = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        parid = (EditText) findViewById(R.id.parid);
        pria = (RadioButton) findViewById(R.id.male);
        wanita = (RadioButton) findViewById(R.id.female);
        tgl = (EditText) findViewById(R.id.tanggal);
        bln = (EditText) findViewById(R.id.bulan);
        thn = (EditText) findViewById(R.id.tahun);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = tgl.getText().toString()+"/"+bln.getText().toString()+"/"+thn.getText().toString();
                String sex = "";
                if(pria.isChecked()==true)
                    sex = "Pria";
                else if(wanita.isChecked() == true)
                    sex = "Wanita";
                //Toast.makeText(RegisterApp.this,sex,Toast.LENGTH_SHORT).show();
                new registerapps(name.getText().toString(),password.getText().toString(),parid.getText().toString(),sex,date).execute();
            }
        });
    }

    class registerapps extends AsyncTask<String, String, String>
    {
        private String username, password,parid,sex,dob;

        public registerapps(String username, String password,String parid,String sex,String dob) {
            this.username = username;
            this.password = password;
            this.parid = parid;
            this.sex = sex;
            this.dob = dob;
        }

        @Override
        protected String doInBackground(String... strings) {

            CallSoap cs = new CallSoap();
            String data = cs.RegistrationApps(username,password,parid,sex,dob);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(RegisterApp.this,s,Toast.LENGTH_SHORT).show();
            OpenMainActivity();
        }
    }

    public void OpenMainActivity(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
