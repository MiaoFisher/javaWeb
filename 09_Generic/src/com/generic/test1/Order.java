package com.generic.test1;

import java.util.Iterator;
import java.util.List;

/**
 * @author mxs
 */ //在类中定义泛型
public class Order<T> {
    //属性定义的时候可以使用该泛型
    T type;
    int id;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "type=" + type +
                ", id=" + id +
                '}';
    }
    //第一个<E>是为了确定该类型是泛型参数 而不是其他类
    //后面的两个<E>则是List自带的泛型参数
    //泛型方法可以是static，因为在调用的时候就已经确定了
    public static <E>List<E> getList(List<E> list){
        list.forEach(System.out::println);
        return list;
    }
    //使用通配符
    public static void printList(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
