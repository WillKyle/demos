package com.will.lucifer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok之@Builder
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User2 {
    private int id;
    private String name;
    private String gender;
    private int age;
}
