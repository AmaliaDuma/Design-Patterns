package amalia.labproject.domain;

import java.time.LocalDate;

/**
 *  Builder design pattern
 */
public class Person {
    private String firstName;
    private String lastName;
    private String cnp;
    private Integer age;
    private LocalDate dob;

    public Person(String firstName, String lastName, String cnp, Integer age, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.age = age;
        this.dob = dob;
    }

    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.cnp = builder.cnp;
        this.age = builder.age;
        this.dob = builder.dob;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCnp() {
        return cnp;
    }
    public Integer getAge() {
        return age;
    }
    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "CNP: " + cnp + ", FirstName: " + firstName + ", LastNane: " + lastName + ", Age: " + age
                + ", Date of birth: " + dob;
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private String cnp;
        private Integer age;
        private LocalDate dob;

        public PersonBuilder() {

        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder cnp(String cnp) {
            this.cnp = cnp;
            return this;
        }

        public PersonBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public PersonBuilder dob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public Person build() throws Exception {
            Person person =  new Person(this);
            validatePerson(person);
            return person;
        }

        private void validatePerson(Person person) throws Exception {
            if (!person.firstName.matches("^[a-zA-Z]+")) {
                throw new Exception("Invalid first name");
            }

            if (!person.lastName.matches("^[a-zA-Z]+")) {
                throw new Exception("Invalid first name");
            }
        }
    }
}