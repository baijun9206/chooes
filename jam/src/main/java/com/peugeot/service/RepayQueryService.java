package com.peugeot.service;

/**
 * Created by dx0001 on 2017/8/3.
 */
public class RepayQueryService {


    public static void main(String[] args) {
        RepayQueryService repayQueryService = new RepayQueryService();
        String str = repayQueryService.queryRepayInfo();
        System.out.println(str);
    }


    public String queryRepayInfo() {

        for (int i = 0; i <= 5; i++) {
            System.out.println("*****第"+i+"条*****");
            convert(i);
        }
        return "ok";
    }



    public void convert(int num){
        if(num%2 == 0){
            return;
        }
        System.out.println(num);
    }
}
