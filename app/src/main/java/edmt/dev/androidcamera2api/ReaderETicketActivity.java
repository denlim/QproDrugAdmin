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
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReaderETicketActivity extends Activity {
    private Button Back_Btn;
    TextView toast1,hasil,hasil2,hasil3,hasil4,hasil5,hasil6;
    TextClock textClock;
    private ImageButton scan;
    public static String datatotal, boolis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reader_eticket);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        hasil = (TextView) findViewById(R.id.hasil);
        hasil2 = (TextView) findViewById(R.id.hasil2);
        hasil3 = (TextView) findViewById(R.id.hasil3);
        toast1 = (TextView) findViewById(R.id.toast1);
        hasil4 = (TextView) findViewById(R.id.hasil4);
        hasil5 = (TextView) findViewById(R.id.hasil5);
        hasil6 = (TextView) findViewById(R.id.text2);
        textClock = (TextClock) findViewById(R.id.textClock);
        scan = (ImageButton) findViewById(R.id.scan);
        Back_Btn = (Button) findViewById(R.id.home_btn);

        Back_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datatotal.length()<21) {
                    String val[] = ReaderActivity.name.split("#");
                    if (val[0].equals(datatotal)) {
                            Intent intent = new Intent(ReaderETicketActivity.this, DoseDetail.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);
                    } else {
                        Toast.makeText(ReaderETicketActivity.this, "Obat Dan Pasien Tidak Cocok", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    String val[] = datatotal.split("#");
                    //Toast.makeText(ReaderETicketActivity.this, datatotal, Toast.LENGTH_SHORT).show();
                    if (val[0].equals(ReaderActivity.name)) {
                        Intent intent = new Intent(ReaderETicketActivity.this, DoseDetail.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ReaderETicketActivity.this, "Obat Dan Pasien Tidak Cocok", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(ReaderETicketActivity.this, "Obat Dan Pasien Tidak Cocok", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        final Activity activity = this;
        scan.setOnClickListener(new View.OnClickListener() {
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
        String result1 = result.toString();

        if(result1 != null) {
            if (result.getContents() == null) {
                FancyToast.makeText(this, "You cancelled the scanning", FancyToast.LENGTH_LONG, FancyToast.WARNING, true).show();
            } else {
                datatotal = result.getContents();
                //FancyToast.makeText(this, index.toString(), FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}

