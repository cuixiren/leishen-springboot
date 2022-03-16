package com.cuixr.boot01helloworld1.config;

import com.cuixr.boot01helloworld1.bean.Car;
import com.cuixr.boot01helloworld1.bean.Pet;
import com.cuixr.boot01helloworld1.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *   1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认是单实例的
 *   2. 配置类本身也是组件
 *   3. proxyBeanMethods：代理內部注册所所有bean的方法
 *        Full（proxyBeanMethods = true）, 每次调用的都是在容器中注册过的同一对象
 *        Lite（proxyBeanMethods = false） 每一次调用@Bean方法都会产生新对象
 *        组件依赖：
 *        ■ 配置类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
 *        ■ 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式。（如shiro）
 *   4. @Import(User.class,Pet.class) 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名 run.getBeanNameForType
 */
@Import({User.class, Pet.class})
//@ConditionalOnBean(name = "tom") //可放在类上或bean方法上，在@Bean上作用时存在先后顺序（tom在前时user01才生效）。放在类上时此demo有问题，会在注册类內部bean前先进行判断，导致这两个bean都无法成功注册。
@ConditionalOnMissingBean(name = "tom")
@Configuration(proxyBeanMethods = true) //告诉springboot这是一个配置类 == 配置文件
@EnableConfigurationProperties(Car.class) // 1.开启Car配置绑定功能  2.把Car这个组件自动注册到容器中
public class MyConfig {

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
//    @ConditionalOnBean(name = "tom") //当容器中存在tom组件时才会注册user01
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        System.out.println("hehehe");
        return zhangsan;
    }

}
