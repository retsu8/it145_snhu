/******************************************************************
** 
** 5.4 Menu Loop and Monkey Intake
** Monkey.java
** 
** @Author William Paddock
** Southern New Hampshire University
** IT-145-11107-M01 Found in App Development 2024 C-5 (Sept - Oct)
** Dr. Vivian Lyon
** Sept 2, 2024
**
******************************************************************/

import java.util.*;

public class Monkey extends RescueAnimal {

    // Instance variable for monkey
    private String breed;
    private String height;
    private String bodyLength;
    private String species;
    private String tailLength;

    // Creating species list of expected species
    private static ArrayList<String> monkeySpeciesList = new ArrayList<>(Arrays.asList(
            "capuchin","guenon","macaque","marmoset","squirrel monkey","tamarin"
        ));

    // Constructor
    public Monkey(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, String tailLength, 
    String height, String bodyLength, String species) {
        /* adding in new items expected for monkey ouble tailLength, 
        String height, String bodyLength, String species */
        setName(name);
        setBreed(breed);
        setSpecies(species);
        setGender(gender);
        setAge(age);       
        setWeight(weight);
        setHeight(height);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    public String getBreed() {
        /* Accessor Method get breed */
        return breed;
    }

    public void setBreed(String monkeyBreed) {
        /* Mutator Method set breed */
        breed = monkeyBreed;
    }

    public void setSpecies(String monkeySpecies){
        /* Check the species list for monkeys*/
        species = monkeySpecies;
    }

    public String getSpecies(){
        /* Return the species list for monkeys */
        return species;
    }

    public void setHeight(String monkeyHeight){
        /* Set the height of the monkey */
        height = monkeyHeight;
    }

    public String getHeight(){
        /* Return the monkey height */
        return height;
    }

    public void setBodyLength(String monkeyBodyLength){
        /* Set the monkey body length */
        bodyLength = monkeyBodyLength;
    }

    public String getBodyLength(){
        /* Return the monkey body length */
        return bodyLength;
    }

    public void setTailLength(String monkeyTail){
        /* monkey must have a tail of some length */
        tailLength = monkeyTail;
    }
    public String getTailLength(){
        /* Return the monkey tail length */
        return tailLength;
    }
    public static ArrayList getAcceptedSpecies(){
        return monkeySpeciesList;
    }
}
