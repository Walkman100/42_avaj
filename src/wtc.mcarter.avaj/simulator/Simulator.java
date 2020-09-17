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
                    WriteLine("Invalid simulations count: " + simulations);
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
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
            WriteLine("Couldn't find file: " + arg[0]);
        } catch (IOException e) {
            WriteLine("There was an error while reading the file: " + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            WriteLine("Specify simulation file!");
        } catch (AircraftTypeNotFoundException e) {
            WriteLine("Invalid simulation file! Error: " + e.getMessage());
        } finally {
            Logger.getLogger().close();
        }
    }

    private static void WriteLine(String line) {
        System.out.println(line);
    }
}
