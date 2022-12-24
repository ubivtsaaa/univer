public class Car {

    private String model;
    private String color;
    private int topSpeed;
    private String gear;
//    private int currentSpeed;
    public int price;

    public Car(String model, String color, int topSpeed, String gear,  int price) {
        this.model = model;
        this.color = color;
        this.topSpeed = topSpeed;
        this.gear = gear;
//        this.currentSpeed = currentSpeed;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", topSpeed=" + topSpeed +
                ", gear='" + gear + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Car() {

    }
    public void start() {
        System.out.println(this.model + "завелась");

    }

    public void stop() {
        System.out.println(this.model + "остановилась");

    }

    public void accelerate(int speed) {
        System.out.println(this.model + "едет со скоростью" + speed);

    }

//    public int getQuantity() {
//        return quantity;
//    }

    public String info() {
        return model + " of " + color + " color" + " has " + topSpeed + " max speed and costs " + price + " rubles";
    }

}