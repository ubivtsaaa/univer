import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CinemaAdministrator {
    private static Map<String, String> films = new HashMap<>();
    private static Map<String, Double> prices = new HashMap<>();
    private static Map<String, String[]> bookedSeats = new HashMap<>();
    private static double moneySpent = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Приветствую!");
            System.out.println("Выберете действие:");
            System.out.println("1. Добавить фильм");
            System.out.println("2. Задать цену на фильм");
            System.out.println("3. Купить билет");
            System.out.println("4. Посмотреть забронированные места");
            System.out.println("5. Количество потраченных денег");
            System.out.println("6. Выход");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addFilm();
                    break;
                case 2:
                    setFilmPrice();
                    break;
                case 3:
                    buySeat();
                    break;
                case 4:
                    viewBookedSeats();
                    break;
                case 5:
                    viewMoneySpent();
                    break;
                case 6:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверная опция.");
                    break;
            }
        }
    }

    private static void addFilm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма:");
        String title = scanner.nextLine();
        System.out.println("Введите время начала сеанса (в формате часы:минуты):");
        String startTime = scanner.nextLine();
        films.put(title, startTime);
        bookedSeats.put(title, new String[10]); // Инициализируем массив из 10 мест
        System.out.println("Фильм успешно добавлен");
    }

    private static void setFilmPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма:");
        String title = scanner.nextLine();
        if (!films.containsKey(title)) {
            System.out.println("Фильм не найден.");
            return;
        }
        System.out.println("Введите цену на сеанс:");
        double price = scanner.nextInt();
        prices.put(title, price);
        System.out.println("Цена добавлена");
    }

    private static void buySeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма:");
        String title = scanner.nextLine();
        if (!films.containsKey(title)) {
            System.out.println("Фильм не найден");
            return;
        }
        if (!prices.containsKey(title)) {
            System.out.println("Сначала установите цену");
            return;
        }

        String[] seats = bookedSeats.get(title);
        System.out.println("Выберите место (1-10):");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Неверный номер места");
            return;
        }
        if (seats[seatNumber - 1] != null) {
            System.out.println("Это место уже занято");
            return;
        }

        seats[seatNumber - 1] = "Занято";
        double price = prices.get(title);
        moneySpent += price;
        System.out.println("Место успешно куплено. Его цена - $" + price);
    }

    private static void viewBookedSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма:");
        String title = scanner.nextLine();
        if (!films.containsKey(title)) {
            System.out.println("Фильм не найден");
            return;
        }

        String[] seats = bookedSeats.get(title);
        System.out.println("Забронированные места на фильм '" + title + "':");
        for (int i = 0; i < seats.length; i++) {
            System.out.println((i + 1) + ". " + seats[i]);
        }
    }

    private static void viewMoneySpent() {
        System.out.println("Денег получено: $" + moneySpent);
    }
}
