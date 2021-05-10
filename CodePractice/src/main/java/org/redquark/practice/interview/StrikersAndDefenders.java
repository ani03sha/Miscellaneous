package org.redquark.practice.interview;

import java.util.ArrayList;
import java.util.List;

public class StrikersAndDefenders {

    private static String findEligiblePlayers(String[] records) {
        int strikerMinimumScore = 50;
        int defenderMinimumScore = 30;
        int strikerCount = 0;
        int defenderCount = 0;
        List<String> verdictList = new ArrayList<>();
        // Loop for every record
        for (String record : records) {
            String[] parameters = record.split(" ");
            // Check eligibility
            if (Integer.parseInt(parameters[3]) >= strikerMinimumScore) {
                strikerCount++;
                verdictList.add(parameters[0] + " SELECT STRIKER");
            } else if (Integer.parseInt(parameters[4]) >= defenderMinimumScore) {
                defenderCount++;
                verdictList.add(parameters[0] + " SELECT DEFENDER");
            } else {
                verdictList.add(parameters[0] + " REJECT NA");
            }
        }
        // Selected candidate count
        int selectCount = 2 * Math.min(strikerCount, defenderCount);
        for (int i = 0; i < verdictList.size(); i++) {
            String verdict = verdictList.get(i);
            if (selectCount > 0 && (verdict.contains("STRIKER") || verdict.contains("DEFENDER"))) {
                selectCount--;
            } else {
                verdict = verdict.replace("SELECT", "REJECT");
                verdict = verdict.replace("STRIKER", "NA");
                verdict = verdict.replace("DEFENDER", "NA");
                verdictList.set(i, verdict);
            }
        }
        return String.join("\n", verdictList);
    }

    public static void main(String[] args) {
        String[] records = new String[]{
                "Boateng 6.1 22 24 45",
                "Kaka 6 22 1 1",
                "Ramos 6.3 22 67 70",
                "Ronaldo 5.8 21 120 0",
                "Suarez 5.9 20 100 1"
        };
        System.out.println(findEligiblePlayers(records));
    }
}
