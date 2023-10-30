package ch.jobtrek;

import ch.jobtrek.sbb.Tunnel;
import ch.jobtrek.sbb.Tunnelable;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Csv {

    /**
     * This method reads the CSV file, and parse each lines to create a list of objects that represent a tunnel.
     *
     * @param filePath The path to the CSV file
     * @return A List of objects that implements the Tunnelable interface. You need to create this special class.
     */
    public static List<Tunnelable> importCSVfile(URI filePath) {
        try (var file = Files.lines(Paths.get(filePath))) {
            return file.skip(1)
                    .map(line -> line.split(";"))
                    .map(line -> new Tunnel(
                            line[1],
                            Double.parseDouble(line[2]) / 1000,
                            Integer.parseInt(line[3]),
                            line[8]
                    ))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            return List.of();
        }
    }

    /**
     * Sort the list of tunnels provided, and pick de 10 longest
     *
     * @param tunnels A List of tunnels
     * @return A List containing only the 10 longest tunnels
     */
    public static List<Tunnelable> tenLongestTunnels(List<Tunnelable> tunnels) {
        // Sort the tunnels in descending order of length
        Collections.sort(tunnels, (t1, t2) -> Integer.compare((int) t2.getKilometerLength(), (int) t1.getKilometerLength()));

        // Create a new list to store the 10 longest tunnels
        List<Tunnelable> longestTunnels = new ArrayList<>();

        // Add the 10 longest tunnels to the new list
        int count = Math.min(10, tunnels.size());
        for (int i = 0; i < count; i++) {
            longestTunnels.add(tunnels.get(i));
        }

        return longestTunnels;
    }

    /**
     * @param tunnels List of tunnels
     * @return The computed average of the length of all tunnels
     */
    public static double computeAverageLength(List<Tunnelable> tunnels) {
        return 0; // Replace with your code here
    }

    /**
     * @param tunnels List of tunnels
     * @return A Map with the year as key and the number of tunnels as value
     */
    public static Map<Integer, Long> tunnelsByYears(List<Tunnelable> tunnels) {
        return Map.of(); // Replace with your code here
    }

    /**
     * @param tunnels List of tunnels
     * @return The year in which the most tunnels were built
     */
    public static int yearWithBiggestTunnelBuilds(List<Tunnelable> tunnels) {
        return 0; // Replace with your code here
    }

}