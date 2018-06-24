/*
Class Phonebook
Object creates from String[] array with elements which contains "phone_number surname"

@author Grishin Dmitriy
@version dated 29.12.17
@link null
*/

import java.util.*;//чтобы работать с классами коллекций

public class Phonebook {

    private TreeMap<Integer, String> phonebook;

    public Phonebook(String[] peoplePhones){
        TreeMap<Integer, String> phonebook = new TreeMap<>();
        String[] tmpArray;
        for (int i = 0; i < peoplePhones.length; i++) {
            tmpArray = peoplePhones[i].split(" ");//разбиваю строку на телефон и фамилию
            phonebook.put(Integer.parseInt(tmpArray[0]), tmpArray[1]);//заполняю коллекцию парами "телефон - значение"
        }
        this.phonebook = phonebook;
    }

    //стандартный геттер для вывода содержимого справочника
    public TreeMap<Integer, String> getPhonebook() {
        return phonebook;
    }

    //поиск по фамилии
    public void get(String surname){
        Set<Map.Entry<Integer, String>> set = phonebook.entrySet();//оборачиваю коллекцию (справочник) для перебора

        System.out.println("\nТелефон(ы) по фамилии " + surname + ":");
        for(Map.Entry<Integer, String> person: set){//перебираю справочник, завёрнутый в set
            if (surname.equalsIgnoreCase(person.getValue()))
                System.out.println(person.getKey());
        }
    }

    //добавление записи в справочник
    public void add(int number, String surname){
        phonebook.put(number, surname);
    }
}
