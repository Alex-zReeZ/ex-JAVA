package ch.jobtrek;

import java.sql.SQLData;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;


public class Collections {

    /**
     * @param array An array that contains strings of different lengths
     * @param size  The string size used to chunk the array
     * @return An array containing two arrays, one with the stings below and equal
     * of the size, and another with the stings longer than the size
     */
    public static List<List<String>> chunkArrayByStringSize(List<String> array, int size) {
        List<String> smallerOrEqual = new ArrayList<>();
        List<String> larger = new ArrayList<>();

        for (String str : array) {
            if (str.length() <= size) {
                smallerOrEqual.add(str);
            } else {
                larger.add(str);
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.add(smallerOrEqual);
        result.add(larger);

        return result;
    }

    public static void main(String[] args) {
        List<String> input = List.of("apple", "banana", "cherry", "date", "elderberry");
        int size = 5;

        List<List<String>> result = chunkArrayByStringSize(input, size);
    }



    /**
     * @param numbers A list of integers
     * @return A list containing the integers of the original list, without
     * duplicates, sorted by frequency of occurrence
     */

    public static List<Integer> frequencyOfApparition(List<Integer> numbers)
    {
        return numbers.stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    /**
     * @param numbers A list, containing list of numbers
     * @return The sum of all numbers, but all odd numbers should be multiplied before sum
     * Should return zero if there is no numbers
     */
    public static Integer sumArrays(List<List<Integer>> numbers)
    {
        int sum = numbers.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .map(i -> i % 2 != 0 ? i * 2 : i)
                .sum();
        return sum;
    }

    /**
     * @param students A hashmap containing students name as key, and student grade as value
     * @return The student with the best grade in the map
     */
    public static String bestStudent(Map<String, Integer> students) {
        HashMap<String, Integer> students = new HashMap<>();

        students.put("John Doe", 1);
        students.put("Jane Smith", 2);
        students.put("Alice Johnson", 3);

        // You can add more students or access them by name
        String studentName = "John Doe";
        if (students.containsKey(studentName)) {
            int studentId = students.get(studentName);
            System.out.println("Student Name: " + studentName + ", Student ID: " + studentId);
        }
        return ""; // Replace with your code here
    }
}
