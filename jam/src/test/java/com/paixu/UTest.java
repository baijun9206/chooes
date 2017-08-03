package com.paixu;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**U形分配排序
 * Created by 柏世民 on 2017/7/26.
 */
public class UTest {

    @Test
    public void uTest(){
        int index = 0;
        //轮回圈数
        int circleNum = 1;
        int userSize = 15;
        int assignDtos = 15;
        while(index < assignDtos){
            System.out.println("-------");
            for (int i = 0;i < userSize;i++){
                //如果圈数大于索引跳出
                if(index >= assignDtos){
                    break;
                }
                int key = i;
                if(circleNum%2==0){
                    key = userSize-i-1;
                }
                System.out.print("催收员"+key);
                System.out.println("第"+index+"单");
                index++;
            }
            circleNum++;
            System.out.println("-------");
        }
    }

    @Test
    public void mapTest(){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("1","你好");
        param.put("2","hello");
        param.put("3","嘿嘿");
        System.out.println(param.toString());

        Iterator iterator = param.entrySet().iterator();

        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
        iterator.remove();
        System.out.println(iterator.hasNext());
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void strTest(){
        String mstatus = "m2";
        Short status = Short.valueOf(mstatus.substring(1));
        System.out.println(status);
    }

    @Test
    public void getNewCaseBatch(){
        String oldCaseBatch = "20170516";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String newCaseBatch = sdf.format(date);
        if(8 != oldCaseBatch.trim().length()){
            System.out.println("");
        }
        System.out.println(date);
        String oldDay = oldCaseBatch.substring(6);
        System.out.println("时间:"+newCaseBatch+oldDay);
    }
}
