package wtc.mcarter.avaj.simulator;

import wtc.mcarter.avaj.weather.Coordinates;
import wtc.mcarter.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public WeatherProvider.WeatherType _getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider()._getCurrentWeather(coordinates);
    }

    protected void changeWeather() {
        super.conditionsChanged();
    }
}
