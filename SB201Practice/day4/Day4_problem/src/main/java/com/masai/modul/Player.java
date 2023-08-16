package com.masai.modul;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    private int Pid;
    private String name;
    private String sportName;
    private int age;

    public Player() {
    }

    public Player(int pid, String name, String sportName, int age) {
        Pid = pid;
        this.name = name;
        this.sportName = sportName;
        this.age = age;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Pid=" + Pid +
                ", name='" + name + '\'' +
                ", sportName='" + sportName + '\'' +
                ", age=" + age +
                '}';
    }
}
