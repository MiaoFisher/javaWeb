package com.dao.impl;

import com.dao.BaseDao;
import com.dao.BookDao;
import com.pojo.Book;
import org.junit.Test;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao{
    @Override
    public void addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) \n" +
                "values(?,?,?,?,?,?)";
        update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public void deleteBookById(Integer id) {
        String sql="delete from t_book where id = ?";
        update(sql,id);

    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(int id) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    /**
     *
     * @return获取总记录数
     */
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    /**
     * 获取指定页面得数据
     * @param begin 起始index
     * @param pageSize 每页显示数据
     * @return
     */
    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }
    @Test
    public void testQueryForPageTotalCount(){
        System.out.println(queryForPageTotalCount());
    }
    @Test
    public void testQueryForItems(){
        List<Book> books = queryForItems(0, 4);
        System.out.println(books);
    }
    //根据价格区间求数据总数
    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }
    //根据价格求
    @Override
    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where price between ? and ? order by price limit ?,?";
        List<Book> books = queryForList(Book.class, sql, min, max, begin, pageSize);
        return books;
    }


}
