package edmt.dev.androidcamera2api;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderActivity extends Activity {
    private Button scan_btn,nextBtn;
    public static String name;
    TextView toast1,toast2;
    private ImageButton scanbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_reader);
        scan_btn = (Button) findViewById(R.id.scan_btn);
        nextBtn = (Button) findViewById(R.id.nextbtn);
        toast1 = (TextView) findViewById(R.id.toast1);
        toast2 = (TextView) findViewById(R.id.toast2) ;
        scanbtn1 = (ImageButton) findViewById(R.id.scanbtn1);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReaderETicketActivity();
            }
        });

        final Activity activity = this;


        scanbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                FancyToast.makeText(this,"You cancelled the scanning",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
            }
            else {
                name = result.getContents();
                //FancyToast.makeText(this, name,FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    public void openReaderETicketActivity(){
        Intent intent = new Intent(ReaderActivity.this, ReaderETicketActivity.class);
        startActivity(intent);
    }

    public void openreaderactivity(){
        Toast.makeText(ReaderActivity.this,"You must Scan First",Toast.LENGTH_SHORT);
        Intent intent = new Intent(this, ReaderActivity.class);
        startActivity(intent);
    }
}

