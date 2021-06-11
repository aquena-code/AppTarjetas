package com.software.alv.calctarjetas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by ALVARO on 06/07/2016.
 */
public class class_content_tarjetas extends Activity {
    private EditText edtx_Viva;
    private EditText edtx_Tigo;
    private EditText edtx_Entel15;
    private EditText edtx_Entel30;
    private EditText edtx_Entel50;
    private DecimalFormat dosDecimales = new DecimalFormat("#,##0.00");
    private DecimalFormatSymbols puntoDec= new DecimalFormatSymbols();
    private Button btn_Calcular,btn_Limpiar,btn_Cambio;

    private TextView txvw_Entel, txvw_Viva, txvw_Tigo, txvw_Total,txvw_Entel15,txvw_Entel30,txvw_Entel50;

    private double tot_Entel,tot_Viva,tot_Tigo, Total,tot_Entel15,tot_Entel30,tot_Entel50;

    @Override
    public void onCreate (Bundle b){



        super.onCreate(b);
        setContentView(R.layout.content_tarjetas);

        edtx_Entel50 = (EditText) findViewById(R.id.edtx_entel50);
        edtx_Entel50.setText("0");

        edtx_Entel30 = (EditText) findViewById(R.id.edtx_entel30);
        edtx_Entel30.setText("0");

        edtx_Entel15 = (EditText) findViewById(R.id.edtx_entel15);
        edtx_Entel15.setText("0");

        edtx_Viva = (EditText) findViewById(R.id.edtx_viva);
        edtx_Viva.setText("0");


        edtx_Tigo = (EditText) findViewById(R.id.edtx_tigo);
        edtx_Tigo.setText("0");

        final EditText edtx_Entel = (EditText) findViewById(R.id.edtx_entel);
        edtx_Entel.setText("0");

        txvw_Entel50 = (TextView) findViewById(R.id.txvw_totEntel50);
        txvw_Entel50.setText("0");
        txvw_Entel30 = (TextView) findViewById(R.id.txvw_totEntel30);
        txvw_Entel30.setText("0");
        txvw_Entel15 = (TextView) findViewById(R.id.txvw_totEntel15);
        txvw_Entel15.setText("0");
        txvw_Entel = (TextView) findViewById(R.id.txvw_totEntel);
        txvw_Entel.setText("0");
        txvw_Viva = (TextView) findViewById(R.id.txvw_totViva);
        txvw_Viva.setText("0");
        txvw_Tigo = (TextView) findViewById(R.id.txvw_totTigo);
        txvw_Tigo.setText("0");
        txvw_Total = (TextView) findViewById(R.id.txvw_Total);
        txvw_Total.setText("0");


        btn_Calcular = (Button) findViewById(R.id.btn_Calcular);
        btn_Limpiar = (Button) findViewById(R.id.btn_Limpiar);
        btn_Cambio = (Button) findViewById(R.id.btn_Cambio);
        puntoDec.setDecimalSeparator('.');
        puntoDec.setGroupingSeparator(',');
        dosDecimales.setDecimalFormatSymbols(puntoDec);



        /**Redondea la imagen de Entel50*/
        Drawable drw_Entel50 = getResources().getDrawable(R.mipmap.entel_50);
        Bitmap bmp_Entel50 = ((BitmapDrawable)drw_Entel50).getBitmap();

        RoundedBitmapDrawable rbd_Entel50 = RoundedBitmapDrawableFactory.create(getResources(), bmp_Entel50);
        rbd_Entel50.setCornerRadius(bmp_Entel50.getHeight());
        ImageView imv_Entel50 = (ImageView)findViewById(R.id.entel50);
        imv_Entel50.setImageDrawable(rbd_Entel50);

        /**Redondea la imagen de Entel30*/
        Drawable drw_Entel30 = getResources().getDrawable(R.mipmap.entel_30);
        Bitmap bmp_Entel30 = ((BitmapDrawable)drw_Entel30).getBitmap();

        RoundedBitmapDrawable rbd_Entel30 = RoundedBitmapDrawableFactory.create(getResources(), bmp_Entel30);
        rbd_Entel30.setCornerRadius(bmp_Entel30.getHeight());
        ImageView imv_Entel30 = (ImageView)findViewById(R.id.entel30);
        imv_Entel30.setImageDrawable(rbd_Entel30);

        /**Redondea la imagen de Entel15*/
        Drawable drw_Entel15 = getResources().getDrawable(R.mipmap.ente_15);
        Bitmap bmp_Entel15 = ((BitmapDrawable)drw_Entel15).getBitmap();

        RoundedBitmapDrawable rbd_Entel15 = RoundedBitmapDrawableFactory.create(getResources(), bmp_Entel15);
        rbd_Entel15.setCornerRadius(bmp_Entel15.getHeight());
        ImageView imv_Entel15 = (ImageView)findViewById(R.id.entel15);
        imv_Entel15.setImageDrawable(rbd_Entel15);

        /**Redondea la imagen de Entel*/
        Drawable drw_Entel = getResources().getDrawable(R.mipmap.entel);
        Bitmap bmp_Entel = ((BitmapDrawable)drw_Entel).getBitmap();

        RoundedBitmapDrawable rbd_Entel = RoundedBitmapDrawableFactory.create(getResources(), bmp_Entel);
        rbd_Entel.setCornerRadius(bmp_Entel.getHeight());
        ImageView imv_Entel = (ImageView)findViewById(R.id.imvw_entel);
        imv_Entel.setImageDrawable(rbd_Entel);
        /**Redondea la imagen de Viva*/
        Drawable drw_Viva = getResources().getDrawable(R.mipmap.viva);
        Bitmap bmp_Viva = ((BitmapDrawable)drw_Viva).getBitmap();

        RoundedBitmapDrawable rbd_Viva = RoundedBitmapDrawableFactory.create(getResources(),bmp_Viva);
        rbd_Viva.setCornerRadius(bmp_Viva.getHeight());
        ImageView imv_Viva = (ImageView)findViewById(R.id.imvw_viva);
        imv_Viva.setImageDrawable(rbd_Viva);
        /**Redondea la imagen de Tigo*/
        Drawable drw_Tigo = getResources().getDrawable(R.mipmap.tigo);
        Bitmap bmp_Tigo = ((BitmapDrawable)drw_Tigo).getBitmap();

        RoundedBitmapDrawable rbd_Tigo = RoundedBitmapDrawableFactory.create(getResources(), bmp_Tigo);
        rbd_Tigo.setCornerRadius(bmp_Tigo.getHeight());
        ImageView imv_Tigo = (ImageView)findViewById(R.id.imvw_tigo);
        imv_Tigo.setImageDrawable(rbd_Tigo);


        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals("", edtx_Entel50.getText().toString()))
                    edtx_Entel50.setText("0");

