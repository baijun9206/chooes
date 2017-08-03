package com;

import com.tools.DateUtil;
import org.junit.Test;

import java.util.Date;

/**日期测试
 * Created by 柏世民 on 2017/8/2.
 */
public class DateTest {

    @Test
    public void dateTest(){
        String date = DateUtil.dateToStrLong(new Date(),"yyyy-MM-dd");
        System.out.println(date);
    }
}
