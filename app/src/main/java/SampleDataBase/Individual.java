package SampleDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by agua on 21/04/15.
 */
public class Individual {

    private String mName;
    private int mID;
    private String mPlate;
    private Map<String, String> mInfracciones;

    public Individual(String name, int id, String plate) {
        mInfracciones = new TreeMap<>();
        mName = name;
        mID = id;
        mPlate = plate;
    }

    public int getID() {
        return mID;
    }

    public String getPlate() {
        return mPlate;
    }

    public String getName() {
        return mName;
    }

    public Map<String, String> getInfracciones() {
        return mInfracciones;
    }

    public void setInfraccion(Map<String, String> infracciones) {
        mInfracciones = infracciones;
    }
}
