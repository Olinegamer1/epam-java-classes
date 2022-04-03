package com.epam.task;

import java.awt.*;
import java.time.Year;
import java.util.*;
import java.util.List;

public class Runner {

    private static final List<Car> cars = Arrays.asList(
            new Car.CarBuilder("Cayman", "Porsche", Year.of(2015), Color.RED).price(50_000).registrationNumber("R123NCV").build(),
            new Car.CarBuilder("Cayman", "Porsche", Year.of(2020), Color.BLACK).price(75_000).build(),
            new Car.CarBuilder("GT4 RS", "Porsche", Year.of(2022), Color.GRAY).price(150_000).build(),
            new Car.CarBuilder("GT4", "Porsche", Year.of(2018), Color.YELLOW).price(80_000).registrationNumber("THEFIRS").build(),
            new Car.CarBuilder("GT3 RS", "Porsche", Year.of(2019), Color.BLUE).price(200_000).build(),
            new Car.CarBuilder("Cayman Boxter", "Porsche", Year.of(2016), Color.WHITE).price(60_000).build(),
            new Car.CarBuilder("Cayman GTS", "Porsche", Year.of(2021), Color.RED).price(100_000).registrationNumber("1326ADA").build(),
            new Car.CarBuilder("918 Spyder", "Porsche", Year.of(2014), Color.WHITE).price(991_600).registrationNumber("918SPY").build(),
            new Car.CarBuilder("Cayman Macan", "Porsche", Year.of(2018), Color.BLACK).price(90_000).build(),
            new Car.CarBuilder("Model S", "Tesla", Year.of(2017), Color.BLUE).price(64_900).build(),
            new Car.CarBuilder("Model S", "Tesla", Year.of(2018), Color.BLACK).price(76_900).build(),
            new Car.CarBuilder("Model 3", "Tesla", Year.of(2018), Color.GRAY).price(54_300).build(),
            new Car.CarBuilder("Model 3", "Tesla", Year.of(2020), Color.WHITE).price(55_700).build(),
            new Car.CarBuilder("Wagoneer", "Jeep", Year.of(2022), Color.RED).price(58_995).build(),
            new Car.CarBuilder("Wrangler", "Jeep", Year.of(2022), Color.RED).price(29_995).build(),
            new Car.CarBuilder("Compass", "Jeep", Year.of(2022), Color.DARK_GRAY).price(26_390).build(),
            new Car.CarBuilder("Stelvio Quadrifoglio", "Alpha Romeo", Year.of(2022), Color.RED).price(90_000).build(),
            new Car.CarBuilder("Valhalla", "Aston Martin", Year.of(2022), Color.WHITE).price(1_260_000).build(),
            new Car.CarBuilder("DBX", "Aston Martin", Year.of(2022), Color.BLACK).price(176_000).build(),
            new Car.CarBuilder("DBS Volante", "Aston Martin", Year.of(2022), Color.WHITE).price(334_000).build(),
            new Car.CarBuilder("DB11", "Aston Martin", Year.of(2022), Color.RED).price(147_000).registrationNumber("R122NCV").build(),
            new Car.CarBuilder("DB11 AMR", "Aston Martin", Year.of(2022), Color.ORANGE).price(245_000).build(),
            new Car.CarBuilder("Vantage", "Aston Martin", Year.of(2022), Color.GREEN).price(139_000).build(),
            new Car.CarBuilder("DBS Superleggera Volante", "Aston Martin", Year.of(2022), Color.DARK_GRAY).price(364_700).build(),
            new Car.CarBuilder("Valkyrie", "Aston Martin", Year.of(2022), Color.cyan).price(3_500_000).build()
    );

    public static void main(String[] args) {
        CarListAction action = new CarListAction(cars);
        action.getListCarsByBrand("Aston Martin").forEach(System.out::println);
        action.getListCarsByModelMoreThanNumberOfYears("Cayman", 3).forEach(System.out::println);
        action.getListCarsByYearOfManufactureAndPriceHigherMoreThanGiven(2022, 3_000_000).forEach(System.out::println);
    }
}