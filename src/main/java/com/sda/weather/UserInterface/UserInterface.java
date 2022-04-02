package com.sda.weather.UserInterface;

import com.sda.weather.UserInterface.ForecastController;
import com.sda.weather.UserInterface.LocationController;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface {

    private final Scanner scanner;
    private final com.sda.weather.location.LocationController locationController;
    private final com.sda.weather.forecast.ForecastController forecastController;

    public void runApplication() {
        System.out.println("Witaj w aplikacji pogodowej\n");

        while (true) {
            System.out.println("Możlliwe opcje:");
            System.out.println("1. Dodać nową lokalizację");
            System.out.println("2. Wyświetlić dodane lokalizacje");
            System.out.println("3. Wyświetlić informacje o pogodzie dla lokalizacji");
            System.out.println("4. Zamknąć aplikację");
            System.out.print("\nWybierz co chcesz zrobić: ");

            int userInput = getInteger();

            switch (userInput) {
                case 1:
                    createLocation();
                    break;
                case 2:
                    getLocation();
                    break;
                case 3:
                    getWeatherForecast();
                    break;
                case 4:
                    return;
                default:
                    System.out.print("\nWybrałeś niewłaściwą opcję. ");
            }
        }
    }

    private void getWeatherForecast() {
        System.out.print("Podaj nazwe miasta: ");
        String cityId = scanner.nextLine();
        System.out.print("Podaj dzień prognozy [1-5] (opcjonalne): ");
        String period = scanner.nextLine();

        String result = forecastController.getForecast(cityId, period);
        System.out.println("Odpowiedź serwera: \n" + result + "\n");
    }

    private void getLocation() {
        String result = locationController.getLocations();
        result = result
                .replaceAll("\\{", "\n\t\\{")
                .replaceAll("}]", "}\n]");

        System.out.println("Odpowiedź serwera: \n" + result + "\n");
    }

    private void createLocation() {
        System.out.print("Podaj nazwe miasta: ");
        String city = scanner.nextLine();
        System.out.print("Podaj nazwe regionu (opcjonalne): ");
        String region = scanner.nextLine();
        System.out.print("Podaj nazwe kraju: ");
        String country = scanner.nextLine();
        System.out.print("Podaj szerokość geograficzną: ");
        String longitude = scanner.nextLine();
        System.out.print("Podaj długość geograficzną: ");
        String latitude = scanner.nextLine();
        String response = locationController.createLocation(city, region, country, longitude, latitude);
        System.out.println("Odpowiedź serwera: " + response + "\n");
    }

    private int getInteger() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.print("\nPodana wartość musi być cyfrą. Wpisz cyfrę: ");
            }
        }
    }
}
