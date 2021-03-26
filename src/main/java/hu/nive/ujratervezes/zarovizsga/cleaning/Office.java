package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Clenable{

    public static int CLEANING_PRICE=100;

    private String address;
    private int area;
    private int numberOfLevels;

    public Office(String address, int area, int numberOfLevels) {
        this.address = address;
        this.area = area;
        this.numberOfLevels = numberOfLevels;
    }

    public int getArea() {
        return area;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    @Override
    public int clean() {
        return area*numberOfLevels*CLEANING_PRICE;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
