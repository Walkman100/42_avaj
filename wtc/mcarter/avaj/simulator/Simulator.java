package wtc.mcarter.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import wtc.mcarter.avaj.simulator.vehicles.AircraftFactory;
import wtc.mcarter.avaj.simulator.vehicles.AircraftTypeNotFoundException;
import wtc.mcarter.avaj.simulator.vehicles.Flyable;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] arg) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();

                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    Logger.gL().writeLine("Invalid simulations count: " + simulations);
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {
                    String[] lineSegments = line.split(" ");
                    Flyable flyable = AircraftFactory.newAircraft(lineSegments[0], lineSegments[1],
                            Integer.parseInt(lineSegments[2]), Integer.parseInt(lineSegments[3]),
                            Integer.parseInt(lineSegments[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            Logger.gL().writeLine("Couldn't find file: " + arg[0]);
        } catch (IOException e) {
            Logger.gL().writeLine("There was an error while reading the file: " + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.gL().writeLine("Specify simulation file!");
        } catch (AircraftTypeNotFoundException e) {
            Logger.gL().writeLine("Invalid simulation file! Error: " + e.getMessage());
        } finally {
            Logger.getLogger().close();
        }
    }
}