                if (TextUtils.equals("", edtx_Entel30.getText().toString()))
                    edtx_Entel30.setText("0");
                if (TextUtils.equals("", edtx_Entel15.getText().toString()))
                    edtx_Entel15.setText("0");
                if (TextUtils.equals("", edtx_Entel.getText().toString())) edtx_Entel.setText("0");
                if (TextUtils.equals("", edtx_Tigo.getText().toString())) edtx_Tigo.setText("0");
                if (TextUtils.equals("", edtx_Viva.getText().toString())) edtx_Viva.setText("0");

                tot_Entel50 = Math.rint((Double.parseDouble(edtx_Entel50.getText().toString()) * 46.5) * 100) / 100;
                txvw_Entel50.setText(String.valueOf(dosDecimales.format(tot_Entel50)));

                tot_Entel30 = Math.rint((Double.parseDouble(edtx_Entel30.getText().toString()) * 27.5) * 100) / 100;
                txvw_Entel30.setText(String.valueOf(dosDecimales.format(tot_Entel30)));

                tot_Entel15 = Math.rint((Double.parseDouble(edtx_Entel15.getText().toString()) * 14.1) * 100) / 100;
                txvw_Entel15.setText(String.valueOf(dosDecimales.format(tot_Entel15)));

                tot_Entel = Math.rint((Double.parseDouble(edtx_Entel.getText().toString()) * 9.4) * 100) / 100;
                txvw_Entel.setText(String.valueOf(dosDecimales.format(tot_Entel)));

                tot_Viva = Math.rint((Double.parseDouble(edtx_Viva.getText().toString()) * 9.5) * 100) / 100;
                txvw_Viva.setText(String.valueOf(dosDecimales.format(tot_Viva)));

                tot_Tigo = Math.rint((Double.parseDouble(edtx_Tigo.getText().toString()) * 9.5) * 100) / 100;
                txvw_Tigo.setText(String.valueOf(dosDecimales.format(tot_Tigo)));

