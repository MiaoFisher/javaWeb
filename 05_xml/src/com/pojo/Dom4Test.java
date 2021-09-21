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
        //����һ��SAXReader����
        SAXReader saxReader = new SAXReader();
        //����һ��Document����
        try {
            Document document = saxReader.read("src/book.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void Test2() throws DocumentException {
        //����һ��SAXReader����
        SAXReader reader = new SAXReader();
        //���ݵ�ַ��ȡxml �Ӷ�����document����
        Document document = reader.read("src/book.xml");
        //ͨ����Ԫ�ػ�ȡ��ȡbook��ǩ
        Element rootElement = document.getRootElement();
        //�ڿ���̨��ӡ���� ��Ԫ��
        System.out.println(rootElement);
        //�����Ԫ�� ��element() ��elements() �����Ǹ��ݱ�ǩ��������Ԫ��
        Element book = rootElement.element("book");
        //element() ֻ���ȡһ����Ԫ��
        System.out.println(book);
        //elements() ���ȡ������Ԫ��
        List<Element> books = rootElement.elements("book");
        //������ӡ����
        for (Element element :books){
            //asXML() ��xml�ĸ�ʽ��ӡ����
            System.out.println(element.asXML());
            //��ӡ������Ԫ��
            System.out.println(element.element("name").asXML());
            //�Ȼ�ö��� Ȼ���ڴ�ӡ�ı�����
            System.out.println(element.element("name").getText());
            //�����ı�����ȡָ����ǩ���ı�����
            System.out.println(element.elementText("name"));
            //��ȡ���б�ǩ�����ڴ���pojo��
            String sn = element.attributeValue("sn");
            String name = element.elementText("name");
            String price = element.elementText("price");
            String author = element.elementText("author");
            Book newBook = new Book(sn, name, BigDecimal.valueOf(Double.parseDouble(price)), author);
            System.out.println(newBook.toString());
        }
    }
}
