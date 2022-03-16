package com.cuixr.boot01helloworld1.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 * 需要通过 @Component + @ConfigurationProperties 或 @EnableConfigurationProperties + @ConfigurationProperties 将该class注册到容器中
 */
//@Component
@Data
@ConfigurationProperties(prefix = "mycar") //
public class Car {
    private String brand;
    private Integer price;
}