                Total = tot_Entel + tot_Viva + tot_Tigo + tot_Entel15 + tot_Entel30 + tot_Entel50;
                txvw_Total.setText(String.valueOf(dosDecimales.format(Total)));

            }
        });


        btn_Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtx_Entel.hasFocus())  edtx_Entel.setText("");
                else    edtx_Entel.setText("0");

                if(edtx_Entel50.hasFocus()) edtx_Entel50.setText("");
                else    edtx_Entel50.setText("0");

                if (edtx_Entel15.hasFocus()) edtx_Entel15.setText("");
                else    edtx_Entel15.setText("0");

                if (edtx_Entel30.hasFocus())    edtx_Entel30.setText("");
                else    edtx_Entel30.setText("0");

                if (edtx_Viva.hasFocus())   edtx_Viva.setText("");
                else    edtx_Viva.setText("0");

                if (edtx_Tigo.hasFocus())   edtx_Tigo.setText("");
                else    edtx_Tigo.setText("0");

                //edtx_Entel.setText("0"); edtx_Tigo.setText("0"); edtx_Viva.setText("0"); edtx_Entel15.setText("0"); edtx_Entel30.setText("0"); edtx_Entel50.setText("0");
                txvw_Entel.setText("0"); txvw_Tigo.setText("0"); txvw_Viva.setText("0"); txvw_Entel15.setText("0"); txvw_Entel30.setText("0"); txvw_Entel50.setText("0");
                txvw_Total.setText("0");
            }
        });

        edtx_Entel50.setOnFocusChangeListener(new View.OnFocusChangeListener()

                                              {
                                                  @Override
                                                  public void onFocusChange(View v, boolean hasFocus) {
                                                      if (hasFocus) {
                                                          if (TextUtils.equals("0", edtx_Entel50.getText().toString()))
                                                              edtx_Entel50.setText("");

                                                      }
                                                      if (!hasFocus) {
                                                          if (TextUtils.isEmpty(edtx_Entel50.getText().toString()))
                                                              edtx_Entel50.setText("0");
                                                      }
                                                  }
                                              }

        );

        edtx_Entel30.setOnFocusChangeListener(new View.OnFocusChangeListener()

                                              {
                                                  @Override
                                                  public void onFocusChange(View v, boolean hasFocus) {
                                                      if (hasFocus) {
                                                          if (TextUtils.equals("0", edtx_Entel30.getText().toString()))
                                                              edtx_Entel30.setText("");

                                                      }
                                                      if (!hasFocus) {
                                                          if (TextUtils.isEmpty(edtx_Entel30.getText().toString()))
                                                              edtx_Entel30.setText("0");
                                                      }
                                                  }
                                              }

        );

        edtx_Entel15.setOnFocusChangeListener(new View.OnFocusChangeListener()

                                            {
                                                @Override
                                                public void onFocusChange(View v, boolean hasFocus) {
                                                    if (hasFocus) {
                                                        if (TextUtils.equals("0", edtx_Entel15.getText().toString()))
                                                            edtx_Entel15.setText("");

                                                    }
                                                    if (!hasFocus) {
                                                        if (TextUtils.isEmpty(edtx_Entel15.getText().toString()))
                                                            edtx_Entel15.setText("0");
                                                    }
                                                }
                                            }

        );

            edtx_Entel.setOnFocusChangeListener(new View.OnFocusChangeListener()

                                                {
                                                    @Override
                                                    public void onFocusChange(View v, boolean hasFocus) {
                                                        if (hasFocus) {
                                                            if (TextUtils.equals("0", edtx_Entel.getText().toString()))
                                                                edtx_Entel.setText("");

                                                        }
                                                        if (!hasFocus) {
                                                            if (TextUtils.isEmpty(edtx_Entel.getText().toString()))
                                                                edtx_Entel.setText("0");
                                                        }
                                                    }
                                                }

            );

            edtx_Tigo.setOnFocusChangeListener(new View.OnFocusChangeListener()

                                               {
                                                   @Override
                                                   public void onFocusChange(View v, boolean hasFocus) {
                                                       if (hasFocus) {
                                                           if (TextUtils.equals("0", edtx_Tigo.getText().toString()))
                                                               edtx_Tigo.setText("");
                                                       }

                                                       if (!hasFocus) {
                                                           if (TextUtils.isEmpty(edtx_Tigo.getText().toString()))
                                                               edtx_Tigo.setText("0");
                                                       }
                                                   }
                                               }

            );

            edtx_Viva.setOnFocusChangeListener(new View.OnFocusChangeListener()

                                               {
                                                   @Override
                                                   public void onFocusChange(View v, boolean hasFocus) {
                                                       if (hasFocus) {
                                                           if (TextUtils.equals("0", edtx_Viva.getText().toString()))
                                                               edtx_Viva.setText("");
                                                       }
                                                       if (!hasFocus) {
                                                           if (TextUtils.isEmpty(edtx_Viva.getText().toString()))
                                                               edtx_Viva.setText("0");
                                                       }
                                                   }
                                               }

            );

        }



    public void mostrarCambio (View v){
        Intent i = new Intent(this, class_cambio.class);
        i.putExtra("total", String.valueOf(Total));
        startActivity(i);
    }

    }
