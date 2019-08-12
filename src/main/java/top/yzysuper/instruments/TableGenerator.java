package top.yzysuper.instruments;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.yzysuper.instruments.config.TableGeneratorConfiguration;

import java.io.IOException;
import java.io.InputStream;

@Component
public class TableGenerator implements ApplicationRunner {
    @Autowired
    private TableGeneratorConfiguration generatorConfiguration;

    /**
     * 解析Mapper文件，生成创建表的语句
     *
     * @param args
     * @throws Exception
     */
    public void run(ApplicationArguments args) throws Exception {
        parseMapper();
        generateSqls();
    }

    /**
     * 在output路径中生成具体的创建表的语句
     */
    private void generateSqls() {
        // todo
    }

    /**
     * 解析Mapper文件
     * <p>
     * 具体逻辑使用mybatis解析Mapper文件的逻辑
     *
     * @throws IOException
     * @see XMLConfigBuilder#parse()
     */
    private void parseMapper() {
        String resources = buildResources(generatorConfiguration.getInput());
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration configuration = generatorConfiguration.getMybatisConfiguration();
        XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resources, configuration.getSqlFragments());
        mapperParser.parse();
    }

    /**
     * 根据输入的路径创建Resource字符串
     *
     * @param input 文件夹或具体文件
     * @return resource字符串
     */
    private String buildResources(String input) {
        // todo
        return "";
    }
}
