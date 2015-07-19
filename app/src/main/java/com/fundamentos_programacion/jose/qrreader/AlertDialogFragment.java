package com.fundamentos_programacion.jose.qrreader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Dialogo para alertar al usuario sobre un error
 *
 * @author Jose Eduardo
 * @since 19-07-2015
 * @version 1.0
 */
public class AlertDialogFragment extends DialogFragment {

    /**
     * Interfaz para poder terminar la actividad desde el dialogo al ser
     * implementada en FirstActivityScanner.
     */
    public static interface MyInterface {
        public void onChoose();
    }

    private MyInterface mListener;

    @Override
    public void onAttach(Activity activity) {
        mListener = (MyInterface) activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    /**
     * Construye el Dialogo con el listener en el boton para terminar la actividad
     * al ser presionado
     *
     * @return El dialogo construido
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Error!")
                .setMessage("Ciudadano no se encuentra registrado")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onChoose();
                    }
                });

        AlertDialog dialog = builder.create();
        return dialog;
    }
}