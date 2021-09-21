package com.generic.test1;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.util.*;

public class GenericTest {
    @Test
    public void test1(){
        //在List中使用泛型
        List<String> list = new ArrayList<>();
        //此时添加数据就可以避免数据类型混乱的情况
        list.add("String0");
        list.add("String1");
        list.add("String2");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("=====================================");
        //在迭代器中使用泛型
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Map<String,Integer> map = new HashMap<>();
        map.put("hello",123);
        map.put("nice",234);
        map.put("great",345);
        //通过entrySet()可以返回map的set集合，方便迭代
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
    }
    @Test
    public void test3(){
        Order<Integer> order = new Order<>();
        order.setType(15);
        System.out.println(order.toString());

        //子类已经确定泛型，在创建对象的时候就不需要再次确定
        SubOrder order1 = new SubOrder();
        order1.setType("12");

        //子类再继承的时候没有确定泛型，在创建对象的时候就需要去顶泛型
        SubOrder2<Float> subOrder2 = new SubOrder2();
        subOrder2.setType(12.5F);
    }
    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("nice");
        list.add("great");
        List<String> list1 = Order.getList(list);
        //调用含通配符的方法
        System.out.println("==================================");
        Order.printList(list);
    }
}
