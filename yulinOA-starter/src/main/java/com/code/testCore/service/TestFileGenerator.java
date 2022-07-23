package com.code.testCore.service;

import com.code.testCore.config.annotations.EnableAutoTest;
import com.code.testCore.config.annotations.TestField;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import javax.jws.WebParam;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
/**
 * @ClassName TestFileGenerator
 * @Description
 * @Date 2022/7/11 15:06
 * @Autor mjw
 * @Version 1.0
 */

public class TestFileGenerator {

    private static String templatePath = "template/mockitoTemplate.json";

    /**
     * 获取base packages
     */
    public static Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        // 获取到@EnableAutoTest注解所有属性
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableAutoTest.class.getCanonicalName());
        Set<String> basePackages = new HashSet<>();
        assert attributes != null;
        // value 属性是否有配置值，如果有则添加
        basePackages.add(attributes.get("value").toString());


        //那么这里就默认使用当前项目启动类所在的包为basePackages
        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }

        return basePackages;
    }


    /**
     * 获取name
     */
    public static String getName(Map<String, Object> attributes) {
        String name = (String) attributes.get("name");
        if (!StringUtils.hasText(name)) {
            name = (String) attributes.get("value");
        }
        return name;
    }

    /**
     * 加载测试类模板文件
     *
     * @return
     */
    public static Map<String, Object> getTemplate() throws IOException {
        Resource resource = new ClassPathResource(templatePath);
        Map<String, Object> res = null;
        InputStreamReader isr = new InputStreamReader(resource.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        String tempString = null;
        StringBuilder jsonBuilder = new StringBuilder();
        while ((tempString = reader.readLine()) != null) {
            //数据获取
            jsonBuilder.append(tempString);
        }
        reader.close();
        ObjectMapper objectMapper = new ObjectMapper();
        res = objectMapper.readValue(jsonBuilder.toString(), Map.class);
        return res;

    }
    /**
     * 根据实体类模型的字段生成测试文件
     */
    public static void generateTestFile(BeanDefinition candidateComponent, Map<String,Object> template) {

        try {
            //反射拿到类名和字段
            Class modelClass = null;
            modelClass = Class.forName(candidateComponent.getBeanClassName());
            String name = modelClass.getSimpleName();

            Field[] fields = modelClass.getDeclaredFields();

            String fileName = System.getProperty("user.dir") + "/" + "yulinOA-starter" + "/src/test/java/" + template.get("package").toString().replaceAll("\\.", "/") + "/" + name + "test.java";
            System.out.println(fileName);
            File file = new File(fileName);
            if (file.exists()) {
                //不存在测试文件则创建
                file.delete();
            }
            file.createNewFile();
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            BufferedWriter bfw = new BufferedWriter(osw);
            //生成类定义
            bfw.write("package " + template.get("package").toString() + ";");
            bfw.newLine();
            ArrayList<Object> deps = (ArrayList<Object>) template.get("dependencies");
            for (Object dep : deps) {
                //System.out.println(dep.toString());
                bfw.write(dep.toString() + ";");
                bfw.newLine();
            }
            ArrayList<Object> annos = (ArrayList<Object>) template.get("annotations");
            for (Object anno : annos) {
                bfw.write(anno.toString());
                bfw.newLine();
            }
            bfw.write(template.get("access qualifier").toString() + " ");
            bfw.write("class " + name+"test" + " {");
            bfw.newLine();
            //生成测试方法
            List<TestField> testFields = new ArrayList<>();
            for (Field field : fields) {
                TestField testField = field.getAnnotation(TestField.class);
                testFields.add(testField);
            }
            generateTestMethods(bfw, modelClass, testFields.toArray(new TestField[0]), template);

            bfw.newLine();
            bfw.write("}");
            bfw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * 生成测试方法
     */
    public static void generateTestMethods(BufferedWriter bfw , Class ModelClass, TestField[] testFields, Map<String,Object> template) throws IOException {
        generateAttributes(bfw, ModelClass, testFields, template);
        generateFunction(bfw, ModelClass,testFields,template);
    }
    /*
        生成mock
     */
    public static void generateAttributes(BufferedWriter bfw , Class ModelClass, TestField[] testFields, Map<String,Object> template) throws IOException {
        //生成Mock
        String name = ModelClass.getSimpleName();
        ArrayList<Map<String,Object>> Mocks = (ArrayList<Map<String,Object>>)template.get("mocks");
        for(Map<String,Object> map: Mocks){
            bfw.write("\t");
            bfw.write("@Mock");
            bfw.newLine();
            bfw.write("\t");
            bfw.write(map.get("access qualifier").toString() + " "+ name+map.get("class")+" " +name.toLowerCase()+map.get("name")+";");
            bfw.newLine();
            bfw.newLine();
        }
        //生成InjectMocks
        ArrayList<Map<String,Object>> InjectMocks = (ArrayList<Map<String,Object>>)template.get("injectmocks");
        for(Map<String,Object> map: InjectMocks){
            bfw.write("\t");
            bfw.write("@InjectMocks");
            bfw.newLine();
            bfw.write("\t");
            bfw.write(map.get("access qualifier").toString() + " "+ name+map.get("class")+" " +name.toLowerCase()+map.get("name")+";");
            bfw.newLine();
            bfw.newLine();
        }
        //生成其他attr
        ArrayList<Map<String,Object>> Attrs = (ArrayList<Map<String,Object>>)template.get("attributes");
        for(Map<String,Object> map: Attrs){
            bfw.write("\t");
            bfw.write(map.get("access qualifier").toString() + " "+ map.get("class")+" " +map.get("name")+";");
            bfw.newLine();
            bfw.newLine();
        }
    }

    public static void generateFunction(BufferedWriter bfw , Class ModelClass, TestField[] testFields, Map<String,Object> template) throws IOException{
        String name = ModelClass.getSimpleName();
        ArrayList<Map<String,Object>> Methods = (ArrayList<Map<String,Object>>)template.get("methods");
        for(Map<String, Object> method :Methods){
            bfw.newLine();
            bfw.write("\t");
            bfw.write(method.get("annotations").toString());
            bfw.newLine();
            bfw.write("\t");
            bfw.write(method.get("name").toString());
            bfw.newLine();
            bfw.write("\t{");
            bfw.newLine();
            bfw.write("\t\t");
            String content = method.get("function").toString();
            content = content.replaceAll("#Object#",name);
            content = content.replaceAll("#object#",name.toLowerCase());
            bfw.write(content);
            bfw.newLine();
            bfw.write("\t}\n");
        }

    }
}
