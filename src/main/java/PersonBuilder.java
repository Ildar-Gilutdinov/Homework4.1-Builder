import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;

    private String city;

    public PersonBuilder(String surname, OptionalInt age, String city) {
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public PersonBuilder() {
    }

    public String getName() {
        return name;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public OptionalInt getAge() {
        return age;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Введен некорректный возраст," + " возраст должен быть от 0 до 100, а у вас " + age);
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public String getAddress() {
        return city;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Имя вводить обязательно");
        }
        if (surname == null) {
            throw new IllegalStateException("Фамилию вводить обязательно");
        }

        Person person;
        //Person person = age.isPresent() ? new Person(name, surname) : new Person(name, surname, age);
        if (age.isPresent()) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        if (city != null) {
            person.setAddress(city);
        }
        return person;
    }
}
