package com.linkedin.builder;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

 @Data
//@Builder
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.name=name;
    }
    public static class PersonBuilder {

        private Long id;
        private String name;

        public PersonBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Person build() {
            return new Person(id, name );
        }
    }
}
