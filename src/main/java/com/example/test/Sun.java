package com.example.test;

public class Sun extends Father {

    public void say(){
        System.out.println("aaa");
    }

    Sun(int money,String name,int age){
        super(money,name,age);
    }
    Sun(){

    }

    static void sayt(Father father){
        father.say();
    }
    public static void main(String[] args) {
        Father father = new Father(100,"father",10);
        //father.say();
        Sun sun = new Sun(1,"son",1);
        System.out.println(sun.toString());


    }
}
