package second;

import java.util.Random;
import java.util.Scanner;

public class Task9 {
    static class Car {
        private int distance;
        private int fuelLevel;
        private int consumption;

        public int getDistance() {
            return distance;
        }

        public int getFuelLevel() {
            return fuelLevel;
        }

        public void refuel(int gallons) {
            fuelLevel += gallons;
        }

        public void drive(int miles) {
            distance += Math.min(miles, fuelLevel * consumption);
            fuelLevel = Math.max(0, fuelLevel - miles / consumption);
        }

        public Car(int consumption) {
            this.distance = 0;
            this.fuelLevel = 0;
            this.consumption = consumption;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "distance=" + distance +
                    ", fuelLevel=" + fuelLevel +
                    ", consumption=" + consumption +
                    '}';
        }
    }


    public static void main(String[] args) {
        Car car = new Car(3);
        car.refuel(100);
        car.drive(100000);
        System.out.println(car.toString());
    }
}
