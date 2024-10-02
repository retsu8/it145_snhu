/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  5.4 Menu Loop and Monkey Intake
****************************/

import java.util.*;
import java.lang.Double;

public class Monkey extends RescueAnimal {

    // Instance variable for monkey
    private String breed;
    private String height;
    private String bodyLength;
    private String species;
    private String tailLength;

    // Creating species list of expected species
    private final List<String> speciesList = Arrays.asList(
        "capuchin","guenon","macaque","marmoset","squirrel monkey","tamarin"
    );

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

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String monkeyBreed) {
        breed = monkeyBreed;
    }

    public void setSpecies(String monkeySpecies){
        /* Check the species list for monkeys*/
        if(speciesList.contains(monkeySpecies.toLowerCase())){
            species = monkeySpecies;
        } else {
            species = "";
        }
    }

    public String getSpecies(){
        /* Return the species list for monkeys */
        return species;
    }

    public void setHeight(String monkeyHeight){
        /* Set the height of the monkey */
        // Monkey must have some heigth
        Double monkeyHeightDouble = Double.parseDouble(monkeyHeight); 
        if(monkeyHeightDouble > 0){
            height = monkeyHeight;
        } else {
            height = "0.0";
        }
    }

    public String getHeight(){
        /* Return the monkey height */
        return height;
    }

    public void setBodyLength(String monkeyBodyLength){
        /* Set the monkey body length */
        /* monkey must have a body of some length */
        Double monkeyBodyLengthDouble = Double.parseDouble(monkeyBodyLength); 
        if(monkeyBodyLengthDouble > 0){
            bodyLength = monkeyBodyLength;
        } else {
            bodyLength = "0.0";
        }
    }

    public String getBodyLength(){
        /* Return the monkey body length */
        return bodyLength;
    }

    public void setTailLength(String monkeyTail){
        /* monkey must have a tail of some length */
        Double monkeyTailDouble = Double.parseDouble(monkeyTail); 
        if(monkeyTailDouble > 0.0){
            tailLength = monkeyTail;
        } else {
            tailLength = "0.0";
        }
    }
    public String getTailLength(){
        /* Return the monkey tail length */
        return tailLength;
    }
}
