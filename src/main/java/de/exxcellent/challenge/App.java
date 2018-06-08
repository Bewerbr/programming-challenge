package de.exxcellent.challenge;
import de.exxcellent.*;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) throws Exception {

        // Your preparation code …

        String dayWithSmallestTempSpread = de.exxcellent.sqldatabase.Sqldatabase.dayWithSmallestTempSpread();   // Your day analysis function call …
        String teamWithSmallesGoalSpread = de.exxcellent.sqldatabase.Sqldatabase.teamWithSmallesGoalSpread(); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
