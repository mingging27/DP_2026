package hw.ch01;

public class Book {
    private String name;
    private String genre; // 장르
    private int year; // 출판연도
    private double price; // 가격

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String genre, int year, double price) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    // getter 메서드 추가
    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }   

    public double getPrice() {
        return price;
    }   
}
