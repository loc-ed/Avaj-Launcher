package simulator.weather;

import simulator.vehicles.*;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = (int)(Math.random() * 4);
        return weather[index];
    }
}