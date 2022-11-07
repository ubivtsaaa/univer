import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class getInfo {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "black", 250, "Automatic", 5000000);
        Car car2 = new Car("Mercedes", "white", 260, "Automatic", 6000000);
        Car car3 = new Car("Lexus", "white", 270, "Manual", 4500000);

        Car[] cars = new Car[] {car1, car2, car3};
//        Ggarage[] garage = new Ggarage[] {garage1};
//        Garage[] garage = {};
//        System.arraycopy(cars, 0, garage, 0, cars.length);

        printCars(cars);
        byPrice(cars);


    }

    static int count = 0;
    public static void printCars(Car[] cars) {

        System.out.println("Список машин в гараже: ");
        for (Car car : cars) {
            count++;
            System.out.println(car.info());
        }
        System.out.println("Количество машин в гараже: " + count);

//        cars.sort(Comparator.comparing(car::price));
//        Collections.sort(cars, Comparator.comparingInt(Car::cars(price)))

        }

        static class Packet{
            int price;

            public Packet(int price) {
                this.price = price;
            }

            @Override
            public String toString() {
                return "Packet{" +
                        "price=" + price +
                        '}';
            }
        }

        public static void byPrice(Car[] cars) {
            List<Car> carList = Arrays.asList(new Car("BMW", "black", 250, "Automatic", 5000000),
                    new Car("Mercedes", "white", 260, "Automatic", 6000000),
                    new Car("Lexus", "white", 270, "Manual", 4500000));
            carList.sort(Comparator.comparingInt(packet -> packet.price));


            System.out.print("Машины по цене по возрастанию: " + carList);

        }

}