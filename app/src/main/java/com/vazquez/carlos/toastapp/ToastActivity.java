package com.vazquez.carlos.toastapp;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void onDefaultToast(View view) {
        Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.toast_default_msg_lbl), Toast.LENGTH_SHORT).show();
    }

    public void onCustomToast(View view) {
        LayoutInflater inflater = getLayoutInflater();

// Inflate the Layout
        View layout = inflater.inflate(
                R.layout.activity_toast_custom,
                (ViewGroup) findViewById(R.id.activity_toast_custom_layout));
        TextView text = (TextView) layout.findViewById(R.id.textToShow);

// Set the Text to show in TextView
        text.setText(getResources().getString(R.string.toast_custom_msg_lbl));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void onSnackBar(View view) {
        Snackbar.make(view, "SnackBar Message", Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.RED)
                .setAction("Undo", new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 System.out.println("Snackbar !!!");
 }
 }).show();
    }
}


