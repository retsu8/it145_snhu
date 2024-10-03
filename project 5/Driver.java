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
    private static String dateFormatPattern = "yyyy-MM-dd";
    private static Locale[] locales = Locale.getAvailableLocales();
    private static Set<String> countrySet = new java.util.HashSet<>();

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


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Mankey", "Short Hair", "male", "1", "8.5", "05-12-2019", "Brazil", "intake", false, "United States", "22.3", 
    "11.1", "2.1", "Capuchin");

        monkeyList.add(monkey1);
    }

    // Complete the intakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
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

/*        // Get the dog breed
        System.out.println("What breed is " + name + "?");
        dog.setBreed(scanner.nextLine());

        // Get the gender of the dog
        String gender;
        System.out.println("What gender is " + name + "? (Male/Female)");
        while (true){
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Male")){
                dog.setGender("Male");
            } else if (gender.equalsIgnoreCase("Female")){
                dog.setGender("Female");
            } else {
                System.out.println("Input not reconized, enter only Male/Female");
                continue;
            }
            break;
        }

        // Get the dogs age
        int age;
        System.out.println("What age is " + name + "?");
        while (true){
            try {
                age = scanner.nextInt();
                if (age > 0 && age <= 30){
                    // Convert the age to a string and add it to dog, must be string as age should not be mathamaticly used.
                    dog.setAge(String.valueOf(age));
                } else if (age <= 0 || age > 30) {
                    System.out.println("Age not within range of 0 - 30 years; please enter an age in this range.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
            scanner.nextLine();
            break;
        }
        
        //Get the dogs weight
        Double weight;
        System.out.println("How much does " + name + " weight?");
        while (true){
            try {
                weight = scanner.nextDouble();
                if (weight > 0.0 && weight <= 250.0){
                    dog.setWeight(String.valueOf(weight));
                } else if (weight <= 0.0 || weight > 250.0) {
                    System.out.println("Weight not within range of 0 - 250 pounds.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Input not reconized, enter a number");
                continue;
            }
            scanner.nextLine();
            break;
        }


        // Getting todays date to make sure the day of arrival makes sense
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        // Get the acquisitionDate
        System.out.println("When did " + name + " arrive? Date format YYYY-MM-DD");
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatPattern, Locale.ENGLISH); 
        Date date;
        while(true){
            try {
                date = formatter.parse(scanner.nextLine().trim());
                System.out.println(date);
                if (date.compareTo(tomorrow) > 0){
                    dog.setAcquisitionDate(formatter.format(date));
                } else if (date.compareTo(tomorrow) < 0) {
                    System.out.println("Date is in the future?");
                    continue;
                }
            } catch (InputMismatchException | ParseException e){
                System.out.println("Input not a date, please try again");
                continue;
            }
            break;
        }*/

        // Get the acqusition location
        String country;
        System.out.println("Which county did " + name + " come from?");
        while (true){
            country = scanner.nextLine().trim();
            if (countrySet.contains(country)){
                dog.setAcquisitionLocation(country);
            } else {
                System.out.println("Input not reconized, please enter a country");
                System.out.println(countrySet.toString());
                continue;
            }
            break;
        }

        // Get the trainingStatus
        String trained;
        System.out.println("Has " + name + "  been trained? (yes/no)");
        while (true){
            trained = scanner.nextLine().trim();
            if (trained.equalsIgnoreCase("yes")){
                dog.setTrainingStatus("yes");
            } else if (trained.equalsIgnoreCase("no")){
                dog.setTrainingStatus("no");
            } else {
                System.out.println("Input not reconized, enter only yes/no");
                continue;
            }
            break;
        }

        // Get the if reserved
        String reserved;
        System.out.println("Is " + name + "  reserved?(yes/no)");
        while (true){
            reserved = scanner.nextLine().trim();
            if (trained.equalsIgnoreCase("yes")){
                dog.setReserved(true);
            } else if (trained.equalsIgnoreCase("no")){
                dog.setReserved(false);
            } else {
                System.out.println("Input not reconized, enter only yes/no");
                continue;
            }
            break;
        }

        // Get Country of service
        System.out.println("Which county is " + name + "  living in?");
        while (true){
            country = scanner.nextLine().trim();
            if (countrySet.contains(country)){
                dog.setInServiceCountry(country);
            } else {
                System.out.println("Input not reconized, please enter a country");
                System.out.println(countrySet.toString());
                continue;
            }
            break;
        }
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

