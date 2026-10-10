class Address {
    String street;
    String city;
    String pincode;

    public void setStreet(String st) {
        street = st;
    }

    public void setCity(String cy) {
        city = cy;
    }

    public void setPincode(String pin) {
        pincode = pin;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    Address address;

    public void setFirstName(String fn) {
        firstName = fn;
    }

    public void setLastName(String ln) {

        lastName = ln;
    }

    public void setAge(int a) {
        age = a;
    }

    public void setAddress(Address ad) {
        address = ad;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void display() {
        System.out.println(getFirstName());
        System.out.println(getLastName());
        System.out.println(getAge());
        System.out.println(getAddress().getStreet());
        System.out.println(getAddress().getCity());
        System.out.println(getAddress().getPincode());
    }
}

public class Main {
    public static void main(String[] args) {
        Address a1 = new Address();
        a1.setStreet("Laxminath Colony");
        a1.setCity("Bassi");
        a1.setPincode("312022");

        Person p1 = new Person();
        p1.setFirstName("Keshav");
        p1.setLastName("Somani");
        p1.setAge(21);
        p1.setAddress(a1);

        System.out.println("Person and Address Detail");
        p1.display();
    }
}