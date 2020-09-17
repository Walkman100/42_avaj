package wtc.mcarter.avaj.simulator.vehicles;

import wtc.mcarter.avaj.simulator.WeatherTower;
import wtc.mcarter.avaj.weather.Coordinates;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        //
    }

    public void registerTower(WeatherTower WeatherTower) {
        //
    }
}
