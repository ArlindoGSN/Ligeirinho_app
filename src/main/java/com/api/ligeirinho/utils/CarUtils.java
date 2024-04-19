package com.api.ligeirinho.utils;

import com.api.ligeirinho.domain.entities.Car;

public class CarUtils {


        public static String formattedPlate(Car car) {
            String plate = car.getPlate();

            return plate.substring(0,3) + "-" + plate.substring(4,6);
        }

}
