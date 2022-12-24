public class Reader {
    private String name;
    private int number;
    private String faculty;
    private String birth;
    private String phone;

    public Reader(String name, int number, String faculty, String birth, String phone) {
        this.name = name;
        this.number = number;
        this.faculty = faculty;
        this.birth = birth;
        this.phone = phone;
    }

    public Reader() {
    }

    public String getFio() {
        return name;
    }

    public void setFio(String fio) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDob() {
        return birth;
    }

    public void setDob(String dob) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void takeBook(int number) {
        System.out.println(this.name + " взял " + number + " книги.");
    }

    public void takeBook(String... books) {
        System.out.println(this.name + " взял такие книги:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.println(this.name + " взял такие книги:");
        for (Book book : books) {
            System.out.println(book.getName() + ", автора " + book.getAuthor());
        }
        System.out.println();
    }

    public void returnBook(int number) {
        System.out.println(this.name + " вернул " + number + " книги.");
    }

    public void returnBook(String... books) {
        System.out.println(this.name + " вернул такие книги:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.println(this.name + " вернул следующие книги:");
        for (Book book : books) {
            System.out.println(book.getName() + ", автора " + book.getAuthor());
        }
        System.out.println();
    }

    public String getInfo() {
        return "{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", faculty='" + faculty + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}