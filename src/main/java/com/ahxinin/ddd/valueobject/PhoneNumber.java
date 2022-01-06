package com.ahxinin.ddd.valueobject;

import java.util.Arrays;

/**
 * @author : hexin
 * @description: 电话号码valueobject
 * @date : 2022-01-05
 */
public class PhoneNumber {

    private final String number;

    public String getNumber(){
        return number;
    }

    public PhoneNumber(String number){
        if (number == null){
            throw new RuntimeException("number不能为空");
        }else if (!isValid(number)){
            throw new RuntimeException("number格式错误");
        }
        this.number = number;
    }

    public String getAreaCode(){
        for (int i=0; i<number.length(); i++){
            String prefix = number.substring(0, i);
            if (isAreaCode(prefix)){
                return prefix;
            }
        }
        return null;
    }

    private static boolean isAreaCode(String prefix){
        String[] areas = new String[]{"0571"};
        return Arrays.asList(areas).contains(prefix);
    }

    private static boolean isValid(String number){
        String pattern = "^0?[1-9]{2,3}-?\\\\d{8}$";
        return number.matches(pattern);
    }
}
