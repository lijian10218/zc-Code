package com.lijian.home;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Description
 * @Date:2020-12-24
 * @Author:lijian
 **/
public class Test {
    public static void main(String[] args) {
        BigDecimal result = new Test().calculate("250000","268","4.9");
        System.out.println("result:"+result);
//        BigDecimal ss = new BigDecimal("3532.9565");
//        BigDecimal result = ss.setScale(0,BigDecimal.ROUND_DOWN);
//        String strResult = result.toString();
//        System.out.println("strResult::"+strResult);

    }
    public BigDecimal calculate(String amount,String days,String yearRatio) {
        Double amt;
        Double dLimit;
        Double drate;
        Double dIntr = null;
        Double yearDays = null;
        String instrValue = "";

        amt = Double.valueOf(amount);
        dLimit = Double.valueOf(days);
        drate = Double.valueOf(yearRatio);
        yearDays = Double.valueOf("360");
        Double aaa = drate/yearDays/100;
        dIntr = amt*dLimit*aaa;
        DecimalFormat dFmt = new DecimalFormat("##0.00");
        dFmt.setRoundingMode(RoundingMode.DOWN);
        instrValue = dFmt.format(dIntr);
        return new BigDecimal(instrValue);

    }
}
