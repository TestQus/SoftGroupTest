
public class OOP {

    /*
    Ссылка на мои проекты с использыванием принцыпов ООП: https://github.com/ITGoodBoy/Zoo и https://github.com/ITGoodBoy/OOP
    Есть 4 базовых принципа ООП в java: Инкапсуляция, Наследование, Полиморфизм, Абстракция
    Инкапсуляция - скрытие реализации. Например включение смартфона, мы включаем его нажатием на одну кнопку и нам этого достаточно, всё механизмы включения
    делаются автоматически(операционная система, проверка есть ли пароль, наличие сим карты, загрузка главного меню и тд.).
    В Java это присвоение переменным и методам модификатора private, а также создание public геттеров и сеттеров для переменных.
    В чём преймущество?
    Разберу на примере:
    1)Без использования инкапсуляции
     */

    static class Human
    {
        int age;
        int accountBalance;

        public static void main(String[] args) {
            Human human = new Human();
            human.accountBalance = 89;
            human.age = 19;
            System.out.println("account balance " + human.accountBalance + " age " + human.age);
        }
    }

    /*
    Мы видим класс человек с параметрами возраст и баланс на счету, мы можем задавать им значения, менять их и вызывать,
    но что если человек допустит ошибку и введёт отрезательный возраст или отрицательный баланс?Такого ведь не может быть.
    Значит, нам нужно осуществить проверку. А как это сделать? - Верно, с помощью геттеров и сеттеров.
    2)С использованием инкапсуляции
     */

    static class Human2
    {

        private int accountBalance;
        private int age;

        public static void main(String[] args) {
            Human2 human2 = new Human2();
            human2.setAge(0);
            human2.setAccountBalance(-140);
            System.out.println("account balance " + human2.getAccountBalance() + " age " + human2.getAge());
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 2) {
                System.out.println("Ошибка, возраст низкий или отрицательный");
                throw new IndexOutOfBoundsException();
            }
            if (age > 200)
            {
                System.out.println("Ошибка, возраст слишком высокий");
                throw new IndexOutOfBoundsException();

            }
            this.age = age;
        }

        public int getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(int accountBalance) {
            if (accountBalance < 0)
            {
                System.out.println("Счёт не может быть отрицательным");
                throw new IndexOutOfBoundsException();

            }
            this.accountBalance = accountBalance;
        }
    }

    /*
    код выше выведет ошибку, потому что мы указали возраст равным 0, вот в чём одно из преймуществ инкапсуляции.
    2)Наследование. Наследование это передача свойств родителя дочерним классам и добавление своих особенностей в этих классах:
     */

     class Animal
    {
        //любое животное имеет имя, возраст и пол.
        private String name;
        private int age;
        private boolean gender;

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

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }

    }

    //Но не любое животное умеет летать.
    class Bird extends Animal
    {
        //может летать?(например страусы нет).
        private boolean fly;
        private int flyingHeight;
        private int airspeed;

        public boolean isFly() {
            return fly;
        }

        public void setFly(boolean fly) {
            this.fly = fly;
        }

        public int getFlyingHeight() {
            return flyingHeight;
        }

        public void setFlyingHeight(int flyingHeight) {
            this.flyingHeight = flyingHeight;
        }

        public int getAirspeed() {
            return airspeed;
        }

        public void setAirspeed(int airspeed) {
            this.airspeed = airspeed;
        }
    }

    /*
    Код выше демонстрирует преймущество наследования. Мы создали класс Animal с полями имя возраст и пол а потом наследовались Bird от Animal,
    Все птицы так-же имеют имя возраст и пол, но не все животные являются птицами. Теперь от класса Bird мы можем наследовать таких животных как
    страус, пингвин, воробей, кукушка, сова и тд со своими особенностями и при этом не переписывая громадную кучу кода!!!

    Полиморфизм - различные реализации. Преймущество полиморфизма в том что мы можем использовать один метод, который для методов раных классов будет своим.
    Пример:
     */

    static class Singer
    {
        public void Voice()
        {
            System.out.print("Я пою как ");
        }

        public static void main(String[] args) {
            Singer singer = new AniLorak();
            singer.Voice();
            singer = new Baskov();
            singer.Voice();
            singer = new I();
            singer.Voice();
        }
    }

    static class Baskov extends Singer
    {
        @Override
        public void Voice() {
            super.Voice();
            System.out.print("Басков");
            System.out.println();
        }
    }

    static class AniLorak extends Singer
    {
        @Override
        public void Voice() {
            super.Voice();
            System.out.print("Ани Лорак");
            System.out.println();
        }
    }

   static class I extends Singer
    {
        @Override
        public void Voice() {
            System.out.print("Неумею петь(((");
            System.out.println();
        }
    }
}


/*В примере выше мы видим один и тоже метод Voice, но в то же время каждый класс который унаследован от Singer поёт по своему, это и есть одно из преймуществ полиморфизма.

Абстракция. Мне сложно обьяснить обстракцию, но на примере:
Есть класс собака, я задаю ей значение переменных имя, возраст, вес и методы лаять, сидеть, фас. Все собаки также имеют также запах, скорость бега, цвет шерсти и т.д.
однако для конкретного примера мне достаточно лишь некоторых параметров. Это и есть абстракция.
 */
