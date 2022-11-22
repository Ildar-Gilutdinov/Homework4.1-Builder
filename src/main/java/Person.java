import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    private OptionalInt age;

    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() { // Если возраст человека известен,
        // то с момента создания объекта он может быть изменён только увеличением на единицу через вызов метода
        age = OptionalInt.of(age.getAsInt() + 1);
    }

    public boolean hasAge() { //Метод isPresent() проверяет наличие значения внутри объекта Optional.
        return age.isPresent();
    }

    public boolean hasAddress() {
        if (city == null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() { // метод сравнения объектов
        return Objects.hash(name, OptionalInt.of(0), city);
    }

    public PersonBuilder newChildBuilder() { //метод для получения билдера для ребёнка в класс Person
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(city);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + ", city=" + city + '}';
    }
}
