import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // Create an array of Car objects
        Car[] cars = {
            new Car("Mercedes-Benz", "AMG GT", 2024, 350000, 4.8),
            new Car("Volkswagen", "Golf SEL", 2015, 14000, 6.66),
            new Car("Ford", "Focus", 2021, 22000, 4.3),
            new Car("BMW", "X5", 2020, 50000, 4.8),
            new Car("Audi", "A8", 2018, 200000, 4.6)
        };

        // Sort the array: by price (ascending) and by rating (descending)
        Arrays.sort(
            cars,
            Comparator.comparingDouble(Car::getPrice).thenComparing(
                Comparator.comparingDouble(Car::getRating).reversed()
            )
        );

        // Print the sorted array
        System.out.println("Sorted cars:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Search for a car identical to the given one
        Car targetCar = new Car("Volkswagen", "Golf SEL", 2015, 14000, 6.66);
        int index = Arrays.binarySearch(
            cars,
            targetCar,
            Comparator.comparing(Car::getModel).thenComparingInt(Car::getYear)
        );

        if (index >= 0) {
            System.out.println("\nFound car:");
            System.out.println(cars[index]);
        } else {
            System.out.println("\nTarget car not found.");
        }
    }
}

/**
 * Class representing a car.
 */
class Car {

    private String brand; // Car brand
    private String model; // Car model
    private int year; // Manufacturing year
    private double price; // Car price
    private double rating; // Car rating

    // Constructor
    public Car(
        String brand,
        String model,
        int year,
        double price,
        double rating
    ) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rating = rating;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    // Override the toString method
    @Override
    public String toString() {
        return String.format(
            "Brand: %s, Model: %s, Year: %d, Price: %.2f, Rating: %.1f",
            brand,
            model,
            year,
            price,
            rating
        );
    }

    // Override the equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;
        return (
            year == car.year &&
            Double.compare(car.price, price) == 0 &&
            Double.compare(car.rating, rating) == 0 &&
            brand.equals(car.brand) &&
            model.equals(car.model)
        );
    }
}
