package com.spring01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//作为配置类，替代xml配置文件
@Configuration
//扫描包的路径
@ComponentScan(basePackages = {"com.spring01"})
/**
 * 完全注解开发的配置类（替代xml配置）
 * @author:mxs
 */
public class SpringConfig {
}
