/***************************
*  @Author William Paddock
*  @Version; .01
*  IT 145
*  5.4 Menu Loop and Monkey Intake
****************************/

import java.util.*;
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
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        initializeDogList();
        initializeMonkeyList();
        System.out.println("This is the main function");

        // Create a list of countries for the user to select from
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (!country.isEmpty()) {
                countrySet.add(country);
            }
        }

        while(!userInput.equalsIgnoreCase("q")){
                displayMenu();
                userInput = scnr.nextLine();
                System.out.println(userInput);
                if (userInput.equalsIgnoreCase("1")){
                    intakeNewDog(scnr);
                } else if (userInput.equalsIgnoreCase("2")){
                    intakeNewMonkey(scnr);
                } else if (userInput.equalsIgnoreCase("3")){
                    System.out.println("Reserve me!");
                } else if (userInput.equalsIgnoreCase("4")){
                    printAnimals("dog");
                } else if (userInput.equalsIgnoreCase("5")){
                    printAnimals("monkey");
                } else if (userInput.equalsIgnoreCase("6")){
                    printAnimals();
                } else {
                    System.out.println("That input is not reconized, please try again.");
                }
            }

    }

    // This method prints the menu options
    public static void displayMenu() {
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
        // Adds dogs to a list for testing
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    public static void initializeMonkeyList() {
        // Adds monkeys to a list for testing
        Monkey monkey1 = new Monkey("Mankey", "Short Hair", "male", "1", "8.5", "05-12-2019", "Brazil", "intake", false, "United States", "22.3", 
    "11.1", "2.1", "Capuchin");

        monkeyList.add(monkey1);
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
        Also check to make sure they are not overweight */
        Double weight;
        System.out.println("How much does " + name + " weight?");
        while (true){
            try {
                weight = scanner.nextDouble();
                if (weight > 0.0 && weight <= 250.0){
                    scanner.nextLine();
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

    public static String getGender(String name, Scanner scanner){
        /* Get the gender of the animal and return it. */
        String gender;
        System.out.println("What gender is " + name + "? (Male/Female)");
        while (true){
            gender = scanner.nextLine();
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
                    // Convert the age to a string and add it to dog, must be string as age should not be mathamaticly used.
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
        calendar.add(Calendar.YEAR, -30);
        Date longAgo = calendar.getTime();

        // Get the acquisitionDate
        System.out.println("When did " + name + " arrive? Date format YYYY-MM-DD");
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatPattern, Locale.ENGLISH); 
        Date date;
        while(true){
            try {
                date = formatter.parse(scanner.nextLine().trim());
                System.out.println(date);
                if (date.before(tomorrow) && date.after(longAgo)){
                    return formatter.format(date);
                } else if (date.after(tomorrow)) {
                    System.out.println("Date needs to be before " + tomorrow);
                } else {
                    System.out.println("Date needs to be after " + longAgo);
                }
                continue;
            } catch (InputMismatchException | ParseException e){
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
        System.out.println("What phase is " + name + "  in training?");
        dog.setTrainingStatus(scanner.nextLine());

        // Set if dog reserved
        dog.setReserved(getReserved(name, scanner));

        // Get Country of service
        dog.setInServiceCountry(getServiceCountry(name, scanner));

        // Dog inputs are finished, adding to doggy list
        dogList.add(dog);

        // FIX remove this on finish
        System.out.println(dog.toString());
        System.out.println("\n\n\nApplication is now complete going to main menu");
    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkeys's name?");
        String name = scanner.nextLine();
        for(Monkey monkey: monkeyList) {
            if(monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }
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
        System.out.println("What phase is " + name + " in training?");
        monkey.setTrainingStatus(scanner.nextLine());

        // Set if dog reserved
        monkey.setReserved(getReserved(name, scanner));

        System.out.println("What species is " + name + "?");
        System.out.println("Please use Capuchin, Guenon, Macaque, Marmoset, Squirrel Monkey, Tamarin");
        String species = "";
        while(species.isEmpty()){
            species = scanner.nextLine();
            monkey.setSpecies(species);
            species = monkey.getSpecies();
            if (species.isEmpty()){
                System.out.println("Incorrect species, reinter the species.");
            }
        }

        // Get the monkeys body length
        Double bodyLength;
        System.out.println("How long is " + name + " body?");
        while (true){
            try {
                bodyLength = scanner.nextDouble();
                if (bodyLength > 0.0 && bodyLength <= 50.0){
                    // Clean the scanner to handle the next variable
                    scanner.nextLine();
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
                if (height > 0.0 && height <= 55.0){
                    // Clean the scanner to handle the next variable
                    scanner.nextLine();
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
        System.out.println("How long is " + name + " tail?");
        while (true){
            try {
                tailLength = scanner.nextDouble();
                if (tailLength > 0.0 && tailLength <= 50.0){
                    // Clean the scanner to handle the next variable
                    scanner.nextLine();
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

        // FIX remove this on finish
        System.out.println(monkey);
        System.out.println("\n\n\nApplication is now complete going to main menu");
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("The method reserveAnimal needs to be implemented");
    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals() {
        System.out.println("The method printAnimals needs to be implemented");

    }
    public static void printAnimals(String animal) {
        System.out.println("The method printAnimals needs to be implemented; animals");

    }
}

