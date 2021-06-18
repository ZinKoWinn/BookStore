package com.zinko.bookstore.models;

import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.models.entities.Book;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.EntityNotFoundException;
import java.util.*;


@Component
@SessionScope
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();
    private long total = 0;
    private long tax = 0;


    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public CartItem getCartItem(BookDto book) {
        for (CartItem item : cartItems) {
            if (item.getBook().getId() == book.getId())
                return item;
        }
        return null;
    }

    public int getItemCount() {
        return cartItems.size();
    }

    public void addToCart(CartItem cartItem) {
        addToCart(cartItem.getBook(), cartItem.getQuantity());
    }

    public void addToCart(BookDto book, int quantity) {
        CartItem cartItem = getCartItem(book);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            book.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            book.setQuantity(cartItem.getQuantity());
            cartItem.setBook(book);
            cartItems.add(cartItem);
        }
    }

    public void updateItem(BookDto book, int quantity) {
        CartItem cartItem = getCartItem(book);
        if (cartItem != null)
            cartItem.setQuantity(quantity);
        else throw new EntityNotFoundException("Cart item not fount");
    }

    public void removeItem(BookDto book) {
        CartItem cartItem = getCartItem(book);
        if (cartItem != null)
            cartItems.remove(cartItem);
        else throw new EntityNotFoundException("Cart item not fount");
    }

    public void clear() {
        cartItems.clear();
        total = 0;
        tax = 0;
    }

    public long getTax() {
        tax = 0;
        for (CartItem cartItem : cartItems) {
            tax += cartItem.getTax();

        }
        return tax;
    }

    public long getTotal() {
        total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getTax() + cartItem.getSubTotal();

        }
        return total;
    }


}


