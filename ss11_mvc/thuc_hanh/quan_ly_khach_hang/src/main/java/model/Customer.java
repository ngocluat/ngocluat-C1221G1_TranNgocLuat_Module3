package model;

public class Customer {
    private int id;
    private String name;
    private String mail;
    private String address;

    public Customer(int id, String name, String mail, String address) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.address = address;
    }

    public Customer() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
