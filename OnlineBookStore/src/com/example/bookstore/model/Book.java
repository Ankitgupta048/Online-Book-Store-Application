package com.example.bookstore.model;
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private String image;
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }
    public String getAuthor(){ return author; }
    public void setAuthor(String author){ this.author = author; }
    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price = price; }
    public String getImage(){ return image; }
    public void setImage(String image){ this.image = image; }
    @Override public String toString(){ return title + " by " + author + " (₹"+price+")"; }
}
