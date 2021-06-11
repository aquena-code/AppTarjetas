package com.software.alv.calctarjetas;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;

/**
 * Created by ALVARO on 07/07/2016.
 */
public class class_cambio extends Activity {

    public TextView txvw_TotTarjetas,txvw_Cambio;
    public EditText edtx_Pago;
    public double total_tarjetas;
    public DecimalFormat dosDecimales = new DecimalFormat("#,###.00");
    public DecimalFormatSymbols puntoDecimal = new DecimalFormatSymbols();


    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.layout_cambio);

        puntoDecimal.setDecimalSeparator('.');
        puntoDecimal.setGroupingSeparator(',');
        dosDecimales.setDecimalFormatSymbols(puntoDecimal);

        txvw_Cambio = (TextView) findViewById(R.id.txvw_Cambio);
        txvw_TotTarjetas = (TextView) findViewById(R.id.txvw_totTarjetas);
        edtx_Pago = (EditText) findViewById(R.id.edtx_Paga);
        edtx_Pago.setText("0");
        total_tarjetas = Double.parseDouble(getIntent().getStringExtra("total"));
        txvw_TotTarjetas.setText(dosDecimales.format(total_tarjetas));



        edtx_Pago.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (TextUtils.equals("0", edtx_Pago.getText().toString()))
                        edtx_Pago.setText("");
                }
                if (!hasFocus){
                    if (TextUtils.isEmpty(edtx_Pago.getText().toString()))
                        edtx_Pago.setText("0");
                }

            }
        });

    }

    public void Cambio(View v){
        double cambio;
        double paga;

        if (TextUtils.equals("", edtx_Pago.getText().toString()))   edtx_Pago.setText("0");

            paga = dosDecimales.parse(edtx_Pago.getText().toString(),new ParsePosition(0)).doubleValue();
            cambio = paga - total_tarjetas;
            txvw_Cambio.setText(String.valueOf(dosDecimales.format(cambio)));
            edtx_Pago.setText(String.valueOf(dosDecimales.format(paga)));



    }
}
