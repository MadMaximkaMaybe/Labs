enum Sex {
    MALE,
    FEMALE
}

class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Sex sex;

    public Human(String name, String surname, String patronymic, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}

class Student extends Human {
    public Student(String name, String surname, String patronymic, Sex sex) {
        super(name, surname, patronymic, sex);
    }
}

class University {
    private String name;
    private Human head;

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }
}

class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        Student student = new Student("John", "Doe", "Smith", Sex.MALE);
        University university = new University("Example University", student);

        System.out.println("University Name: " + university.getName());
        System.out.println("University Head: " + university.getHead().getName() + " " +
                university.getHead().getSurname() + " " + university.getHead().getPatronymic());
    }
}
