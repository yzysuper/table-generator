package top.yzysuper.instruments.config;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Getter
@Component
public class TableGeneratorConfiguration implements InitializingBean {
    @Value("${input: }")
    private String input;
    @Value("${output: }")
    private String output;

    private Configuration mybatisConfiguration;

    public void afterPropertiesSet() throws Exception {
        log.info("\n输入路径为：[{}] \n输出路径为：[{}]", input, output);
        if (StringUtils.isBlank(input) || StringUtils.isBlank(output)) {
            throw new RuntimeException("没有指定输入路径和输出路径！");
        }

        mybatisConfiguration = new Configuration();
    }
}
