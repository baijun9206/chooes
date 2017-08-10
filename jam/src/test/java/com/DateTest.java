package com;

import com.tools.DateUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**日期测试
 * Created by 柏世民 on 2017/8/2.
 */
public class DateTest {

    @Test
    public void dateTest(){
        String date = DateUtil.dateToStrLong(new Date(),"yyyy-MM-dd");
        System.out.println(date);
    }

    @Test
    public void statusTest(){
        if(1 < 1){
            System.out.println("我");
        }else{
            System.out.println("你");
        }
    }


    @Test
    public void listTest(){
        List<String> list = new ArrayList<String>();
        long t1,t2;
        for(int j = 0; j < 10000000; j++)
        {
            list.add("aaaaaa" + j);
        }
        System.out.println("List first visit method:");
        t1=System.currentTimeMillis();
        for(String tmp:list)
        {
            //System.out.println(tmp);
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 -t1) + "(ms)");
        System.out.println("List second visit method:");

        t1=System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++)
        {
            list.get(i);
            //System.out.println(list.get(i));
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 -t1) + "(ms)");

        System.out.println("List Third visit method:");
        Iterator<String> iter = list.iterator();

        t1=System.currentTimeMillis();
        while(iter.hasNext())
        {
            iter.next();
            //System.out.println(iter.next());
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 -t1) + "(ms)");

        System.out.println("Finished!!!!!!!!");
    }
}
