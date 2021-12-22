package com.company;

import com.company.Entities.BehaviorEnum;
import com.company.Entities.Child;
import com.company.Entities.Item;
import com.company.Entities.Letter;
import com.company.Repository.ItemRepository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Program {
    public static ItemRepository itemRepository = new ItemRepository();

    public static void main(String[] args) throws ParseException, IOException {
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }

    static void Question1() throws ParseException {
        Item item1 = new Item("item1");
        itemRepository.create(item1);
        Item item2 = new Item("item2");
        itemRepository.create(item2);
        Item item3 = new Item("item3");
        itemRepository.create(item3);
        Item item4 = new Item("item4");
        itemRepository.create(item4);
        Item item5 = new Item("item5");
        itemRepository.create(item5);
        Item item6 = new Item("item6");
        itemRepository.create(item6);

        Letter letter1_1 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-1"), List.of(item1, item2));
        Letter letter1_2 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-11"), List.of(item3, item4));
        Letter letter1_3 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-15"), List.of(item5, item6));

        Child child1 = new Child("Ion Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2006-05-11"),
                "str.Somesului, nr. 2B, Cluj-Napoca, Romania", BehaviorEnum.GOOD, letter1_1);
        Child child2 = new Child("Maria Pop" , new SimpleDateFormat("yyyy-MM-dd").parse("2007-5-6"),
                "Cluj-Napoca, str.Somesului, nr. 2B", BehaviorEnum.GOOD, letter1_2);
        Child child3 = new Child("Giorgi Mihalache",  new SimpleDateFormat("yyyy-MM-dd").parse("2006-8-18"),
                "Floresti, str. Eroilor, nr. 123", BehaviorEnum.BAD, letter1_3);

        List<Child> children = new ArrayList<>(List.of(child1, child2, child3));

        System.out.println(children);

    }

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

    public static Child createObjectsFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String name = "";
        String address = "";
        String behavior = "";
        BehaviorEnum behaviorEnum = null;
        Letter letter = null;
        int contor = 0;
        while ((st = br.readLine()) != null) {
            contor++;
            if(contor==2){
                name = st.substring(st.indexOf("I am")+5);
            }
            if(contor==3){
                String years = st.substring(st.indexOf("I am")+5, st.indexOf(" years"));
                System.out.println(years); //TODO calculat cumva ziua de nastere - maybe daca dau in scrisoare anii exacti
                address = st.substring(st.indexOf("I live at")+10, st.indexOf(". I have"));
                behavior = st.substring(st.indexOf("I have been a very")+19, st.indexOf(" child this year"));
            }
            if(contor==5){
                String present1 = st.substring(0, st.indexOf(","));
                Item item1 = createOrGetItemFromRepository(present1);
                String present2 = st.substring(st.indexOf(",")+1);
                Item item2 = createOrGetItemFromRepository(present2);

                letter = new Letter(new Date(System.currentTimeMillis()), List.of(item1, item2));
                behaviorEnum = BehaviorEnum.valueOf(behavior);
            }
        }
        return new Child(name,new Date(System.currentTimeMillis()), address, behaviorEnum, letter);
    }

    static void Question2() throws IOException {
        List<Child> readChildren = new ArrayList<>();

        File file1 = new File("src/com/company/letter2_1.txt");
        readChildren.add(createObjectsFromFile(file1));
        File file2 = new File("src/com/company/letter2_2.txt");
        readChildren.add(createObjectsFromFile(file2));
        File file3 = new File("src/com/company/letter2_3.txt");
        readChildren.add(createObjectsFromFile(file3));

       readChildren.forEach(child -> System.out.println(child.getName()));


    }

    static void Question3()
    {

    }

    static void Question4()
    {

    }

    static void Question5()
    {

    }

    static void Question6()
    {

    }


}
