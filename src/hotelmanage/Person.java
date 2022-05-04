package hotelmanage;

public class Person {
    private String name;
    private int age;
    private String passport;
    private Room room;
    private int priceDay;
    private String roomID;

    public Person() {
    }

    public Person(String name, int age, String passport, Room room, int price) {
        this.name = name;
        this.age = age;
        this.passport = passport;
        this.room = room;
        this.priceDay = price;
    }

    public Person(String name, int age, String passport, String roomID, int priceDay) {
        this.name = name;
        this.age = age;
        this.passport = passport;
        this.priceDay = priceDay;
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPrice() {
        return priceDay;
    }

    public void setPrice(int price) {
        this.priceDay = price;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passport='" + passport + '\'' +
                ", room=" + room +
                ", priceDay=" + priceDay +
                '}';
    }
}
