package wtc.mcarter.avaj.weather;

public class WeatherProvider {
    // static
    private static WeatherProvider weatherProvider;
    private static String[] weather = {
        WeatherType.RAIN.name(),
        WeatherType.FOG.name(),
        WeatherType.SUN.name(),
        WeatherType.SNOW.name()
    };

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public enum WeatherType {
        RAIN,
        FOG,
        SUN,
        SNOW
    }

    // instance
    public WeatherType _getCurrentWeather(Coordinates coordinates) {
        int index = coordinates.getLatitude();
        index *= coordinates.getLongitude();
        index += coordinates.getHeight();

        if (index > 3) { // remove the extra multiple of 4 from index to bind to (0-3)
            index = index % 4;
        }

        return WeatherType.values()[index];
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return _getCurrentWeather(coordinates).name();
    }
}
