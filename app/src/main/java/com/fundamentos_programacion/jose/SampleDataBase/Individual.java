package com.fundamentos_programacion.jose.SampleDataBase;

import java.util.Map;
import java.util.TreeMap;

/**
 * Objeto de cada individuo
 *
 * @author Jose
 * @version 1.1
 * @since 2015-05-01
 */
public class Individual {

    private String mName;
    private String mPlate;
    private String mCedula;
    private String mTelefono;
    private String mDomicilio;
    private Map<String, String> mInfracciones;

    public Individual(String name, String plate, String cedula, String telefono, String domicilio) {
        mInfracciones = new TreeMap<>();
        mName = name;
        mPlate = plate;
        mCedula = cedula;
        mTelefono = telefono;
        mDomicilio = domicilio;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPlate() {
        return mPlate;
    }

    public void setPlate(String plate) {
        mPlate = plate;
    }

    public String getCedula() {
        return mCedula;
    }

    public void setCedula(String cedula) {
        mCedula = cedula;
    }

    public String getTelefono() {
        return mTelefono;
    }

    public void setTelefono(String telefono) {
        mTelefono = telefono;
    }

    public String getDomicilio() {
        return mDomicilio;
    }

    public void setDomicilio(String domicilio) {
        mDomicilio = domicilio;
    }

    public Map<String, String> getInfracciones() {
        return mInfracciones;
    }

    public void setInfracciones(Map<String, String> infracciones) {
        mInfracciones = infracciones;
    }
}
