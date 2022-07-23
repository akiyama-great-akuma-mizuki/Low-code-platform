package com.code.testCore.config.packageScan;

import com.code.testCore.config.annotations.TestModel;
import com.code.testCore.service.TestDataGenerator;
import com.code.testCore.service.TestFileGenerator;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @ClassName TestGeneratorRegistrar
 * @Description
 * @Date 2022/7/01 14:01
 * @Autor mjw
 * @Version 1.0
 */
@Component
public class TestBeanRegistrar implements ImportBeanDefinitionRegistrar,
        ResourceLoaderAware, EnvironmentAware {
    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;
    /**
     * 环境
     */
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    private Map<String, Object> template;

    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    /**
     * 获取base packages
     */
    protected Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        return TestFileGenerator.getBasePackages(importingClassMetadata);
    }

    /**
     * 获取name
     */
    protected String getName(Map<String, Object> attributes) {
        return TestFileGenerator.getName(attributes);
    }

    /**
     * 加载测试类模板文件
     *
     * @return
     */
    private Map<String, Object> getTemplate() throws IOException {
        return TestFileGenerator.getTemplate();

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {

        try {
            // 创建scanner
            ClassPathScanningCandidateComponentProvider scanner = getScanner();
            scanner.setResourceLoader(resourceLoader);

            // 设置扫描器scanner扫描的过滤条件
            AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(TestModel.class);
            scanner.addIncludeFilter(annotationTypeFilter);

            // 获取指定要扫描的basePackages
            Set<String> basePackages = getBasePackages(metadata);

            //拿到配置文件

            template = getTemplate();
            // 遍历每一个basePackages
            for (String basePackage : basePackages) {
                // 通过scanner获取basePackage下的候选类(有标@Model注解的类)
                Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
                // 遍历每一个候选类，如果符合条件就把他生成测试文件和测试数据
                for (BeanDefinition candidateComponent : candidateComponents) {
                    if (candidateComponent instanceof AnnotatedBeanDefinition) {
                        // verify annotated class is an interface
                        AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                        AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(TestModel.class.getCanonicalName());
                        generateTestFile(candidateComponent,template);
                        //generateTestData(candidateComponent);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据实体类模型的字段生成测试文件
     */
    protected void generateTestFile(BeanDefinition candidateComponent, Map<String,Object> template) throws IOException, ClassNotFoundException {
        TestFileGenerator.generateTestFile(candidateComponent,template);

    }

    /**
     * 根据实体类模型的字段生成测试数据
     */
    protected void generateTestData(BeanDefinition candidateComponent) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        TestDataGenerator.generateTestData(candidateComponent);
    }


}
