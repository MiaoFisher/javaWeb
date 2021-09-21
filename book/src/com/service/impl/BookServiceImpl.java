package com.service.impl;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    //创建BookDao类
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        //创建page对象
        Page<Book> page = new Page<>();
        //设置每一页显示数据量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        int pageTotal = pageTotalCount / pageSize;
        //如果不能刚好除整数
        if (pageTotalCount % pageSize > 0) {
            //页码数增加1
            pageTotal++;
        }
        //这是总页码数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);
        //求当前页码数据开始的index
        //公式为 index = (当前页码 - 1) * 每页显示数据量
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页面数据
        List<Book> items = bookDao.queryForItems(begin, pageSize);
        //将当前页面数据保存到page对象中
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        //创建page对象
        Page<Book> page = new Page<>();
        //设置每一页显示数据量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        int pageTotal = pageTotalCount / pageSize;
        //如果不能刚好除整数
        if (pageTotalCount % pageSize > 0) {
            //页码数增加1
            pageTotal++;
        }
        //这是总页码数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);
        //求当前页码数据开始的index
        //公式为 index = (当前页码 - 1) * 每页显示数据量
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页面数据
        List<Book> items = bookDao.queryForItemsByPrice(begin, pageSize,min,max);
        //将当前页面数据保存到page对象中
        page.setItems(items);
        return page;
    }
}
