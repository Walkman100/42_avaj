package wtc.mcarter.avaj.simulator.vehicles;

import wtc.mcarter.avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
