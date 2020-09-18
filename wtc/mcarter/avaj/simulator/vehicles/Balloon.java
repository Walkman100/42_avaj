package wtc.mcarter.avaj.simulator.vehicles;

import wtc.mcarter.avaj.simulator.WeatherTower;
import wtc.mcarter.avaj.weather.Coordinates;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void registerTower(WeatherTower WeatherTower) {
        WeatherTower.register(this);
        weatherTower = WeatherTower;
    }

    private void checkCoords() {
        if (coordinates.getHeight() == 0) {
            super.writeLandingMessage();
            weatherTower.unregister(this);
        }
    }

    public void updateConditions() {
        super.writeStatusMessage(weatherTower);
        switch (weatherTower._getWeather(coordinates)) {
            case SUN:
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case RAIN:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            case FOG:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case SNOW:
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                break;
        }

        checkCoords();
    }
}
