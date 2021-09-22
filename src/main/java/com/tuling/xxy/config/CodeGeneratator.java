package com.tuling.xxy.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiongxy
 * @Description: 代码生成器
 * @Date 2020/6/9 9:17
 */
@Configuration
public class CodeGeneratator {
    /**
     *
     * @Title: main
     * @Description: 生成
     * @param args
     */
   public static void main(String[] args) {
                CodeGeneratator generator = new CodeGeneratator();
                generator.start();
   }
            public void start(){
                AutoGenerator mpg = new AutoGenerator();

                 // 全局配置
                GlobalConfig gc = new GlobalConfig();
                String projectPath = "D:\\git\\interface-test";
                gc.setOutputDir(projectPath + "/src/main/java");
                gc.setAuthor("xiongxy");
                gc.setOpen(false);
                mpg.setGlobalConfig(gc);

                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                gc.setControllerName("%sController");
                gc.setServiceName("%sService");
                gc.setServiceImplName("%sServiceImpl");
                gc.setMapperName("%sMapper");
                gc.setXmlName("%sMapper");
                mpg.setGlobalConfig(gc);

                // 数据源配置
                DataSourceConfig dsc = new DataSourceConfig();
                dsc.setUrl("jdbc:mysql://localhost:3306/interface-test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
                dsc.setDriverName("com.mysql.jdbc.Driver");
                dsc.setUsername("root");
                dsc.setPassword("root");
                mpg.setDataSource(dsc);

                // 策略配置
                StrategyConfig strategy = new StrategyConfig();
                //strategy.setTablePrefix(new String[] { "plus" });
                strategy.setNaming(NamingStrategy.underline_to_camel);
                strategy.setColumnNaming(NamingStrategy.underline_to_camel);
                strategy.setEntityLombokModel(true);
                strategy.setRestControllerStyle(true);
                strategy.setInclude(new String[] {"agency_test"});
                strategy.setSuperServiceClass(null);
                strategy.setSuperServiceImplClass(null);
                strategy.setSuperMapperClass(null);
                mpg.setStrategy(strategy);

                // 包配置
                PackageConfig pc = new PackageConfig();
                pc.setParent("com.tuling.xxy");
                pc.setController("controller");
                pc.setService("service");
                pc.setServiceImpl("service.impl");
                pc.setMapper("mapper");
                pc.setEntity("entity");
                pc.setXml("mapper");
                mpg.setPackageInfo(pc);

                // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
                InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                    this.setMap(map);
                }
            };

                // 调整 xml 生成目录演示
                List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
                focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath +"/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
                }
            });
                    cfg.setFileOutConfigList(focList);
                    mpg.setCfg(cfg);

                    // 关闭默认 xml 生成，调整生成 至 根目录
                    TemplateConfig tc = new TemplateConfig();
                    tc.setXml(null);
                    mpg.setTemplate(tc);

                    // 执行生成
                    mpg.execute();
                }
}
