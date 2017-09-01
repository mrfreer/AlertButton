package com.example.android.alertbutton;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button button_sbm;
    private static AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClickListener();
    }

    public void onButtonClickListener(){
        button_sbm = (Button)findViewById(R.id.button);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //create alert dialog
                        AlertDialog.Builder a_builder = new  AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Do you want to Close this App?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish(); //closes App gracefully
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel(); //closes dialog box
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert !!");
                        alert.show();
                    }
                }
        );

    }
}
