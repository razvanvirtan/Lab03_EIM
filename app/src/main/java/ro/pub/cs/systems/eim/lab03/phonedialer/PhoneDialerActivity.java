package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonHashtag = (Button) findViewById(R.id.buttonHashtag);
        Button buttonStar = (Button) findViewById(R.id.buttonStar);
        ImageButton buttonRemove = (ImageButton) findViewById(R.id.buttonRemove);
        ImageButton buttonCall = (ImageButton) findViewById(R.id.buttonCall);
        ImageButton buttonStop = (ImageButton) findViewById(R.id.buttonStop);

        button0.setOnClickListener(new Listener());
        button1.setOnClickListener(new Listener());
        button2.setOnClickListener(new Listener());
        button3.setOnClickListener(new Listener());
        button4.setOnClickListener(new Listener());
        button5.setOnClickListener(new Listener());
        button6.setOnClickListener(new Listener());
        button7.setOnClickListener(new Listener());
        button8.setOnClickListener(new Listener());
        button9.setOnClickListener(new Listener());
        buttonStar.setOnClickListener(new Listener());
        buttonHashtag.setOnClickListener(new Listener());
        buttonStop.setOnClickListener(new Listener());
        buttonRemove.setOnClickListener(new Listener());
        buttonCall.setOnClickListener(new Listener());

    }

    class Listener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText phoneNumber = (EditText) findViewById(R.id.numberSpace);
            int id = view.getId();

            switch (id){
                case R.id.button0:
                    phoneNumber.setText(phoneNumber.getText().toString() + "0");
                    break;
                case R.id.button1:
                    phoneNumber.setText(phoneNumber.getText().toString() + "1");
                    break;
                case R.id.button2:
                    phoneNumber.setText(phoneNumber.getText().toString() + "2");
                    break;
                case R.id.button3:
                    phoneNumber.setText(phoneNumber.getText().toString() + "3");
                    break;
                case R.id.button4:
                    phoneNumber.setText(phoneNumber.getText().toString() + "4");
                    break;
                case R.id.button5:
                    phoneNumber.setText(phoneNumber.getText().toString() + "5");
                    break;
                case R.id.button6:
                    phoneNumber.setText(phoneNumber.getText().toString() + "6");
                    break;
                case R.id.button7:
                    phoneNumber.setText(phoneNumber.getText().toString() + "7");
                    break;
                case R.id.button8:
                    phoneNumber.setText(phoneNumber.getText().toString() + "8");
                    break;
                case R.id.button9:
                    phoneNumber.setText(phoneNumber.getText().toString() + "9");
                    break;
                case R.id.buttonStar:
                    phoneNumber.setText(phoneNumber.getText().toString() + "*");
                    break;
                case R.id.buttonHashtag:
                    phoneNumber.setText(phoneNumber.getText().toString() + "#");
                    break;
                case R.id.buttonRemove:
                    String text =phoneNumber.getText().toString();
                    phoneNumber.setText(text.substring(0, text.length() - 1));
                    break;
                case R.id.buttonStop:
                    finish();
                    break;
                case R.id.buttonCall:
                    if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                PhoneDialerActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                200);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                        startActivity(intent);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}