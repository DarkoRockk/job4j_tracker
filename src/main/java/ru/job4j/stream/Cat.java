package ru.job4j.stream;

public class Cat {
    private String name;
    private byte age;
    private String gender;
    private String color;
    private String lovelyFood;
    private String ownerName;
    private String ownerSurname;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", lovelyFood='" + lovelyFood + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                '}';
    }

    static class Builder {
        private String name;
        private byte age;
        private String gender;
        private String color;
        private String lovelyFood;
        private String ownerName;
        private String ownerSurname;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildLovelyFood(String lovelyFood) {
            this.lovelyFood = lovelyFood;
            return this;
        }

        Builder buildOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        Builder buildOwnerSurname(String ownerSurname) {
            this.ownerSurname = ownerSurname;
            return this;
        }

        Cat build() {
            Cat cat = new Cat();
            cat.name = name;
            cat.age = age;
            cat.gender = gender;
            cat.color = color;
            cat.lovelyFood = lovelyFood;
            cat.ownerName = ownerName;
            cat.ownerSurname = ownerSurname;
            return cat;
        }

    }

    public static void main(String[] args) {
        Cat cat = new Builder().buildName("Барсик")
                .buildAge((byte) 3)
                .buildColor("рыжий")
                .build();
        System.out.println(cat);
    }
}
