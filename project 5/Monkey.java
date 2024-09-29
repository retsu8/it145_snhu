/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  5.4 Menu Loop and Monkey Intake
****************************/

public class Monkey extends RescueAnimal {

    // Instance variable
    private String breed;
    private String height;
    private String bodyLength;
    private String species;
    private Double tailLength;
    private static ArrayList<Species> speciesList = new ArrayList<Species>(
        "capuchin","guenon","macaque","marmoset","squirrel monkey","tamarin"
    );

    // Constructor
    public Monkey(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, Double tailLength, 
    String height, String bodyLength, String species) {
        setName(name);
        setBreed(breed);
        setSpecies(species)
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

    public void setSpecies(species){
        /* Check the species list for monkeys*/
        if(speciesList.contains(species.toLowerCase())){
            species = species;
        } else {
            species = "";
        }
    }

    public String getSpecies(){
        /* Return the species list for monkeys */
        return species;
    }
}
