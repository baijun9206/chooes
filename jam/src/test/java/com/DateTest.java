package com;

import com.jam.tools.DateUtil;
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
    public void dateTest() {
        String date = DateUtil.dateToStrLong(new Date(), "yyyy-MM-dd");
        System.out.println(date);
    }

    @Test
    public void statusTest() {
        if (1 < 1) {
            System.out.println("我");
        } else {
            System.out.println("你");
        }
    }


    @Test
    public void listTest() {
        List<String> list = new ArrayList<String>();
        long t1, t2;
        for (int j = 0; j < 10000000; j++) {
            list.add("aaaaaa" + j);
        }
        System.out.println("List first visit method:");
        t1 = System.currentTimeMillis();
        for (String tmp : list) {
            //System.out.println(tmp);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 - t1) + "(ms)");
        System.out.println("List second visit method:");

        t1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            //System.out.println(list.get(i));
        }
        t2 = System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 - t1) + "(ms)");

        System.out.println("List Third visit method:");
        Iterator<String> iter = list.iterator();

        t1 = System.currentTimeMillis();
        while (iter.hasNext()) {
            iter.next();
            //System.out.println(iter.next());
        }
        t2 = System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 - t1) + "(ms)");

        System.out.println("Finished!!!!!!!!");
    }


    @Test
    public void  testList() {
        int num = 0;
        final int size = 18;//数据长度
        final int nThreads = 8;//线程数
        for (int i = 0; i < nThreads; i++) {
            final int j = i;
            int condition;
            int remainder = size % nThreads;
            int divisor = size / nThreads;
            if(0 != remainder && divisor != 0 ) {
                condition = (divisor + 1);
            }else if(divisor == 0){
                condition = 1;
            }else{
                condition = divisor;
            }
            System.out.print("N ="+ condition * j +"||");
            System.out.println("N < "+condition * (j+1)+"");
            for (int n = condition * j  ; n < condition * (j+1); n++) {
                if ( n == size){
                    break;
                }
                num++;
                System.out.println("业务:第"+n+"次");
            }
        }
        System.out.println("操作次数:"+num);
    }


    @Test
    public void  testList1() {
        int num = 0;
        final int size =  9;//数据长度
        final int nThreads = 8;//线程数
        for (int i = 0; i < nThreads; i++) {
            final int j = i;
            for (int n = size/nThreads * j  ; n <= size/nThreads * (j+1); n++) {
                num++;
                System.out.println("业务:第"+n+"次");
            }
        }
        System.out.println("操作次数:"+num);
    }

}

