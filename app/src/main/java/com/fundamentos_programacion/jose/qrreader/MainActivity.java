package com.fundamentos_programacion.jose.qrreader;

import android.content.Intent;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.integration.android.IntentIntegrator;

import com.fundamentos_programacion.jose.SampleDataBase.IndividualCreator;


/**
 * <h1>Aplicacion para registrar infracciones mediante codigos QR</h1>
 * Esta es la primera actividad al iniciar la aplicacion que inicializa el scanner de codigo QR
 *
 * @author Jose Eguiguren
 * @author Stalin Carrion
 * @author Jose Godoy
 * @version 1.2
 * @since 2015-05-01
 */

public class MainActivity extends Activity {

    private IntentIntegrator integrator = new IntentIntegrator(this);

    public static final IndividualCreator mCreator = new IndividualCreator();

    public static final String INDIVIDUAL_NUMBER = "INDIVIDUAL_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView buttonStartScan = (ImageView) findViewById(R.id.buttonStartScan);



        buttonStartScan.setOnClickListener(new View.OnClickListener() {
            /**
             * Al hacer click en el boton el escaner de codigo QR se inicializa
             *
             * @param v En este caso la view es el boton del escaner
             */
            @Override
            public void onClick(View v) {

                integrator.setOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                integrator.setScanningRectangle(500, 500);
                integrator.setCaptureLayout(R.layout.custom_capture_layout);
                integrator.setLegacyCaptureLayout(R.layout.custom_legacy_capture_layout);
                integrator.initiateScan();

            }
        });

    }

    /**
     * Llamado al realizar un escaneo de un codigo QR
     *
     * @param requestCode
     * @param resultCode Codigo del resultado de la actividad que realizo el escaner
     * @param intent Intent de la actividad del escaner
     */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (resultCode == RESULT_CANCELED) {
            //Handle cancel
        } else {
            String contents = intent.getStringExtra("SCAN_RESULT");
            String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

            startNewActivity(contents);
        }
    }

    /**
     * Inicia la nueva actividad con los datos recibidos del codigo QR
     *
     * @param contents contenido del codigo QR
     */
    public void startNewActivity(String contents) {

        Intent intent = new Intent(this, FirstActivityScanner.class);
        intent.putExtra(INDIVIDUAL_NUMBER, contents);
        startActivity(intent);

    }
}
