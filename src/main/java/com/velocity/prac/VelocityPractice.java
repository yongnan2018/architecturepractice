package com.velocity.prac;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Arrays;

public class VelocityPractice {
    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "resources");
        velocityEngine.init();

        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("name","yuyongnan");
        context.put("list", Arrays.asList("a","b","c"));
        context.put("flag", "Y");
        Reader reader = new InputStreamReader(VelocityPractice.class.getResourceAsStream("/vm/helloWord.vm")); // 配置好路径
        try {
//            Template template = velocityEngine.getTemplate("helloWord.vm");
            StringWriter stringWriter = new StringWriter();
            Velocity.evaluate(context, stringWriter, "mylogTag", reader);
            String retXML = stringWriter.toString();//模板填充后，输出填充结果到字符串
            stringWriter.close();
            System.out.println("msg is :" + stringWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
