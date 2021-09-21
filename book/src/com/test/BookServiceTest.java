package com.test;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
//BookService测试
//编译全部通过
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"mysql","超越",new BigDecimal(9999),20,15,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(5);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"大学物理","超越",new BigDecimal(9999),20,15,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        books.forEach(System.out::println);
    }
    @Test
    public void testPage(){
        System.out.println(bookService.page(4, Page.PAGE_SIZE));
    }
    @Test
    public void testPageByPrice(){
        Page<Book> bookPage = bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 80);
        System.out.println(bookPage);
    }
}