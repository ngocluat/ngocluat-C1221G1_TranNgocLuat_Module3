package models;

public class Customer {
    private String name;
    String dayOfBirth;
    String address;
    String img;

    public Customer(String name, String dayOfBirth, String address, String img) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.img = img;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ngaySinh='" + dayOfBirth + '\'' +
                ", diaChi='" + address + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
