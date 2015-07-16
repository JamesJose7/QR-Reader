package SampleDataBase;

/**
 * Created by agua on 21/04/15.
 */
public class IndividualCreator {


    Individual firstIndividual = new Individual("Jaime", "ADG-584", "1105234976", "2653194", "Direccion");
    Individual secondIndividual = new Individual("Pedro", "LJG-885", "118936482", "2563421", "Direccion");
    Individual thirdIndividual = new Individual("Travis", "FFK-737", "1132534973", "2668402", "Direccion");
    Individual fourthIndividual = new Individual("Javier", "GSC-853", "1106345872", "2643162", "Direccion");
    Individual fifthIndividual = new Individual("James", "LOJ-235", "1194632053", "2671731", "Direccion");


    public Individual[] individuals = {firstIndividual, secondIndividual, thirdIndividual, fourthIndividual, fifthIndividual};

    public Individual[] getIndividuals() {
        return individuals;
    }
}
