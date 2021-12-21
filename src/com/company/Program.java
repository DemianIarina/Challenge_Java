package com.company;

import com.company.Entities.BehaviorEnum;
import com.company.Entities.Child;
import com.company.Entities.Item;
import com.company.Entities.Letter;
import com.company.Repository.ItemRepository;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Program {
    public static ItemRepository itemRepository = new ItemRepository();

    public static void main(String[] args) throws ParseException {
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }

    static void Question1() throws ParseException {
        Item item1 = new Item("Item1");
        itemRepository.create(item1);
        Item item2 = new Item("Item2");
        itemRepository.create(item2);
        Item item3 = new Item("Item3");
        itemRepository.create(item3);
        Item item4 = new Item("Item4");
        itemRepository.create(item4);
        Item item5 = new Item("Item5");
        itemRepository.create(item5);
        Item item6 = new Item("Item6");
        itemRepository.create(item6);

        Letter letter1_1 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-1"), List.of(item1, item2));
        Letter letter1_2 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-11"), List.of(item3, item4));
        Letter letter1_3 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-15"), List.of(item5, item6));

        Child child1 = new Child("Ion", "Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2006-05-11"),
                "str.Somesului, nr. 2B, Cluj-Napoca, Romania", BehaviorEnum.GOOD, letter1_1);
        Child child2 = new Child("Maria", "Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2007-5-6"),
                "Cluj-Napoca, str.Somesului, nr. 2B", BehaviorEnum.GOOD, letter1_2);
        Child child3 = new Child("Giorgi", "Mihalache",  new SimpleDateFormat("yyyy-MM-dd").parse("2006-8-18"),
                "Floresti, str. Eroilor, nr. 123", BehaviorEnum.BAD, letter1_3);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    static void Question2()
    {
        Item item7 = new Item("Item6");
        itemRepository.create(item7);
        System.out.println(itemRepository.getAll());
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
