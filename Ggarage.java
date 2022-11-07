public class Ggarage {
    private int quantity;
    private int capacity;

    public Ggarage() {

    }

    public Ggarage(int quantity, int capacity, Car[] cars) {
        this.quantity = quantity;
        this.capacity = capacity;

    }
    public static void main(String[] args) {
        Ggarage garage1 = new Ggarage();
    }

        public String amount() {
        return "В гараже столько машин: " + quantity;
    }

    public String size() {
        return "Размер гаража: " + capacity;
    }

}














    //    private int maxCapacity;
//    private String cars;
//    private int quantity;










//    public void addCars(int quantity, Cars cars) {
//        Garage[] garage = {};
//        System.arraycopy(cars, 0, garage, 0, cars.length);
//        return garage;

//    }
//}





//    public Garage(int maxCapacity, String cars, int quantity) {
//        this.maxCapacity = maxCapacity;
//        this.cars = cars;
//        this.quantity = quantity;
//    }

//    public Garage() {
//  }


//}


