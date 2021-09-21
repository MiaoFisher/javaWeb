package com.i18nTest;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化测试
 * @author ycc
 */
public class I18nTest {
    @Test
    public void testLocale(){
        //获取系统默认的语言
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        System.out.println("============");
        //获取所有语言
        for (Locale availableLocale : Locale.getAvailableLocales()) {
            //System.out.println(availableLocale);
        }
        //更改语言类型(更改为英语/美国)
        Locale locale1 = Locale.US;
        System.out.println(locale1);
    }
    @Test
    public void testPropertiesForI18n(){
        //创建指定的Locate对象
        Locale china = Locale.CHINA;
        //通过指定的basename 和 Locate对象 读取相应的配置文件信息
        ResourceBundle i18n = ResourceBundle.getBundle("i18n",china);
        //使用getString()去获取配置文件的信息
        String username = i18n.getString("username");
        System.out.println(username);

    }
}
