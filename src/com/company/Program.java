package com.company;

import com.company.Entities.*;
import com.company.Repository.ItemRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Program {
    public static ItemRepository itemRepository = new ItemRepository();
    public static List<Child> childrenQ1;
    private static int count = 0;   //used for generating unique names for the letters
    private static final SantaClaus santaClaus = new SantaClaus();

    public static void main(String[] args){
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }

    /**
     * building a sample data structure by instantiating the classes previously created and
     * displaying it on the console
     */
    static void Question1(){
        Item item1 = new Item("item1");
        itemRepository.create(item1);
        Item item2 = new Item("item2");
        itemRepository.create(item2);
        Item item3 = new Item("item3");
        itemRepository.create(item3);
        Item item4 = new Item("item4");
        itemRepository.create(item4);

        try {
            Letter letter1_1 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-1"), List.of(item1, item2));
            Letter letter1_2 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-11"), List.of(item3, item2));
            Letter letter1_3 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-15"), List.of(item4, item2));

            Child child1 = new Child("Ion Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2006-05-11"),
                    "str.Somesului, nr. 2B, Cluj-Napoca, Cluj, Romania", BehaviorEnum.GOOD, letter1_1);
            Child child2 = new Child("Maria Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2007-5-6"),
                    "str.Somesului, nr. 2B, Cluj-Napoca, Cluj, Romania", BehaviorEnum.GOOD, letter1_2);
            Child child3 = new Child("Giorgi Mihalache", new SimpleDateFormat("yyyy-MM-dd").parse("2006-8-18"),
                    "str. Eroilor, nr. 123, Floresti, Cluj, Romania", BehaviorEnum.BAD, letter1_3);

            childrenQ1 = new ArrayList<>(List.of(child1, child2, child3));

            System.out.println("Question1:");
            System.out.println(childrenQ1);
        }
        catch (ParseException e) {
            System.out.println("Error occurred while parsing");
            e.printStackTrace();
        }

    }

    /**
     * creating an object structure based on the information in the files letter2_1, letter2_2, letter2_3
     */
    static void Question2(){
        List<Child> readChildren = new ArrayList<>();

        try {
            File file1 = new File("src/com/company/letter2_1.txt");
            readChildren.add(createObjectsFromFile(file1));
            File file2 = new File("src/com/company/letter2_2.txt");
            readChildren.add(createObjectsFromFile(file2));
            File file3 = new File("src/com/company/letter2_3.txt");
            readChildren.add(createObjectsFromFile(file3));

            System.out.println("Question2:");
            readChildren.forEach(child -> System.out.println(child.getName()));
        }
        catch (IOException e) {
            System.out.println("Error occurred while working with the file");
            e.printStackTrace();
        }
        catch (ParseException e) {
            System.out.println("Error occurred while parsing");
            e.printStackTrace();
        }
    }

    /**
     * generating letter files following the letter template for each child in the data structure created at Question1
     * but taking into account the information stored on each child
     */
    static void Question3()
    {
        System.out.println("Question3:");
        for(Child child :childrenQ1){
            createLetterFile(child);
        }
    }

    /**
     * builds a report for the Toy Factory, highlight how many of each toy the elves need to build
     * the report is ordered descending by quantity
     */
    static void Question4(){

        Report report = new Report();
        try{
            File file1 = new File("src/com/company/letter2_1.txt");
            File file2 = new File("src/com/company/letter2_2.txt");
            File file3 = new File("src/com/company/letter2_3.txt");
            File file4 = new File("src/com/company/letter3_1.txt");
            File file5 = new File("src/com/company/letter3_2.txt");
            File file6 = new File("src/com/company/letter3_3.txt");
            buildReport(report,file1);
            buildReport(report,file2);
            buildReport(report,file3);
            buildReport(report,file4);
            buildReport(report,file5);
            buildReport(report,file6);

            System.out.println("Question4:");
            System.out.println(report);
        }
        catch (IOException e) {
            System.out.println("Error occurred while working with the file");
            e.printStackTrace();
        }

    }

    /**
     * explaining why we can apply Singleton Pattern in the current implementation
     */
    static void Question5()
    {
        /*
        In the current implementation we can apply Singleton Pattern to SantaClause class, because we only need one
        Santa for the whole lifetime of the application, with his one list of children from all over the world.
        In this implementation multithreading is not used, so we will not have the complications of singleton in a multithread
        environment (we don't need to take care of multithreading creating singleton object several times)
         */
    }


    /**
     * building Santa's travel itinerary, a list of all addresses, for every child in Santa's list,
     * so that every address appears only once, and the addresses are grouped by the city - taking in consideration
     * the county and country
     */
    static void Question6()
    {
        List<String> travelItinerary = new ArrayList<>();
        for(Child child: santaClaus.getChildren()){
            String address = child.getAddress();
            travelItinerary.add(address);
        }
        List<String> travelItinerarySorted = travelItinerary.stream()
                .distinct()                     //grouping by the city
                .collect(groupingBy(elem -> elem.substring(elem.indexOf(", ", elem.indexOf(", ")+2)+2),LinkedHashMap::new, toList()))
                .values().stream()
                .flatMap(Collection::stream)
                .collect(toList());

        System.out.println("Question6:");
        System.out.println(travelItinerarySorted);

    }

    /**
     * checks if an item with the given name is already in the item repository, or it creates it and adds it to the repository
     * @param presentName the name to be searched in the item repository
     * @return the already existing or the newly created Item object, depending on the situation
     */
    public static Item createOrGetItemFromRepository(String presentName){
        if(itemRepository.getAll().stream()
                .noneMatch(item -> Objects.equals(item.getName(), presentName))){
            Item item = new Item(presentName);
            itemRepository.create(item);
            return item;
        }
        else{
            return itemRepository.getAll().stream()
                    .filter(item -> Objects.equals(item.getName(), presentName))
                    .findFirst()
                    .orElseThrow();
        }
    }

    /**
     * From the information in a file with the structure of letter-template.txt,
     * it creates a Child object, with the help of Santa's children list - for the child exact birthday
     * The creation date of the letter file will be considered to be the date for the Letter object
     * @param file the file from which we read the information
     * @return the created child
     * @throws IOException if errors occurred while reading from the file
     * @throws ParseException if the date can not be successfully parsed
     */
    public static Child createObjectsFromFile(File file) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        //get the letter creation date
        BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        FileTime time = attrs.creationTime();

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String letterDateString = simpleDateFormat.format( new Date( time.toMillis()));
        Date letterDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(letterDateString);

        String st;
        String name = "";
        Date exactBirthDate = null;
        String address = "";
        String behavior = "";
        BehaviorEnum behaviorEnum = null;
        Letter letter = null;

        int contor = 0;
        while ((st = br.readLine()) != null) {   //for every line in the file we extract the needed information
            contor++;
            if(contor==2){
                name = st.substring(st.indexOf("I am")+5);
            }
            if(contor==3){
                String years = st.substring(st.indexOf("I am")+5, st.indexOf(" years"));
                address = st.substring(st.indexOf("I live at")+10, st.indexOf(". I have"));

                //find the exact birthday of the child, identified through name and address in santas list
                String finalName = name;
                String finalAddress = address;
                exactBirthDate = santaClaus.getChildren().stream()
                        .filter(elem -> Objects.equals(elem.getName(), finalName) && Objects.equals(elem.getAddress(), finalAddress))
                        .findFirst()
                        .orElseThrow().getDateOfBirth();

                behavior = st.substring(st.indexOf("I have been a very")+19, st.indexOf(" child this year"));
            }
            if(contor==5){
                String present1 = st.substring(0, st.indexOf(","));
                Item item1 = createOrGetItemFromRepository(present1);
                String present2 = st.substring(st.indexOf(",")+1);
                Item item2 = createOrGetItemFromRepository(present2);

                letter = new Letter(letterDate, List.of(item1, item2));
                behaviorEnum = BehaviorEnum.valueOf(behavior);
            }
        }
        return new Child(name,exactBirthDate, address, behaviorEnum, letter);
    }

    /**
     * creating a file with a unique name for a child, taking in consideration all information given
     * - name, date of birth (from which we deduce the age), address, behaviour, and list of desired items
     * @param child the child object for which we create the letter
     */
    public static void createLetterFile(Child child){
        try {
            count++;
            File myObj = new File("src/com/company/letter3_"+ count+".txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

                Period period = Period.between(child.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
                int age = period.getYears();

                FileWriter myWriter = new FileWriter("src/com/company/letter3_"+ count+".txt");
                myWriter.write("Dear Santa,\n" +
                        "I am "+ child.getName() +" \n" +
                        "I am " + age + " years old. I live at " + child.getAddress() + ". I have been a very " + child.getBehaviorEnum() + " child this year\n" +
                        "What I would like the most this Christmas is:\n" +
                        child.getLetter().getItemList().get(0).getName()+ "," + child.getLetter().getItemList().get(1).getName());
                myWriter.close();

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while using the files");
            e.printStackTrace();
        }
    }

    /**
     * Based on a letter file, which has the structure of letter-template.txt,
     * it retrieves the information about the desired items and creates (or retrieves) the corresponding item
     * in the item Repository, and then adds it to the report
     * @see Report#addItem(Item)
     * @param report the report in which we add the information from the file
     * @param file the file from which we retrieve the name of the items
     * @throws IOException if errors occurred while reading form file
     */
    static void buildReport(Report report, File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int contor = 0;
        while ((st = br.readLine()) != null) {
            contor++;
            if (contor == 5) {
                String present1 = st.substring(0, st.indexOf(","));
                Item item1 = createOrGetItemFromRepository(present1);
                String present2 = st.substring(st.indexOf(",") + 1);
                Item item2 = createOrGetItemFromRepository(present2);
                report.addItem(item1);
                report.addItem(item2);
            }
        }

    }


}
