package com.sda.weather;

import java.util.Scanner;

public class WeatherApplication {

    public void run() {
        System.out.println("Aplikacja jest uruchomiona\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj w aplikacji pogody! Wybierz opcję:");
            System.out.println("1. Dodaj miasto");
            System.out.println("2. Wyświetl aktualnie dodane miasta");
            System.out.println("3. Pobierz wartości pogodowe");
            System.out.println("0. Zamknij aplikację");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createLocation();
                    break;
                case 2:
                    showLocations();
                    break;
                case 3:
                    downloadWeatherData();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji");

            }
        }
    }

    private void createLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta: ");
        String name = scanner.nextLine();
        System.out.println("Podaj region: ");
        String region = scanner.nextLine();
        System.out.println("Podaj kraj: ");
        String country = scanner.nextLine();
        System.out.println("Podaj długość geograficzną: ");
        Double longitude = scanner.nextDouble();
        System.out.println("Podaj szerokość geograficzną: ");
        Double latitude = scanner.nextDouble();
    }

    private void showLocations() {
        System.out.println("Aktualnie dodane lokalizacje: ");
    }

    private void downloadWeatherData() {
        System.out.println("Aktualne wartości pogodowe: ");
    }
}