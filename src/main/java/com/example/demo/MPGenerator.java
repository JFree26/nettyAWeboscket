package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MPGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
        GlobalConfig gl = new GlobalConfig();
        gl.setAuthor("JFREE");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath=" + projectPath);
        gl.setOutputDir("D://code/src/main/java");
        gl.setOpen(false);
        gl.setFileOverride(false);
        gl.setActiveRecord(false);
        gl.setEnableCache(false);
        gl.setBaseColumnList(false);
        gl.setBaseResultMap(true);
        gl.setBaseColumnList(false);
        gl.setMapperName("%sDao");
        gl.setXmlName("%sMapper");
        gl.setServiceName("I%sService");
        gl.setServiceImplName("%sServiceImpl");
        gl.setControllerName("%sController");
        mpg.setGlobalConfig(gl);
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            @Override
//            public DbColumnType processTypeConvert(String fieldType) {
//                System.out.println("转换类型：" + fieldType);
//                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                return super.processTypeConvert(fieldType);
//            }
//
//
//        });

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("jizhongjieneng9-28");
        dsc.setUrl("jdbc:mysql://192.168.1.56:3306/jet_huawei_dev?useSSL=false");
        mpg.setDataSource(dsc);
        //包配置
        PackageConfig pg = new PackageConfig();
        pg.setParent("com.example.demo");
        pg.setEntity("entity");
        pg.setMapper("dao");
        pg.setService("service");
        pg.setXml("mapper");
       // pg.setModuleName("tb");
        mpg.setPackageInfo(pg);


        StrategyConfig sg = new StrategyConfig();
        sg.setTablePrefix(new String[]{"tb_"});//修改为表的前缀
        sg.setNaming(NamingStrategy.underline_to_camel);
        sg.setColumnNaming(NamingStrategy.underline_to_camel);
        sg.setSuperEntityClass("com.example.demo.entity.BaseEntity");
        sg.setInclude(new String[]{"tb_park_parameter"});
        // sg.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // sg.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // sg.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // sg.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // sg.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // sg.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // sg.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // sg.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // sg.setEntityBuilderModel(true);
        mpg.setStrategy(sg);

        mpg.execute();
    }
}
