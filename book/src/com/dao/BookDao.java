package com.dao;

import com.pojo.Book;

import java.util.List;

//图书模块的Dao接口
public interface BookDao {
    //添加图书
    public void addBook(Book book);
    //删除图书
    public void deleteBookById(Integer id);
    //修改图书
    public void updateBook(Book book);
    //根据图书id查询图书
    public Book queryBookById(int id);
    //获取所有图书列表
    public List<Book> queryBooks();
    //获取总记录数
    Integer queryForPageTotalCount();
    //求当前页面记录数
    List<Book> queryForItems(int begin, int pageSize);
    //根据价格区间数据数
    Integer queryForPageTotalCountByPrice(int min, int max);
    //根据价格求当前页面数据
    List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max);
}
