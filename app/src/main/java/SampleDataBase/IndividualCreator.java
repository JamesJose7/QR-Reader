package SampleDataBase;

/**
 * Created by agua on 21/04/15.
 */
public class IndividualCreator {


    public static final String NO_ANTECEDENTES = "No antecedentes";

    Individual firstIndividual = new Individual("Jaime", 1, "ADG-584");
    Individual secondIndividual = new Individual("Pedro", 2, "LJG-885");
    Individual thirdIndividual = new Individual("Travis", 3, "FFK-737");
    Individual fourthIndividual = new Individual("Javier", 4, "GSC-853");
    Individual fifthIndividual = new Individual("James", 5, "LOJ-235");


    public Individual[] individuals = {firstIndividual, secondIndividual, thirdIndividual, fourthIndividual, fifthIndividual};

    public Individual[] getIndividuals() {
        return individuals;
    }
}
