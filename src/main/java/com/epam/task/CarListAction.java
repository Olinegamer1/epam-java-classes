package com.epam.task;

import java.time.Year;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The class stores a list of cars and works with the list.
 *
 * @author Pavel Lysenkov
 * @version 1.0
 * @see Car
 */
public class CarListAction {
    /**
     * List for storing cars
     */
    private final List<Car> cars;

    /**
     * Constructor for initializing the list of cars.
     *
     * @param cars the initial cars list.
     */
    public CarListAction(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * Get a new list of cars by brand.
     *
     * @param brand name of the car brand.
     * @return new list of cars.
     */
    public List<Car> getListCarsByBrand(String brand) {
        return getListCarsByFilter(car -> car.getBrand().equals(brand));
    }

    /**
     * List of cars of this model that have been in operation for more than N years.
     *
     * @param year  year of manufacture of the car.
     * @param price car price.
     * @return new list of cars.
     */
    public List<Car> getListCarsByYearOfManufactureAndPriceHigherMoreThanGiven(int year, int price) {
        return getListCarsByFilter(car -> car.getYearOfManufacture().getValue() == year && car.getPrice() > price);
    }

    /**
     * List of cars of the specified year of manufacture, the price of which is more than the specified.
     *
     * @param model name of the car model.
     * @param year  year of manufacture of the car.
     * @return new list of cars.
     */
    public List<Car> getListCarsByModelMoreThanNumberOfYears(String model, int year) {
        return getListCarsByFilter(car -> car.getModel().equals(model)
                && (Year.now().getValue() - car.getYearOfManufacture().getValue()) > year);
    }

    /**
     * Get a list of cars by condition.
     *
     * @param predicate the condition by which the list of cars will be received.
     * @return new list cars.
     */
    private List<Car> getListCarsByFilter(Predicate<Car> predicate) {
        return cars.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
