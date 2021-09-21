package com.jsonTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JsonTest {
    /**
     * javaBean和Json的相互转换
     */
    @Test
    public void testJsonJavaBean(){
        Person person = new Person(15, "国哥");
        //创建Gson对象用于相互转换
        Gson gson = new Gson();
        //gson.toString()将Person转换成为json（以字符串的形式）
        String fromJavaBeanToJsonToString = gson.toJson(person);
        System.out.println(fromJavaBeanToJsonToString);

        //fromJson将json字符串转换为javaBean
        Person fromJsonToJavaBean = gson.fromJson(fromJavaBeanToJsonToString, Person.class);
        System.out.println(fromJsonToJavaBean);
    }

    /**
     * json和list的相互转换
     */
    @Test
    public void testJsonList(){
        List<Person> list = new LinkedList<>();
        Person person = new Person(15, "国哥");
        Person person1 = new Person(16, "韩哥");
        list.add(person);
        list.add(person1);
        //创建Gson对象
        Gson gson = new Gson();
        //将集合转换为json字符串对象
        String fromListToJsonString = gson.toJson(list);
        System.out.println(fromListToJsonString);
        //旧版本中需要额外创建一个类去继承TypeToken<>来获得json原来的类型
//        List<Person> list1 = gson.fromJson(fromListToJsonString,new PersonListType().getType());
//        System.out.println(list1.get(1));
        //新版本可以使用如下方法
        List<Person> list1 = gson.fromJson(fromListToJsonString,list.getClass());
        Person person2 = list.get(1);
        System.out.println( person2);
    }
    /**
     * map和json的数据转换
     */
    @Test
    public void testMapJson(){
        HashMap<Integer, Person> integerPersonHashMap = new HashMap<>();
        integerPersonHashMap.put(1,new Person(1,"李华"));
        integerPersonHashMap.put(2,new Person(2,"黄三"));
        //将map集合转换为json类型的字符串
        Gson gson = new Gson();
        String mapJsonString = gson.toJson(integerPersonHashMap);
        System.out.println(mapJsonString);
        System.out.println("=======================");
        //采用匿名内部类的方式去创建TypeToken,避免创建多个类占用内存
        HashMap<Integer, Person> JsonToMap = gson.fromJson(mapJsonString,new TypeToken<HashMap<Integer, Person>>(){}.getType());
        Person person = JsonToMap.get(1);
        System.out.println(person);
    }
}
