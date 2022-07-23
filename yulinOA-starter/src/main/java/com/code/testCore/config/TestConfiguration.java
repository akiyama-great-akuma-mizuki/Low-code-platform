package com.code.testCore.config;

import com.code.testCore.config.annotations.EnableAutoTest;
import com.code.testCore.config.packageScan.TestBeanRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName TestConfiguration
 * @Description
 * @Date 2022/7/01 15:44
 * @Autor mjw
 * @Version 1.0
 */
@Configuration
@EnableAutoTest(value = "*")
@Import(TestBeanRegistrar.class)
public class TestConfiguration {
}
