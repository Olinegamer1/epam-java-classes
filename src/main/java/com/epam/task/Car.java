package com.epam.task;

import java.awt.Color;
import java.time.Year;
import java.util.Objects;

import static java.lang.Math.max;

/**
 * The class is used to store car objects with parameters
 * <b>id</b>, <b>model</b>, <b>brand</b>, <b>year of manufacture</b>, <b>color</b>,
 * <b>price</b> and <b>registration number</b>.
 *
 * <p>To create a car object use {@code CarBuilder}.
 *
 * @author Pavel Lysenkov
 * @version 1.0
 */
public final class Car {

    /**
     * Unique id for the car.
     */
    private final long id;

    /**
     * Car model name.
     */
    private final String model;

    /**
     * Car manufacturer name for the model.
     */
    private final String brand;

    /**
     * Vehicle production year.
     *
     * @see java.time.Year
     */
    private final Year yearOfManufacture;

    /**
     * Car color.
     *
     * @see java.awt.Color
     */
    private Color color;

    /**
     * Сar cost.
     */
    private int price;

    /**
     * Car registration number.
     */
    private String registrationNumber;

    /**
     * The class implements the builder pattern for creating a car object.
     */
    public static class CarBuilder {

        /**
         * The variable is used to initialize the id field.
         */
        private static long nextId;
        private final long id;
        private final String model;
        private final String brand;
        private final Year yearOfManufacture;
        private final Color color;

        private int price;
        private String registrationNumber;

        /**
         * Constructor with required fields used to create a car object.
         *
         * @param model             the initial model of car.
         * @param brand             the initial brand of car.
         * @param yearOfManufacture - the initial year of manufacture of car.
         * @param color             the initial car color.
         * @throws NullPointerException     if <b>model</b>, <b>brand</b>, <b>yearOfManufacture</b> or <b>color</b> is null.
         * @throws IllegalArgumentException if year of manufacture is greater than the current year.
         */
        public CarBuilder(String model, String brand, Year yearOfManufacture, Color color) {
            this.id = getNextId();
            this.model = Objects.requireNonNull(model);
            this.brand = Objects.requireNonNull(brand);
            this.yearOfManufacture = requireCorrectYear(yearOfManufacture);
            this.color = Objects.requireNonNull(color);
        }

        /**
         * Set the price of the car. If the price is below 0, then the default value is 0.
         *
         * @param price the initial price of car.
         * @return a reference to this object.
         */
        public CarBuilder price(int price) {
            this.price = max(0, price);
            return this;
        }

        /**
         * Set the car registration number.
         *
         * @param registrationNumber - the initial car registration number.
         * @return a reference to this object.
         * @throws IllegalArgumentException if the registration number of the car does not meet the standard or null
         * @see CarUtils#isCorrectRegistrationNumber(String)
         */
        public CarBuilder registrationNumber(String registrationNumber) {
            if (!CarUtils.isCorrectRegistrationNumber(registrationNumber)) {
                throw new IllegalArgumentException("Invalid registration number");
            }
            this.registrationNumber = registrationNumber;
            return this;
        }

        /**
         * Build a Car object.
         * If the registration number has not been set, it will be generated automatically.
         *
         * @return Car object
         * @see CarUtils#generateRegistrationNumber()
         */
        public Car build() {
            if (Objects.isNull(registrationNumber)) {
                this.registrationNumber = CarUtils.generateRegistrationNumber();
            }
            return new Car(this);
        }

        /**
         * Sets the current id value and increments the counter by one.
         *
         * @return id value.
         */
        private long getNextId() {
            return nextId++;
        }

        /**
         * Checks the year of manufacture of the car for correctness and returns it
         *
         * @param yearOfManufacture - the initial year of manufacture.
         * @return year of manufacture.
         * @throws NullPointerException     if <b>yearOfManufacture</b> is null.
         * @throws IllegalArgumentException if year of manufacture is greater than the current year.
         */
        private Year requireCorrectYear(Year yearOfManufacture) {
            if (Objects.isNull(yearOfManufacture) || yearOfManufacture.getValue() > Year.now().getValue()) {
                throw new IllegalArgumentException("Invalid production year");
            }
            return yearOfManufacture;
        }
    }

    public Car(CarBuilder builder) {
        this.id = builder.id;
        this.model = builder.model;
        this.brand = builder.brand;
        this.yearOfManufacture = builder.yearOfManufacture;
        this.color = builder.color;
        this.price = builder.price;
        this.registrationNumber = builder.registrationNumber;
    }


    public long getID() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Year getYearOfManufacture() {
        return yearOfManufacture;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setColor(Color color) {
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Generates the car registration number
     *
     * @see CarUtils#generateRegistrationNumber()
     */
    public void setRegistrationNumber() {
        this.registrationNumber = CarUtils.generateRegistrationNumber();
    }

    public void setPrice(int price) {
        this.price = max(0, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getID(), car.getID())
                && Objects.equals(getPrice(), car.getPrice())
                && Objects.equals(getModel(), car.getModel())
                && Objects.equals(getBrand(), car.getBrand())
                && Objects.equals(getColor(), car.getColor())
                && Objects.equals(getYearOfManufacture(), car.getYearOfManufacture())
                && Objects.equals(getRegistrationNumber(), car.getRegistrationNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getModel(), getBrand(), getYearOfManufacture(), getColor(),
                getPrice(), getRegistrationNumber());
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", color=" + color +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
