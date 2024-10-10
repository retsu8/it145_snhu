/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  5.4 Menu Loop and Monkey Intake
****************************/

import java.util.*;
import java.util.stream.*;
import java.time.*;
import java.text.*;
import java.lang.Double;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // Pattern list for date creation input
    private static String dateFormatPattern = "yyyy-MM-dd";

    // Country locals used to handle proper country coded
    private static Locale[] locales = Locale.getAvailableLocales();

    // List of countries possible to include
    private static Set<String> countrySet = new HashSet<>();

    // Instance variables (if needed)
    public static void main(String[] args) {
        // This is the main function for setting up needed attributes
        Scanner scnr = new Scanner(System.in);
        // Initialize dogs
        initializeDogList();
        // Initialize monkeys
        initializeMonkeyList();
        System.out.println("This is the main function");

        // Create a list of countries for the user to select from
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            // make sure the country has content from locales
            if (!country.isEmpty()) {
                countrySet.add(country);
            }
        }

        // Create user input to handle the menu
        String userInput = "";
        while(!userInput.equalsIgnoreCase("q")){
            // Show the menu and loop tell we get an answer
            displayMenu();
            userInput = scnr.nextLine().trim();
            switch (userInput){
                // Do the first input new dog
                case "1":
                    intakeNewDog(scnr);
                // Do the second input new monkey
                case "2":
                    intakeNewMonkey(scnr);
                // Show the reserved rescue animals
                case "3":
                    reserveAnimal(scnr);
                // Print the list of dogs
                case "4":
                    printAnimals("dog");
                // Print the list of monkeys
                case "5":
                    printAnimals("monkey");
                // print all the animals that are ready and not reserved
                case "6":
                    printAnimals();
                // Quite the application
                case "q":
                    System.out.println("Quiting applicaiton...");
                // Junk input get another one.
                default:
                    System.out.println("That input is not reconized, please try again.");
            }
        }

    }

    public static void displayMenu() {
        /* This method prints the menu options */
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    public static void initializeDogList() {
        /* Adds dogs to a list for testing */
        // Create the dogs via the constructor
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        // Add the dogs here
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    public static void initializeMonkeyList() {
        /* Adds monkeys to a list for testing */
        // Create the monkeys here with the contructor.
        Monkey monkey1 = new Monkey("Mankey", "Short Hair", "male", "1", "8.5", "05-12-2019", "Brazil", "intake", false, "United States", "22.3", 
    "11.1", "2.1", "Capuchin");
        Monkey monkey2 = new Monkey("Figles", "Howler", "female", "1.115", "9.2", "05-10-2019", "Uganda", "in service", false, "United States", "22.3", 
    "11.1", "2.1", "Capuchin");

        // Add in the monkeys
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }

    public static String getServiceCountry(String name, Scanner scanner){
        /* Get the animals country of service */
        String country;
        System.out.println("Which county is " + name + "  living in?");
        while (true){
            country = scanner.nextLine().trim();
            if (countrySet.contains(country)){
                return country;
            } 
            System.out.println("Input not reconized, please enter a country");
            System.out.println(countrySet.toString());
        }
    }

    public static Boolean getReserved(String name, Scanner scanner){
        /* get the reserved status of the animal */
        String reserved;
        System.out.println("Is " + name + " reserved?(yes/no)");
        while (true){
            // Get rather reserved and return boolean value.
            reserved = scanner.nextLine().trim();
            if (reserved.equalsIgnoreCase("yes")){
                return true;
            } else if (reserved.equalsIgnoreCase("no")){
                return false;
            } else {
                System.out.println("Input not reconized, enter only yes/no");
            }
        }
    }

    public static String getTrainingStatus(String name, Scanner scanner){
        /* Get the phase of training the animal is in */
        String phase;
        System.out.println("Which phase is " + name + " in?");
        System.out.println("Phase I, Phase II, Phase III, Phase IV, Phase V or Farm");
        while(true){
            // Check to make sure there is input
            phase = scanner.nextLine().trim();
            if (phase.length() > 0){
                return phase;
            } else {
                System.out.println("Please do enter a phase.");
            }
        }
    }

    public static String getAcquisitionLocation(String name, Scanner scanner){
        /* Get a country list and ask for animal countries obtained location */
        String country;
        System.out.println("Which county did " + name + " come from?");
        while (true){
            country = scanner.nextLine().trim();
            if (countrySet.contains(country)){
                return country;
            } else {
                System.out.println("Input not reconized, please enter a country");
                System.out.println(countrySet.toString());
            }
        }
    }

    public static String getWeight(String name, Scanner scanner){
        /* get the animals weight
        Also check to make sure they are not entering a random number */
        Double weight;
        System.out.println("How much does " + name + " weight?");
        while (true){
            try {
                // Get the next double
                weight = scanner.nextDouble();
                // Check to make sure its a sensable value
                if (weight > 0.0 && weight <= 250.0){
                    // clean the scanner head.
                    scanner.nextLine();
                    // Return a string of this value since we should not perform math without reslizing it on a static weight.
                    return String.valueOf(weight);
                } else if (weight <= 0.0 || weight > 250.0) {
                    System.out.println("Weight not within range of 0 - 250 pounds.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
        }
    }

    public static String getSpecies(String name, Scanner scanner){
        /* Get the species of the animal */
        System.out.println("Which species is " + name + "?");
        System.out.println("Please use Capuchin, Guenon, Macaque, Marmoset, Squirrel Monkey, Tamarin");
        String species = "";
        // Check to make sure the species if filled in correctly in accepted species.
        while(species.isEmpty()){
            // Get species and check if correct
            species = scanner.nextLine();

            // Check if an allowed species has been entered.
            if (monkey.getAcceptedSpecies().contains(species)){
                return species;
            } else {
                species = "";
                System.out.println("Species not reconized, re-enter the species.");
            }
        }
    }

    public static String getGender(String name, Scanner scanner){
        /* Get the gender of the animal and return it. */
        String gender;
        System.out.println("What gender is " + name + "? (Male/Female)");
        while (true){
            gender = scanner.nextLine();
            // Getting simple gender concept.
            if (gender.equalsIgnoreCase("Male")){
                return "Male";
            } else if (gender.equalsIgnoreCase("Female")){
                return "Female";
            } else {
                System.out.println("Input not reconized, enter only Male/Female");
                continue;
            }
        }
    }

    public static String getAge(String name, Scanner scanner){
        /* Get the animals age; set age max to 30 as it is gnerally higher than the lifespan of the rescue animals */
        int age;
        System.out.println("How old is " + name + "?");
        while (true){
            try {
                age = scanner.nextInt();
                if (age > 0 && age <= 30){
                    // Convert the age to a string and add it to dog, must be string as age will be generally used as string
                    // Clean scanner for new inputjava.beans.
                    scanner.nextLine();
                    return String.valueOf(age);
                } else {
                    System.out.println("Age not within range of 0 - 30 years; please enter an age in this range.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
        }
    }

    public static String getAcquisitionDate(String name, Scanner scanner){
        /* Getting todays date to make sure the day of arrival makes sense
            This is also set here so if the program is left running it wills till get the right tomorrow */
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        // Make sure the date is not to old to make sense
        calendar = Calendar.getInstance();
        // This should really be setup by the customer but using static for now until otherwise noted
        calendar.add(Calendar.YEAR, -30);
        Date longAgo = calendar.getTime();

        // Get the acquisitionDate
        System.out.println("When did " + name + " arrive? Date format YYYY-MM-DD");
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatPattern, Locale.ENGLISH); 
        Date date;
        while(true){
            try {
                // Build date formatter to handle datetime
                date = formatter.parse(scanner.nextLine().trim());
                System.out.println(date);
                // Check to make sure the date is reasonable
                if (date.before(tomorrow) && date.after(longAgo)){
                    return formatter.format(date);
                // This date is to after tomarrow, cant add a dog/monkey on a day that has yet to even come
                } else if (date.after(tomorrow)) {
                    System.out.println("Date needs to be before " + tomorrow);
                // Else the date is to old, dog/monkey really should not be in system any longer
                } else {
                    System.out.println("Date needs to be after " + longAgo);
                }
                continue;
            } catch (InputMismatchException | ParseException e){
                // Invalid date input, keeping input type mismatch to include propable cases.
                System.out.println("Input not a date, please try again");
                continue;
            }
        }
    }

    public static void intakeNewDog(Scanner scanner) {
        /* Form for the new dog method */
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        // Creat the new dog with name
        Dog dog = new Dog();

        // Leaving the name here as is since generally wont use numbers
        dog.setName(name);

        // Get the dog breed
        System.out.println("What breed is " + name + "?");
        dog.setBreed(scanner.nextLine());

        // Get the gender of the dog
        dog.setGender(getGender(name, scanner));

        // Get the dogs age
        dog.setAge(getAge(name, scanner));
        
        //Get the dogs weight
        dog.setWeight(getWeight(name, scanner));

        // Get the acqusiation date
        dog.setAcquisitionDate(getAcquisitionDate(name, scanner));

        // Get the acqusition location
        dog.setAcquisitionLocation(getAcquisitionLocation(name, scanner));

        // Get dog trained
        dog.setTrainingStatus(getTrainingStatus(name, scanner));

        // Set if dog reserved
        dog.setReserved(getReserved(name, scanner));

        // Get Country of service
        dog.setInServiceCountry(getServiceCountry(name, scanner));

        // Dog inputs are finished, adding to doggy list
        dogList.add(dog);

        System.out.println("\n\n\nApplication is now complete going to main menu");
    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkeys's name?");
        String name = scanner.nextLine();

        // Check if we already took in this monkey
        for(Monkey monkey: monkeyList) {
            if(monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Create a new monkey to intake
        Monkey monkey = new Monkey();
        monkey.setName(name);

        // Get the dog breed
        System.out.println("What breed is " + name + "?");
        monkey.setBreed(scanner.nextLine());

        // Get the monkeys gender
        monkey.setGender(getGender(name, scanner));

        // Get the monkeys age
        monkey.setAge(getAge(name, scanner));

        // Get monkey acquasition date
        monkey.setAcquisitionDate(getAcquisitionDate(name, scanner));

        // Get the acqusition location
        monkey.setAcquisitionLocation(getAcquisitionLocation(name, scanner));

        // Get the acqusition location
        monkey.setAcquisitionLocation(getAcquisitionLocation(name, scanner));

        // Get monkey trained
        monkey.setTrainingStatus(getTrainingStatus(name, scanner));

        // Set reserved information for monkey
        monkey.setReserved(getReserved(name, scanner));

        // Set the species of the monkey
        monkey.setSpecies(getSpecies(name, scanner));

        // Get the monkeys body length
        Double bodyLength;
        System.out.println("How long is " + name + " body?");
        while (true){
            try {
                bodyLength = scanner.nextDouble();
                // Check to make sure body length is reasonable
                if (bodyLength > 0.0 && bodyLength <= 50.0){
                    // Clean the scanner to handle the next variable
                    scanner.nextLine();
                    // Set as a string here so its not accidently mathed.
                    monkey.setBodyLength(String.valueOf(bodyLength));
                    break;
                } else if (bodyLength <= 0.0 || bodyLength > 50.0) {
                    System.out.println("Body Length not within range of 0 - 50 inches.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
        }

        // Get the monkeys height
        Double height;
        System.out.println("How tall is " + name + "?");
        while (true){
            try {
                height = scanner.nextDouble();
                // Making sure height is reasonable
                if (height > 0.0 && height <= 55.0){
                    // Clean the scanner to handle the next variable
                    scanner.nextLine();
                    // Returing string so not accidently mathed
                    monkey.setHeight(String.valueOf(height));
                    break;
                } else if (height <= 0.0 || height > 55.0) {
                    System.out.println("Height not within range of 0 - 55 inches.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
        }

        // Get the monkeys tailLength
        Double tailLength;
        System.out.println("How long is " + name + " tail in inches?");
        while (true){
            try {
                tailLength = scanner.nextDouble();
                // Set this variable in inches to make sense of tail length
                if (tailLength > 0.0 && tailLength <= 50.0){
                    // Clean the scanner to handle the next variable
                    scanner.nextLine();
                    // Set to string so not accidently mathed
                    monkey.setHeight(String.valueOf(tailLength));
                    break;
                } else if (tailLength <= 0.0 || tailLength > 50.0) {
                    System.out.println("Tail Length not within range of 0 - 55 inches.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
        }
        // Add the new monkey to the database
        monkeyList.add(monkey);
        System.out.println("\n\n\nApplication is now complete going to main menu");
    }

    public static void reserveDog(Scanner scanner){
        /* Reserve a monkey in the system */
        System.out.println("Which dog would you like to reserve?");
        for (int i = 0; i < dogList.size(); i++) {
            Dog dog = dogList.get(i);
            if(!dog.getReserved()) {
                // Print dogs to the list
                System.out.println("[" + i + "] Name: " + dog.getName());
            }
        }

        System.out.println("Please include the name or index number");
        while (true){
            try {
                // Select the dog from the index value
                int userInput = scanner.nextInt();
                Dog dog = dogList.get(userInput);
                // Setting the selected dog to reserved
                System.out.println("Setting " + dog.getName() + " to reserved.");
                dog.setReserved(true);

                // Clean the scanner
                scanner.nextLine();
                return;
            } catch (InputMismatchException e){
                String userInput = scanner.nextLine();
                for(Dog dog: dogList) {
                    // Find the dog named => userinput
                    if(dog.getName().equalsIgnoreCase(userInput)) {
                        // Set the dog to reserved
                        System.out.println("Setting " + dog.getName() + " to reserved.");
                        dog.setReserved(true);
                        return;
                    }
                }
            }
        }
    }
    public static void reserveMonkey(Scanner scanner){
        /* Reserve a monkey in the system */
        System.out.println("Which monkey would you like to reserve?");
        for (int i = 0; i < monkeyList.size(); i++) {
            Monkey monkey = monkeyList.get(i);
            if(!monkey.getReserved()) {
                // Print dogs to the list
                System.out.println("[" + i + "] Name: " + monkey.getName());
            }
        }
        System.out.println("Please include the name or index number");
        while (true){
            try {
                // Select the monkey from the index value
                int userInput = scanner.nextInt();
                Monkey monkey = monkeyList.get(userInput);
                System.out.println("Setting " + monkey.getName() + " to reserved.");
                monkey.setReserved(true);

                // Clean the scanner
                scanner.nextLine();
                return;
            } catch (InputMismatchException e){
                String userInput = scanner.nextLine();
                for(Monkey monkey: monkeyList) {
                    // Find the monkey named => userinput
                    if(monkey.getName().equalsIgnoreCase(userInput)) {
                        // Set the monkey to reserved
                        System.out.println("Setting " + monkey.getName() + " to reserved.");
                        monkey.setReserved(true);
                        return;
                    }
                }
            }
        }
    }
    public static void reserveAnimal(Scanner scanner) {
        /* You will need to find the animal by animal type and in service country*/
        // Get either a monkey or dog to process.
        String animalType = "";
        while(animalType.isEmpty()){
            // Get the animal type and send to switch
            System.out.println("Would you like to reserve a monkey or a dog?");
            animalType = scanner.nextLine();
            if (animalType.equalsIgnoreCase("dog")){
                animalType = "dog";
            } else if (animalType.equalsIgnoreCase("monkey")) {
                animalType = "monkey";
            } else {
                animalType = "";
            }
        }

        // Switch to the animal to check out.
        switch (animalType){
            case "dog":
                reserveDog(scanner)
                break;
            case "monkey":
                reserveMonkey(scanner); 
                break;
        }
    }

    public static void printAnimals() {
        /* This function prints a list of animals that are in service but not reserved */
        // Build a list of monkeys that are in service but not reserved.
        ArrayList<Monkey> reservedMonkeys = monkeyList.stream()
              .filter(monkey -> !monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service"))
              .collect(Collectors
                            .toCollection(ArrayList::new));

        // Build a list of dogs that are in service but not reserved
        ArrayList<Dog> reservedDogs = dogList.stream()
              .filter(dog -> !dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service"))
              .collect(Collectors
                            .toCollection(ArrayList::new));
        
        // Reservable monkey list
        System.out.println("\nThese monkeys are reservable.");
        for(Monkey monkey: reservedMonkeys ){
            System.out.println(monkey.toString());
        }

        // Reserable dog list
        System.out.println("\nThese dogs are reservable.");
        for(Dog dog: reservedDogs ){
            System.out.println(dog.toString());
        }


    }
    public static void printAnimals(String animal) {
        /* This function prints a a list of selected animals in the system implenting 
           Both as this funtion was used to contruct the reserve function */
        switch (animal) {
            case "dog":
                // Print the list of dogs that are in the system
                for(Dog dog: dogList ){
                    System.out.println(dog.toString());
                }
                break;
            case "monkey":
                // Print the list of monkeys that are in the system
                for(Monkey monkey: monkeyList){
                    System.out.println(monkey.toString());
                }
                break;
            default:
                // Create a default in case its ever needed.
                System.out.println("We have no idea how you managed to get here ?");
            }

    }
}

