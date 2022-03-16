package com.cuixr.boot01helloworld1.controller;

import com.cuixr.boot01helloworld1.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName: HelloController
 * @Author: cuixr
 * @Date: 2022/2/10 16:11
 * @Description:
 */
//@Jrebel 付费重加载
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        System.out.println(car);
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01(@RequestParam("name") String name){ //devtools ctrl+f9
        log.info("请求进来了");
        return "你好，cccccccc"+name;
    }
}
