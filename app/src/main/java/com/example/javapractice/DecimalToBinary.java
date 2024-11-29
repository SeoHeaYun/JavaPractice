package com.example.javapractice;

import androidx.annotation.NonNull;

/**
 * 십진법 -> 이진법으로 변환하는 코드
 **/
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimalNumber = 468578;
        String binaryNumber = decimalToBinary(decimalNumber);
        System.out.println("10진법 " + decimalNumber + "은 2진법으로 " + binaryNumber + "입니다.");
    }

    // mathods converting decimal to binary
    @NonNull
    public static String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal /= 2;
        }
        return binary.toString();
    }
}

// insert(int index, String str): 지정한 index에 c 추가 append(): 뒤에 추가

