package bsu.rfe.java.group7.lab2.Ramnenok.varС1;
import java.util.*;
import java.lang.reflect.Constructor;
public class Main
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        boolean case1, case2;
        case1 = case2 = false;
        int itemsSoFar = 0;
        int cheeseN = 0, sandwichN1 = 0, sandwichN2 = 0, sandwichN3 = 0, appleN1 = 0, appleN2 = 0, appleN3 = 0;

        Apple apple1=new Apple("большое");
        Apple apple2=new Apple("среднее");
        Apple apple3=new Apple("маленькое");
        Sandwich sandwich1=new Sandwich( "сыр", "помидор");
        Sandwich sandwich2=new Sandwich( "сыр", "ветчина");
        Sandwich sandwich3=new Sandwich( "помидор", "ветчина");
        Cheese cheese=new Cheese();

        for (String arg : args) {
            String[] parts = arg.split(("/"));
            try {
                Class myClass = Class.forName("bsu.rfe.java.group7.lab1.Ramnenok.varС1." + parts[0]);
                if (parts.length == 1) {
                    Constructor constructor = myClass.getConstructor();   //получение доступа к конструктору, позволяющему создавать экземпляры класса
                    breakfast[itemsSoFar] = (Food) constructor.newInstance();
                    itemsSoFar++;
                } else if (parts.length == 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1]);
                    itemsSoFar++;
                } else if (parts.length == 3) {
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1], parts[2]);
                    itemsSoFar++;
                }
            } catch (ClassNotFoundException e) {
                switch (parts[0]) {
                    case "-sort":
                        case1 = true;
                        break;
                    case "-calories":
                        case2 = true;
                        break;
                    default:
                        System.out.println("Класс " + parts[0] + " не найден.");
                        break;
                }

            } catch (NoSuchMethodException e)
            {
                System.out.println("Метод класса " + parts[0] + " не был найден.");
            }
        }
        for (int i = 0; i < 20; i++) {
            if (breakfast[i] != null) {
                if (breakfast[i].equals(apple1)) {
                    appleN1++; }
                else if (breakfast[i].equals(apple2)) {
                    appleN2++; }
                else if (breakfast[i].equals(apple3)) {
                    appleN3++; }
                else if (breakfast[i].equals(cheese)) {
                    cheeseN++; }
                else if (breakfast[i].equals(sandwich1)) {
                    sandwichN1++; }
                else if (breakfast[i].equals(sandwich2)) {
                    sandwichN2++; }
                else if (breakfast[i].equals(sandwich3)) {
                    sandwichN3++; }
            } else break;
        }

        System.out.println("Завтрак: ");
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
                System.out.println(" " + item.calculateCalories());
            } else {
                break;
            }
        }

        if (case1) { //случай "ClassNotFoundException", когда мы задаем параметр -sort
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object o1, Object o2)
                {
                    if (o1 == null || ((Food)o1).name.length() > ((Food)o2).name.length())
                        return 1;
                    if (o2 == null || ((Food)o1).name.length() < ((Food)o2).name.length())
                        return -1;
                    else return 0;
                }
            });

            System.out.println("Отсортированный завтрак:");
            for (Food item : breakfast) {
                if (item != null) {
                    item.consume();
                    System.out.println(" " + item.calculateCalories());
                } else {
                    break;
                }
            }
        }
        if (case2)
        {    //случай "ClassNotFoundException", когда мы задаем парметр -calories
            double CaloriesCounter = 0.0;
            for (Food item : breakfast)
            {
                if (item != null) {
                    CaloriesCounter += item.calculateCalories();
                }
                else {
                    break;
                }
            }
            System.out.println("total amount of calories= " + CaloriesCounter + " cal.");
        }

        System.out.println("На завтрак съедено:");
        System.out.println(" маленьких яблок - " + appleN3 + ", средних яблок - " + appleN2 + ", больших яблок - " + appleN1);
        System.out.println(" кусочков сыра - " + cheeseN);
        System.out.println(" бутербродов с сыром и помидором - " + sandwichN1);
        System.out.println(" бутербродов с сыром и ветчиной - " + sandwichN2);
        System.out.println(" бутербродов с помидором и ветчиной - " + sandwichN3);
    }
}

