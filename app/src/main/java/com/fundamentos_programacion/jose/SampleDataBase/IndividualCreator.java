package com.fundamentos_programacion.jose.SampleDataBase;

/**
 * Crea varios individuos y los almacena en un arreglo.
 *
 * @author Jose
 * @version 1.0
 * @since 2015-05-01
 */
public class IndividualCreator {

    Individual firstIndividual = new Individual("Jaime", "ADG-584", "1105234976", "2653194", "Pitas");
    Individual secondIndividual = new Individual("Pedro", "LJG-885", "118936482", "2563421", "El Valle");
    Individual thirdIndividual = new Individual("Travis", "FFK-737", "1132534973", "2668402", "Zamora Huayco");
    Individual fourthIndividual = new Individual("Javier", "GSC-853", "1106345872", "2643162", "La Argelia");
    Individual fifthIndividual = new Individual("James", "LOJ-235", "1194632053", "2671731", "Loja?");

    private Individual[] mIndividuals = {firstIndividual, secondIndividual, thirdIndividual, fourthIndividual, fifthIndividual};

    public Individual[] getIndividuals() {
        return mIndividuals;
    }
}
