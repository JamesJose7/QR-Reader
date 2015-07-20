package com.fundamentos_programacion.jose.qrreader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fundamentos_programacion.jose.SampleDataBase.Individual;
import com.fundamentos_programacion.jose.SampleDataBase.IndividualCreator;


/**
 * <h1>Actividad que presenta los datos del Ciudadano</h1>
 * Utiliza el identificador contenido en el QR
 * de la anterior actividad para buscar el ciudadano en la base de
 * datos y presentar los datos respectivos.
 *
 * @author Jose Eguiguren
 * @author Stalin Carrion
 * @author Jose Godoy
 * @version 1.2
 * @since 2015-05-01
 */
public class FirstActivityScanner extends Activity implements AlertDialogFragment.MyInterface {

    protected IndividualCreator mCreator = MainActivity.mCreator;
    protected Individual[] mIndividuals;
    protected Individual mCurrentIndividual;

    private TextView mNameTextView;
    private LinearLayout mMenuInfraccionesLayout;
    private LinearLayout mInfraccionesLayout;

    private int counterForTextViews = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity_scanner);

        try {
            Intent intent = getIntent();
            String contents = intent.getStringExtra(MainActivity.INDIVIDUAL_NUMBER);
            int individualNumber = Integer.parseInt(contents);

            mIndividuals = mCreator.getIndividuals();
            mCurrentIndividual = mIndividuals[individualNumber];
        } catch (Exception e) {
            e.printStackTrace();
            alertUserAboutError();
        }


        //Views assignment
        mMenuInfraccionesLayout = (LinearLayout) findViewById(R.id.infraccionesLayout);
        mNameTextView = (TextView) findViewById(R.id.nameTextView);
        mInfraccionesLayout = (LinearLayout) findViewById(R.id.infraccionesIndividuo);
        Button agregarInfracciones = (Button) findViewById(R.id.agregarInfracciones);

        //Mas Info
        ImageButton masInfoButton = (ImageButton) findViewById(R.id.masInfoButton);
        final RelativeLayout masInfoLayout = (RelativeLayout) findViewById(R.id.informacionIndividuo);
        final TextView cedulaTextView = (TextView) findViewById(R.id.cedulaTextView);
        final TextView telefonoTextView = (TextView) findViewById(R.id.telefonoTextView);
        final TextView domicilioTextView = (TextView) findViewById(R.id.direccionTextView);

        //Add infracciones button
        agregarInfracciones.setOnClickListener(new View.OnClickListener() {
            /**
             * Muestra el menu de infracciones disponibles
             *
             */
            @Override
            public void onClick(View v) {
                mMenuInfraccionesLayout.setVisibility(View.VISIBLE);
            }
        });

        //Mas info button
        masInfoButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Muestra informacion adicional del ciudadano.
             *
             */
            @Override
            public void onClick(View v) {
                masInfoLayout.setVisibility(View.VISIBLE);
                cedulaTextView.setText(mCurrentIndividual.getCedula());
                telefonoTextView.setText(mCurrentIndividual.getTelefono());
                domicilioTextView.setText(mCurrentIndividual.getDomicilio());
            }
        });

        masInfoLayout.setOnClickListener(new View.OnClickListener() {
            /**
             * Permite remover el cuadro de informacion adicional al hacer click
             * en cualquier lado de la pantalla.
             */
            @Override
            public void onClick(View v) {
                masInfoLayout.setVisibility(View.GONE);
            }
        });

        mMenuInfraccionesLayout.setVisibility(View.INVISIBLE);
        masInfoLayout.setVisibility(View.GONE);

        try {
            setData();
        } catch (Exception e) {
            e.printStackTrace();
            alertUserAboutError();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_activity_scanner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Metodo de la interfaz creada en el dialogo para poder terminar
     * esta actividad.
     */
    @Override
    public void onChoose() { finish(); }

    /**
     * Actualiza la informacion actual del ciudadano en pantalla.
     */
    private void setData()  throws Exception {
        counterForTextViews = 0;

        mNameTextView.setText(mCurrentIndividual.getName());

        mInfraccionesLayout.removeAllViews();
        for (Map.Entry<String, String> entry : mCurrentIndividual.getInfracciones().entrySet()) {
            addInfraccionTextView(entry.getKey(), entry.getValue());
        }
    }


    /**
     * Agrega la infraccion correspondiente a la lista de infracciones del ciudadano.
     * <p></p>
     * Todos los botones usan el mismo metodo y se obtiene la fecha actual y la
     * infraccion con respecto al id del boton usado.
     */
    public void addInfraccionOnClick(View view) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM | hh:mm:ss a");
        Date date = new Date();

        String nuevoAntecedente = "";
        String nuevaFecha;


        //Set Dates
        nuevaFecha = formatter.format(date);

        switch (view.getId()) {
            case R.id.semaforoEnRojo:
                nuevoAntecedente = "Semaforo en rojo";
                break;
            case R.id.noEstacionar:
                nuevoAntecedente = "No estacionar";
                break;
            case  R.id.estadoEmbriaguez:
                nuevoAntecedente = "Estado de embriaguez";
                break;
            case R.id.excesoVelocidad:
                nuevoAntecedente = "Exceso de velocidad";
                break;
            case R.id.parabrisasRoto:
                nuevoAntecedente = "Parabrisas roto";
                break;
            case R.id.excesoPasajeros:
                nuevoAntecedente = "Exceso de pasajeros";
                break;
            case R.id.lesionesCausadas:
                nuevoAntecedente = "Lesiones causadas";
                break;
            case R.id.llantasMalEstado:
                nuevoAntecedente = "Llantas en mal estado";
                break;
            case R.id.bajoSustanciasE:
                nuevoAntecedente = "Bajo sustancias estupefacientes";
                break;
            case R.id.salir:
                nuevoAntecedente = "salir";
            default:
                break;

        }

        if (!nuevoAntecedente.equals("salir"))
            mCurrentIndividual.getInfracciones().put(nuevaFecha, nuevoAntecedente);

        mMenuInfraccionesLayout.setVisibility(View.INVISIBLE);

        setData();
    }

    /**
     * Agrega la nueva infraccion en una lista de views verticales.
     *
     * @param date fecha de la infraccion a mostrar.
     * @param infraccion infraccion a mostrar.
     */
    public void addInfraccionTextView(String date, String infraccion) {

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 50.0f);

        counterForTextViews++;
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setWeightSum(100);
        linearLayout.setPadding(12, 12, 12, 12);
        TextView textViewLeft = new TextView(getApplicationContext());
        textViewLeft.setText(date);
        textViewLeft.setLayoutParams(param);
        textViewLeft.setTextSize(15);
        TextView textViewRight = new TextView(getApplicationContext());
        textViewRight.setText(infraccion);
        textViewRight.setTextSize(15);
        textViewRight.setLayoutParams(param);
        textViewLeft.setTextColor(Color.parseColor("#cccccc"));
        textViewRight.setTextColor(Color.parseColor("#cccccc"));
        if(counterForTextViews % 2 == 0) {
            linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
            textViewLeft.setTextColor(Color.parseColor("#ffffff"));
            textViewRight.setTextColor(Color.parseColor("#ffffff"));
        }
        linearLayout.addView(textViewLeft);
        linearLayout.addView(textViewRight);

        mInfraccionesLayout.addView(linearLayout);
    }

    /**
     * Muestra el dialogo con el mensaje de error.
     */
    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }
}
