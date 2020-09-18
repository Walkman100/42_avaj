package wtc.mcarter.avaj.simulator.vehicles;

import wtc.mcarter.avaj.simulator.WeatherTower;
import wtc.mcarter.avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void registerTower(WeatherTower WeatherTower) {
        WeatherTower.register(this);
        weatherTower = WeatherTower;
    }

    private void checkCoords() {
        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
        }
    }

    public void updateConditions() {
        switch (weatherTower._getWeather(coordinates)) {
            case SUN:
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case RAIN:
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case FOG:
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case SNOW:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
        }

        checkCoords();
    }
}
