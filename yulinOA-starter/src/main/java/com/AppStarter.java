package com;

import cc.eamon.open.flow.spring.scanner.FlowScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.horsecoder.organization.sys.domain","com.horsecoder.organization.sys.domain","com.horsecoder.organization.sys.domain",})
@EnableDiscoveryClient
@EnableCaching
@ServletComponentScan("com.horsecoder.yulinOA")
@EnableTransactionManagement
@MapperScan(value = {
        "com.horsecoder.yulinOA.*.datainterface"
})
@EnableSwagger2
@FlowScan(flowPackages = {"com.horsecoder.yulinOA.flow"})
public class AppStarter {

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

}