package com.company.Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents senta claus, who has a list of all the children in the world (with name, birthday and address)
 */
public class SantaClaus {
    private String name;
    private List<Child> children;

    public SantaClaus() {
        this.name = "Santa Claus";
        this.children =new ArrayList<>();
        readChildren();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Reads all children from Santa's children file, and adds them to his list
     * Every child will have his name, birthdate and address saved
     */
    public void readChildren(){
        try {
            List<String> childrenLines = Files.readAllLines(java.nio.file.Paths.get("src/com/company/children.txt"), StandardCharsets.UTF_8);

            for (String line : childrenLines) {
                String[] tokens = line.split(";");

                String name = tokens[0];
                String birthDateString = tokens[1];
                Date birthDate=new SimpleDateFormat("yyyy-MM-dd").parse(birthDateString);
                String address = tokens[2];
                Child child = new Child(name, birthDate, address);
                children.add(child);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * if a new child is born and Santa needs to add him to his children list
     * @param newChild the newborn child
     */
    public void addChild(Child newChild){
        if(children.stream()
                .noneMatch(child -> Objects.equals(child.getName(), newChild.getName()) &&
                        child.getDateOfBirth()==newChild.getDateOfBirth() &&
                        Objects.equals(child.getAddress(), newChild.getAddress()))){
            children.add(newChild);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/company/children.txt"));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                bw.write(newChild.getName() + ";" + dateFormat.format(newChild.getDateOfBirth()) + ";" + newChild.getAddress());
                bw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
