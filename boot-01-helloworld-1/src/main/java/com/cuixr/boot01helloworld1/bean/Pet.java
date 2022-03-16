package com.cuixr.boot01helloworld1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @FileName: Pet
 * @Author: cuixr
 * @Date: 2022/2/10 16:08
 * @Description:
 */
@Data
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //全参构造器
public class Pet {
    private String pet;
//    public Pet() {
//    }
//    public Pet(String pet) {
//    }
}
