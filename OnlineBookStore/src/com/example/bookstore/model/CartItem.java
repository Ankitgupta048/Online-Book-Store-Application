package com.example.bookstore.model;
public class CartItem {
    private Book book;
    private int qty;
    public CartItem(Book b,int q){ this.book=b; this.qty=q; }
    public Book getBook(){ return book; }
    public int getQty(){ return qty; }
    public void setQty(int q){ this.qty=q; }
    public double getTotal(){ return book.getPrice()*qty; }
}
