import java.util.Date;

class Task {
    // Объявление перменных
    private String name;
    private String description;
    private Date createdDate;
    private boolean finished;
    private Date finishedDate;
    public Task(String name, String description, Date createdDate) {
        // Сам объект задачи
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.finished = false;
    }

    public String getName() {
        // Этот метод возвращает значение name в виде строки и может быть вызван из любого класса или объекта
        return name;
    }

    public void setName(String name) {
        // Задаем имя. В качестве параметра принимает введенная с клавитуры строка
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isFinished() {
        // Для проверки состояния задачи через true/false
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        // Устанавливаем время перехода в список завершенных задач
        this.finishedDate = finishedDate;
    }
}