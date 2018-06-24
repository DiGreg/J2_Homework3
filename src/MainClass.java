/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер
телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.

@author Grishin Dmitriy
@version dated 29.12.17
@link null
*/

import java.util.*;//чтобы работать с классами коллекций

public class MainClass {

    public static void main(String[] args) {
    //1 задание
        //Массив слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "cherry", "garlic", "apricot",
                "grape", "apple", "orange", "banana", "cherry", "apple", "orange", "banana", "grape"};

        processArray(words); //анализирую массив слов

    //2 задание
        //Исходный строковый массив из пар "номер фамилия" (его подадим в конструктор телефонной книги)
        String[] peoplePhones = {"435438 Сотников", "459798 Сорокин", "423248 Лукин", "493741 Колодина", "483537 Трубицын",
                "473569 Сотников", "412587 Колодина"};

        Phonebook pb = new Phonebook(peoplePhones); //создаю экземпляр телефонного справочника на основе строкового массива
        System.out.println("\nТелефонный справочник:\n" + pb.getPhonebook());

        pb.get("Колодина"); //ищу номер по фамилии
        pb.add(456789, "Солоделов"); //добавляю запись
        pb.get("Солоделов");
        System.out.println("\nТелефонный справочник:\n" + pb.getPhonebook());
    }

    //Анализ массива слов
    public static void processArray(String[] stringArray){
        String strKey;
        int frequence;
        Map<String, Integer> frequenceTM = new TreeMap<>();//создаю частотную коллекцию

        //Перебираю массив слов
        for(String str: stringArray){
            strKey = str;
            frequence = 0;
            //вложенный FOREACH для записи частотной коллекции
            for(String word: stringArray){
                if (strKey.equals(word)){//если слово совпало, то увеличиваю частоту повторения слова
                    frequence++;
                    frequenceTM.put(strKey, frequence);//записываю частоту
                }
            }
        }

        Set<Map.Entry<String, Integer>> set = frequenceTM.entrySet();//оборачиваю коллекцию для перебора

        System.out.print("Уникальные слова в массиве: ");
        for (Map.Entry<String, Integer> o: set){
            if (o.getValue() == 1){
                System.out.print(o.getKey() + " ");
            }
        }
        System.out.println();

        System.out.println("Частота повторения слов в массиве:\n" + frequenceTM);
    }
}
