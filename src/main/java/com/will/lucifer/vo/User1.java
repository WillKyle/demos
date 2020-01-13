package com.will.lucifer.vo;

import lombok.Data;

/**
 * 自实现建造者模式
 */
@Data
public class User1 {
    private int id;
    private String name;
    private String gender;
    private int age;

    public static class User1Builder{
        private User1 target;

        public User1Builder(){
            target = new User1();
        }
        public User1Builder(User1 user){
            target = new User1();
            target.id = user.id;
            target.name = user.name;
            target.gender = user.gender;
            target.age = user.age;
        }
        public User1Builder id(int id){
            target.id=id;
            return this;
        }
        public User1Builder name(String name){
            target.name=name;
            return this;
        }
        public User1Builder gender(String gender){
            target.gender=gender;
            return this;
        }
        public User1Builder age(int age){
            target.age=age;
            return this;
        }
        public User1 build(){
            return target;
        }
    }
}
