package com.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 将Map中的参数直接注入bean中
     *
     * @param values bean中的参数
     * @param bean   被注入的bean
     * @param <T>    bean的泛型
     * @return 返回一个被注入的bean
     */
    public static <T> T copyParamToBean(Map values, T bean) {
        try {
            //使用BeanUtils工具类将values中的值注入bean中
            BeanUtils.populate(bean, values);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //返回被注入的bean
        return bean;
    }

    /**
     *
     * @param num 需要转换成整形的字符串
     * @param defaultValue 无法转换时返回默认值
     * @return 返回一个由字符串转换而来的整形
     */
    public static int parseInt(String num, int defaultValue) {
        try {
            int i = Integer.parseInt(num);
            return i;
        }catch (Exception e){
            //e.printStackTrace();
        }return defaultValue;
    }


}
