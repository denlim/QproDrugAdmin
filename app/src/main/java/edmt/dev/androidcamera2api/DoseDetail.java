package edmt.dev.androidcamera2api;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.shashank.sony.fancytoastlib.FancyToast;

public class DoseDetail extends AppCompatActivity {

    Button kom;
    TextView DoseName, Name, Med,prob,allerg,diagno,alamat,telp,textmed,textobat;
    String data, obat,dataobat = "",obattemp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dose_detail);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DoseName = (TextView) findViewById(R.id.textDose);
        Name = (TextView) findViewById(R.id.textName);
        Med = (TextView) findViewById(R.id.textMed);
        prob = (TextView) findViewById(R.id.problem);
        allerg = (TextView) findViewById(R.id.alergi);
        diagno = (TextView) findViewById(R.id.diagnosis);
        alamat = (TextView) findViewById(R.id.alamat);
        telp = (TextView) findViewById(R.id.telp);
        textmed = (TextView) findViewById(R.id.medno);
        textobat = (TextView) findViewById(R.id.textDose);

        if(ReaderActivity.name.toString().length() < 21) {
            data = ReaderActivity.name.toString();
            obat = ReaderETicketActivity.datatotal.toString();
        }
        else
        {
            obat = ReaderActivity.name.toString();
            data = ReaderETicketActivity.datatotal.toString();
        }

        //Toast.makeText(DoseDetail.this,data,Toast.LENGTH_SHORT).show();
        new medno(data).execute();
        new allergies(data).execute();
        new diagnose(data).execute();
        new problem(data).execute();
        new Patient(data).execute();
        new Dose(data,obat).execute();
        new Update(data,obat).execute();
        //Toast.makeText(DoseDetail.this,data,Toast.LENGTH_SHORT).show();
        kom = (Button) findViewById(R.id.kom);
        kom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMainActivity();
            }
        });
    }

    class medno extends AsyncTask<String, String, String>
    {
        String username1;

        public medno(String username) {
            this.username1 = username;
        }

        @Override
        protected String doInBackground(String... strings) {
            CallSoap cs = new CallSoap();
            String data = cs.Medno(username1);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Med.setText(s);
            textmed.setText(s);
        }
    }

    class allergies extends AsyncTask<String, String, String>
    {
        String username1;

        public allergies(String username) {
            this.username1 = username;
        }

        @Override
        protected String doInBackground(String... strings) {
            CallSoap cs = new CallSoap();
            String data = cs.allergies(username1);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //allerg.setText(s.substring(0,19));
            allerg.setText(s.replaceAll("#","\n"));
            //Toast.makeText(DoseDetail.this,s,Toast.LENGTH_SHORT).show();
        }
    }

    class diagnose extends AsyncTask<String, String, String>
    {
        String username1;

        public diagnose(String username) {
            this.username1 = username;
        }

        @Override
        protected String doInBackground(String... strings) {
            CallSoap cs = new CallSoap();
            String data = cs.Diagnose(username1);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            diagno.setText(s.replaceAll("#","\n"));
            //Toast.makeText(DoseDetail.this, dat, Toast.LENGTH_SHORT).show();
        }
    }

    class problem extends AsyncTask<String, String, String>
    {
        String username1;

        public problem(String username) {
            this.username1 = username;
        }

        @Override
        protected String doInBackground(String... strings) {
            CallSoap cs = new CallSoap();
            String data = cs.Problem(username1);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            prob.setText(s.replaceAll("#","\n"));
            //Toast.makeText(DoseDetail.this, dat, Toast.LENGTH_SHORT).show();
        }
    }

    class Patient extends AsyncTask<String, String, String>
    {
        String username1;

        public Patient(String username) {
            this.username1 = username;
        }

        @Override
        protected String doInBackground(String... strings) {
            CallSoap cs = new CallSoap();
            String data = cs.DetailPatient(username1);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String data[] = s.split("#");
            Name.setText(data[0]);
            alamat.setText(data[1]);
            telp.setText(data[2]);
            //Toast.makeText(DoseDetail.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    class Dose extends AsyncTask<String, String, String>
    {
        String username1,id;

        public Dose(String username,String id) {
            this.username1 = username;
            this.id = id;
        }

        @Override
        protected String doInBackground(String... strings) {
            String dose[] = id.split("#");
            String data = "";
            for(int i = 1; i < dose.length;i++) {
                CallSoap cs = new CallSoap();
                data = data + cs.DoseDetailPatient(username1, dose[i]) + "#";
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s1) {
            super.onPostExecute(s1);
            textobat.setText(s1.replaceAll("#","\n"));
            //Toast.makeText(DoseDetail.this, s1, Toast.LENGTH_SHORT).show();
        }
    }

    class Update extends AsyncTask<String, String, String>
    {
        String regno,itemid;

        public Update(String regno,String itemid) {
            this.regno = regno;
            this.itemid = itemid;
        }

        @Override
        protected String doInBackground(String... strings) {
            String dose[] = itemid.split("#");
            CallSoap cs = new CallSoap();
            String data ="";
            try {
                for (int i = 1; i < dose.length; i++) {
                    data = cs.DoseDetailPatientUpdate(regno,dose[i]);
                }
            }catch (Exception ec)
            {
                Toast.makeText(DoseDetail.this,ec.toString(),Toast.LENGTH_SHORT).show();
            }
            return itemid;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("True"))
            {
                Toast.makeText(DoseDetail.this,"Data Update",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(DoseDetail.this,s,Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void OpenMainActivity(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

}
