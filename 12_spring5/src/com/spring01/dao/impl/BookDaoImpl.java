package com.spring01.dao.impl;

import com.spring01.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
