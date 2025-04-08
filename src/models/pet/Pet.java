package src.models.pet;

import src.models.address.Address;

import java.util.Scanner;

public class Pet {
    private String name;
    private Type type;
    private Sex sex;
    private Address address;
    private int age;
    private double weight;
    private String breed;

    public Pet(String name, Type type, Sex sex, Address address, int age, double weight, String breed) {
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", sex=" + sex +
                ", address=" + address +
                ", age=" + age +
                ", weight=" + weight +
                ", breed='" + breed + '\'' +
                '}';
    }
}
