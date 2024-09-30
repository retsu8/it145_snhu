/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  5.4 Menu Loop and Monkey Intake
****************************/

import java.util.*;

public class Monkey extends RescueAnimal {

    // Instance variable for monkey
    private String breed;
    private Double height;
    private Double bodyLength;
    private String species;
    private Double tailLength;

    // Creating species list of expected species
    private final List<String> speciesList = Arrays.asList(
        "capuchin","guenon","macaque","marmoset","squirrel monkey","tamarin"
    );

    // Constructor
    public Monkey(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, Double tailLength, 
    Double height, Double bodyLength, String species) {
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

    public void setHeight(Double monkeyHeight){
        /* Set the height of the monkey */
        // Monkey must have some heigth
        if(monkeyHeight > 0){
            height = monkeyHeight;
        } else {
            height = 0.0;
        }
    }

    public Double getHeight(){
        /* Return the monkey height */
        return height;
    }

    public void setBodyLength(Double monkeyBodyLength){
        /* Set the monkey body length */
        /* monkey must have a body of some length */
        if(monkeyBodyLength > 0){
            bodyLength = monkeyBodyLength;
        } else {
            bodyLength = 0.0;
        }
    }

    public Double getBodyLength(){
        /* Return the monkey body length */
        return bodyLength;
    }

    public void setTailLength(Double monkeyTail){
        /* monkey must have a tail of some length */
        if(monkeyTail > 0.0){
            tailLength = monkeyTail;
        } else {
            tailLength = 0.0;
        }
    }
    public Double getTailLength(){
        /* Return the monkey tail length */
        return tailLength;
    }
}
