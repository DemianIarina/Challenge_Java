package com.company;

import com.company.Entities.BehaviorEnum;
import com.company.Entities.Child;
import com.company.Entities.Item;
import com.company.Entities.Letter;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) throws ParseException {
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }

    static void Question1() throws ParseException {
        Item item1 = new Item(101, "Item1");
        Item item2 = new Item(102, "Item2");
        Item item3 = new Item(103, "Item3");
        Item item4 = new Item(104, "Item4");
        Item item5 = new Item(105, "Item5");
        Item item6 = new Item(106, "Item6");

        Letter letter1 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-1"), List.of(item1, item2));
        Letter letter2 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-11"), List.of(item3, item4));
        Letter letter3 = new Letter(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-15"), List.of(item5, item6));

        Child child1 = new Child("Ion", "Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2006-05-11"),
                "Cluj-Napoca, str.Somesului, nr. 2B", BehaviorEnum.GOOD, letter1);
        Child child2 = new Child("Maria", "Pop", new SimpleDateFormat("yyyy-MM-dd").parse("2007-5-6"),
                "Cluj-Napoca, str.Somesului, nr. 2B", BehaviorEnum.GOOD, letter2);
        Child child3 = new Child("Giorgi", "Mihalache",  new SimpleDateFormat("yyyy-MM-dd").parse("2006-8-18"),
                "Floresti, str. Eroilor, nr. 123", BehaviorEnum.BAD, letter3);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    static void Question2()
    {

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
