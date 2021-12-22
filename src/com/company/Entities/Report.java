package com.company.Entities;

import java.util.*;

public class Report {
    private List<ReportRow> reportList;

    public Report() {
        this.reportList = new ArrayList<>();
    }

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
            int index = Collections.binarySearch(reportList, reportRow, Comparator.comparing(ReportRow::getQuantity, Comparator.reverseOrder()));
            if (index < 0) {
                index = -index - 1;
            }
            reportList.add(index, reportRow);
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportList=" + reportList +
                '}';
    }
}
