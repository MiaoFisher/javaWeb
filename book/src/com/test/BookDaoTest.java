package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import com.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    //测试BookDaoImpl模块
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"mysql","超越",new BigDecimal(9999),20,15,null));
    }

    @Test
    public void deleteBook() {
        Book book = new Book();
        book.setId(18);
        bookDao.deleteBookById(book.getId());
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"oracle","超越",new BigDecimal(9999),20,15,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void testQueryForPageCountByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(10,80);
        System.out.println(integer);
    }
    @Test
    public void testQueryForItemsByPrice(){
        List<Book> books = bookDao.queryForItemsByPrice(0, Page.PAGE_SIZE, 10, 80);
        System.out.println(books);
    }
}