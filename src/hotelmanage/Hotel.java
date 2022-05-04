package hotelmanage;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void add(Person person) {
        personList.add(person);
    }

    public int findByPassport(String passport) {
        for (int i = 0; i < personList.size(); i++) {
            if (passport.equals(personList.get(i).getPassport())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String passport) {
        if (findByPassport(passport) != -1) {
            personList.remove(findByPassport(passport));
        } else {
            System.out.println("Không tìm thấy !!!");
        }
    }

    public void displayAll() {
        boolean check = false;
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
            check = true;
        }
        if (!check) System.out.println("Chưa có ai thuê phòng !!!!");
    }

    public int result(String passport) {

        if (findByPassport(passport) != -1) {
            return personList.get(findByPassport(passport)).getPrice() * personList.get(findByPassport(passport)).getRoom().getPrice();
        }
        return -1;
    }
}
