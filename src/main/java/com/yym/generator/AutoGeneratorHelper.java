package com.yym.generator;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 *  *
 *  * 自动生成映射工具类
 *  *
 *  * @author hubin
 *  *
 *  
 */
public class AutoGeneratorHelper {
    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        final String projectPath = "C:/WorkSpace/springbootdemo";
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/pos?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setDbColumnUnderline(false)// true 字段没有注解，false 字段有注解
                .setInclude("t_user")//修改替换成你需要的表名，多个表名传数组
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setColumnNaming(NamingStrategy.underline_to_camel)// 列名策略
                .setSuperEntityClass("com.yym.springbootdemo.repo.entity.BaseEntity")
                .setSuperEntityColumns("create_time", "update_time")
        ;
        config.setActiveRecord(false)
                .setAuthor("andy.yu")
                .setOutputDir("C:/WorkSpace/springbootdemo/src/main/java/")
                .setFileOverride(true)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setEnableCache(false)
                .setIdType(IdType.AUTO)
                .setKotlin(false)
                .setServiceName("%sService")
        ;

        PackageConfig repoPc = new PackageConfig()
                .setParent("com.yym.springbootdemo")
                .setMapper("repo.mapper")
                .setEntity("repo.entity");

        // 根据我们的项目结构定制 xml service impl controller 目录
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList();
        // xml
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        // service
        focList.add(new FileOutConfig("/templates/service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/yym/springbootdemo/service/" + tableInfo.getEntityName() + "Service.java";
            }
        });
        // serviceImpl
        focList.add(new FileOutConfig("/templates/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/yym/springbootdemo/service/impl/" + tableInfo.getEntityName() + "ServiceImpl.java";
            }
        });

        injectionConfig.setFileOutConfigList(focList);

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(repoPc)
                .setCfg(injectionConfig)
                .setTemplate(new TemplateConfig().setXml(null).setController(null).setService(null).setServiceImpl(null))
                .execute();
    }
}
