package org.redquark.practice.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * You have been hired as TA of Python, 101. Students have turned in their first assignments,
 * but unfortunately there has been a lot of plagiarism.
 * <p>
 * Your college provides a service that runs against all assignments and gives you pairs of
 * assignments that appear to have been copied.
 * <p>
 * Your job as TA, is to identify groups of people who copied from each other or from the same
 * source and call them for questioning:
 * <p>
 * Input
 * Any number of lines having pairs of input representing roll number of the student who copied
 * from the next student. For eg.
 * 305641, 305581
 * 305641, 305051
 * 305051, 305581
 * 305051, 305021
 * 305021, 305051
 * 306532, 305111
 * 306532, 205121
 * 305641, 205874
 * 305532, 305182
 * <p>
 * Output:
 * 205121, 305111, 306532
 * 205874, 305021, 305051, 305581, 305641
 * 305182, 305532
 * <p>
 * Note: The group of students who cheated should have roll numbers in sorted order as shown above.
 * <p>
 * Explanation:
 * <p>
 * Find minimum roll number in the list (since we want to go in ascending order): 205121
 * See who copied from this student or whom this student copied from : 205121 was copied by 306532 and 305632 copied from 305111. This sequence ends here since 305111 did not copy from anyone.
 * Therefore, take those three roll numbers in ascending order and add them to answer. Hence the first row 205121, 305111, 306532
 * Similarly, go to the next roll number in the remaining list i.e. 205874 and do 2nd step onwards ..
 */
public class CheatersOfTheClass {

    private static List<List<Integer>> findCheaters(int[][] report) {
        // List to store the cheaters
        List<List<Integer>> cheaters = new ArrayList<>();
        // Special case, if everyone was honest
        if (report == null || report.length == 0) {
            return cheaters;
        }
        // Map to store the parent-child relationship
        Map<Integer, Integer> parents = new HashMap<>();
        // Map to store group mapping
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        // Populate the parents map
        for (int[] rollNumbers : report) {
            parents.putIfAbsent(rollNumbers[0], rollNumbers[1]);
            parents.putIfAbsent(rollNumbers[1], rollNumbers[1]);
        }
        // Find the correct parent
        for (int[] rollNumbers : report) {
            int parent = getParent(parents, rollNumbers[0]);
            int child = getParent(parents, rollNumbers[1]);
            parents.put(parent, child);
        }
        // Finding the right group
        for (int[] rollNumbers : report) {
            int parent = getParent(parents, rollNumbers[1]);
            groups.putIfAbsent(parent, new TreeSet<>());
            groups.get(parent).add(rollNumbers[0]);
            groups.get(parent).add(rollNumbers[1]);
        }
        // Preparing the result
        for (Map.Entry<Integer, Set<Integer>> entry : groups.entrySet()) {
            List<Integer> group = new ArrayList<>(entry.getValue());
            cheaters.add(group);
        }
        // Sort the result
        cheaters.sort(Comparator.comparing(a -> a.get(0)));
        return cheaters;
    }

    private static int getParent(Map<Integer, Integer> parents, int child) {
        while (parents.get(child) != child) {
            child = parents.get(child);
        }
        return child;
    }

    public static void main(String[] args) {
        int[][] report = {
                {305641, 305581},
                {305641, 305051},
                {305051, 305581},
                {305051, 305021},
                {305021, 305051},
                {306532, 305111},
                {306532, 205121},
                {305641, 205874},
                {305532, 305182}
        };
        List<List<Integer>> cheaters = findCheaters(report);
        for (List<Integer> group : cheaters) {
            for (Integer rollNumber : group) {
                System.out.print(rollNumber + " ");
            }
            System.out.println();
        }
    }
}
