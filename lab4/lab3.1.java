import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

class Human {
    private String name;
    private String surname;
    private String patronymic;
    private Sex sex;

    // конструктор, геттеры и сеттеры

    // переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human other = (Human) obj;
        return name.equals(other.name) &&
                surname.equals(other.surname) &&
                patronymic.equals(other.patronymic) &&
                sex == other.sex;
    }
}

enum Sex {
    MALE,
    FEMALE
}

class Student extends Human {
    // дополнительные поля и методы студента
}

class Group {
    private String name;
    private Human head;

    // конструктор, геттеры и сеттеры
}

class Department {
    private String name;
    private Human head;

    // конструктор, геттеры и сеттеры
}

class Faculty {
    private String name;
    private Human head;

    // конструктор, геттеры и сеттеры
}

class University {
    private String name;
    private Human head;

    // конструктор, геттеры и сеттеры
}

class JsonManager {
    private Gson gson;

    public JsonManager() {
        this.gson = new Gson();
    }

    public void writeToJsonFile(University university, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            String json = gson.toJson(university);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String convertToJson(University university) {
        return gson.toJson(university);
    }

    public University convertFromJson(String json) {
        return gson.fromJson(json, University.class);
    }
}

public class Run {
    public static void main(String[] args) {
        University oldUniversity = createTypicalUniversity();

        JsonManager jsonManager = new JsonManager();

        // Запись oldUniversity в файл
        jsonManager.writeToJsonFile(oldUniversity, "university.json");

        // Чтение данных из файла и восстановление объекта newUniversity
        University newUniversity = jsonManager.convertFromJson(readJsonFromFile("university.json"));

        // Проверка эквивалентности oldUniversity и newUniversity
        boolean isEqual = oldUniversity.equals(newUniversity);
        System.out.println("Universities are equal: " + isEqual);
    }

    private static University createTypicalUniversity() {
        // Создание университета и его подразделений
        University university = new University();
        Faculty faculty = new Faculty();
        Department department1 = new Department();
        Department department2 = new Department();
        Group group1 = new Group();
        Group group2 = new Group();
        Student student1 = new Student();
        Student student2 = new Student();

        // Заполнение данных университета

        // Установка головного лица
        Human head = new Human();
        head.setName("John");
        head.setSurname("Doe");
        head.setPatronymic("Smith");
        head.setSex(Sex.MALE);
        university.setHead(head);

        // Установка головного лица для факультета
        faculty.setHead(head);

        // Установка головного лица для кафедр
        department1.setHead(head);
        department2.setHead(head);

        // Установка головного лица для групп
        group1.setHead(head);
        group2.setHead(head);

        // Установка студентов для групп
        group1.addStudent(student1);
        group1.addStudent(student2);
        group2.addStudent(student1);
        group2.addStudent(student2);

        // Добавление кафедр к факультету
        faculty.addDepartment(department1);
        faculty.addDepartment(department2);

        // Добавление групп к кафедрам
        department1.addGroup(group1);
        department1.addGroup(group2);
        department2.addGroup(group1);
        department2.addGroup(group2);

        // Добавление факультета к университету
        university.addFaculty(faculty);

        return university;
    }

    private static String readJsonFromFile(String fileName) {
        // Чтение данных из файла и возврат в виде строки JSON
        // Ваш код чтения данных из файла
        return "";
    }
}
