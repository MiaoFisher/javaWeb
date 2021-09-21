package com.Relection;
//用于反射测试的类
public class Person {
    private String name;
    public int id;
    public String nation;
    public Person() {
        System.out.println("Person()");
    }
    private Person(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    private String getNation(String nation){
        System.out.println("国籍为:" + nation);
        return nation;
    }
    private static String getMoney(){
        System.out.println("I have many money");
        return "no money";
    }
}
