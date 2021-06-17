package com.zinko.bookstore.models;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.models.entities.Book;

public class CartItem {
    private BookDto book;
    private int quantity;
    private long subTotal;
    private long tax;

    public CartItem() {
    }

    public CartItem(BookDto book) {
        this.book = book;
        this.quantity = 1;
        this.subTotal = book.getPrice();
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getSubTotal() {
        return subTotal = book.getPrice() * quantity;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public long getTax() {
        return getSubTotal() * 3 / 100;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }
}
