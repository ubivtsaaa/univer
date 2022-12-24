// Необходимые модули
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ToDoManager2 {
    // Объявляем массив под задачи
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Запускаем бесконечное выполнение программы пока пользователь не выберет выход
        while (true) {
            // Выводим варианты действий
            System.out.println("Выберете действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Редактировать задачу");
            System.out.println("4. Отметить задачу как законченую");
            System.out.println("5. Посмотреть список законченых задач");
            System.out.println("6. Посмотреть список незаконченых задач");
            System.out.println("7. Выход");
            // Ввод выбора
            int action = scanner.nextInt();
            scanner.nextLine();
// Активация действий по по числу
            if (action == 1) {
                addTask();
            } else if (action == 2) {
                deleteTask();
            } else if (action == 3) {
                editTask();
            } else if (action == 4) {
                markTaskAsFinished();
            } else if (action == 5) {
                viewFinishedTasks();
            } else if (action == 6) {
                viewUnfinishedTasks();
            } else if (action == 7) {
                break;
            }
        }
    }

    private static void addTask() {
        // Метод добавления задачи. Все вводится построчно
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название задачи:");
        String name = scanner.nextLine();

        System.out.println("Введите описание задачи:");
        String description = scanner.nextLine();

        tasks.add(new Task(name, description, new Date()));
        System.out.println("Задача успешно добавлена.");
    }

    private static void deleteTask() {
        Scanner scanner = new Scanner(System.in);
// Тут в общем-то примерно также как и в предыдущем методе устроено
        System.out.println("Введите индекс задачи, начиная с нуля:");
        int index = scanner.nextInt();
        scanner.nextLine();
// Обработка ситуации со слишком маленькими или выходящими за пределы индексами
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс.");
            return;
        }

        tasks.remove(index);
        System.out.println("Задача успешно удалена.");
    }

    private static void editTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индекс задачи:");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        // Присвоение введенного индекса конкретной задаче
        Task task = tasks.get(index);

        System.out.println("Введите новое название задачи:");
        String name = scanner.nextLine();

        System.out.println("Введите новое описание задачи:");
        String description = scanner.nextLine();
        // Замена данных
        task.setName(name);
        task.setDescription(description);
        System.out.println("Здача успешно изменена.");
    }

    private static void markTaskAsFinished() {
        // Метод отметки задач как выполненных
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индекс задачи, начиная с нуля:");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Невереный индекс.");
            return;
        }

        Task task = tasks.get(index);
        task.setFinished(true);
        // Присвается конкретное время в момент действия
        task.setFinishedDate(new Date());
        System.out.println("Задача успешно отмечена как выполненая.");
    }

    private static void viewFinishedTasks() {
        System.out.println("Выполненные задачи:");
        // Вывод списка выполненных задач, проходя по их индексам и проверка на соответсвие isFinished = true
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.isFinished()) {
                System.out.println(i + ". " + task.getName() + " - " + task.getDescription() + " - " + task.getFinishedDate());
            }
        }
    }

    private static void viewUnfinishedTasks() {
        // Тоже самое как в предыдщем методе только проверка на isFinished не равное true
        System.out.println("Невыполненные задачи:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (!task.isFinished()) {
                System.out.println(i + ". " + task.getName() + " - " + task.getDescription() + " - " + task.getCreatedDate());
            }
        }
    }
}
