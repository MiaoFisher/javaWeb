package com.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class Dom4Test {
    @Test
    public void Test1(){
        //创建一个SAXReader对象
        SAXReader saxReader = new SAXReader();
        //创建一个Document对象
        try {
            Document document = saxReader.read("src/book.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Test2() throws DocumentException {
        //创建一个SAXReader对象
        SAXReader reader = new SAXReader();
        //根据地址获取xml 从而创建document对象
        Document document = reader.read("src/book.xml");
        //通过根元素获取获取book标签
        Element rootElement = document.getRootElement();
        //在控制台打印出来 根元素
        System.out.println(rootElement);
        //获得子元素 用element() 和elements() ，都是根据标签名返回子元素
        Element book = rootElement.element("book");
        //element() 只会获取一个子元素
        System.out.println(book);
        //elements() 会获取所有子元素
        List<Element> books = rootElement.elements("book");
        //遍历打印出来
        for (Element element :books){
            //asXML() 用xml的格式打印出来
            System.out.println(element.asXML());
            //打印出其他元素
            System.out.println(element.element("name").asXML());
            //先获得对象 然后在打印文本内容
            System.out.println(element.element("name").getText());
            //根据文本名获取指定标签的文本内容
            System.out.println(element.elementText("name"));
            //获取所有标签名用于创建pojo类
            String sn = element.attributeValue("sn");
            String name = element.elementText("name");
            String price = element.elementText("price");
            String author = element.elementText("author");
            Book newBook = new Book(sn, name, BigDecimal.valueOf(Double.parseDouble(price)), author);
            System.out.println(newBook.toString());
        }
    }
}
