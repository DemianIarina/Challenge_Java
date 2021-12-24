package com.company.Entities;

import java.util.*;

/**
 * Represents a report for the Toy Factory, containing in decending order by quantity
 * the item to be built and the quantity (represented in ReportRow)
 */
public class Report {
    private final List<ReportRow> reportList;

    public Report() {
        this.reportList = new ArrayList<>();
    }

    /**
     * Adds an item to the end of the report list, if it doesn't already exist there
     * if the item already exists in the report, it will increase the quantity, and insert the object at the right position
     * @param item the item to be added to the report
     */
    public void addItem(Item item){
        ReportRow reportRow = reportList.stream()
                .filter(elem -> Objects.equals(elem.getToyName(), item.getName()))
                .findFirst()
                .orElse(null);

        if(reportRow!=null){
            int currentQuantity = reportRow.getQuantity()+1;
            reportList.remove(reportRow);                    //remove the element from the old position
            reportRow = new ReportRow(item.getName());
            reportRow.setQuantity(currentQuantity);
            int index = Collections.binarySearch(reportList, reportRow, Comparator.comparing(ReportRow::getQuantity, Comparator.reverseOrder()));
            if (index < 0) {
                index = -index - 1;
            }
            reportList.add(index, reportRow);     //add the element to the new position
        }
        else{
            reportRow = new ReportRow(item.getName());
            reportList.add(reportRow);
        }
    }

    @Override
    public String toString() {
        return "Report{" + reportList +
                '}';
    }
}
