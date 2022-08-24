package com.linkedin.builder;


public class BuilderTest {
    public static void main(String[] args) {
        new Person.PersonBuilder().name("Mark").id(1L).build();
    }
}
