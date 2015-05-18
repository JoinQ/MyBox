package com.box.mode;

public class RankThing {
    private int grade;
    private int head;
    private String name;
    private int level;
    private int money;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public RankThing(int grade, int head, String name, int level, int money) {
        this.grade = grade;
        this.head = head;
        this.name = name;
        this.level = level;
        this.money = money;
    }

}
