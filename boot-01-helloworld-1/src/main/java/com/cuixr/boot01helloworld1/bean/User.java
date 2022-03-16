package com.cuixr.boot01helloworld1.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @FileName: User
 * @Author: cuixr
 * @Date: 2022/2/10 16:05
 * @Description:
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
    private Pet pet;

//    public User() {
//    }
    public User(String name, int age) {
    }
}
