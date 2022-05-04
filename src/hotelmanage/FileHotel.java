package hotelmanage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHotel {
    public static void writeFile(String path, List<Person> personList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "name,age,passport,roomName,priceDay \n";
//        String str = "";
        for (Person person : personList) {
            str += person.getName() + "," + person.getAge() + "," + person.getPassport() + "," + person.getRoom().getCategory() + "," + person.getPrice() + "\n";
//            str+=person.toString() +"\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static List<Person> readFile(String path) throws IOException {
        List<Person> personList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            String[] arr = str.split(",");
            personList.add(new Person(arr[0], Integer.parseInt(arr[1]), arr[2], arr[3], Integer.parseInt(arr[4])));
        }
        return personList;
    }
}
