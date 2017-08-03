/*
 * Copyright (C), 2014-2018,达信财富投资管理（上海）有限公司
 * FileName: DateUtil.java
 * Author:   chenggang
 * Date:     2014年1月13日 下午3:44:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.tools;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 时间工具类
 * 
 * @author v_liuli0101
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class DateUtil {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 构造方法
     */
    private DateUtil() {

    }

    public static Date formatToDate(String dateStr, String format) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat formats = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formats.parse(dateStr);
        } catch (ParseException e) {
            logger.info("formatToDate{}", e.getMessage());
        }
        return date;
    }

    public static Date addMonth(Date date, Integer months) {
        if (date == null || months == null) {
            return null;
        }
        Calendar newDay = Calendar.getInstance();
        newDay.setTime(date);
        newDay.add(Calendar.MONTH, months);
        return newDay.getTime();
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     * 
     * @param strDate 日期字符串
     * @param format 格式化方式
     * @return Date 日期
     */
    public static Date strToDateLong(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     * 
     * @param strDate 日期字符串
     * @return Date 日期
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 将长时间格式时间转换为字符串
     * 
     * @param dateDate 日期
     * @param format 格式化方式
     * @return String 日期字符串
     */
    public static String dateToStrLong(Date dateDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(dateDate);
    }

    /**
     * 取当前时间的字符串，精确到分钟
     * 
     * @return String 取当前时间字符串,格式为“yyyyMMddHHmm”
     */
    public static String getChar12() {
        return DateFormatUtils.format(new Date(), "yyyyMMddHHmm");
    }

    /**
     * 取当前时间的字符串，精确到ss
     * 
     * @return String 取当前时间字符串,格式为“HHmmss”
     */
    public static String getChar6() {
        return DateFormatUtils.format(new Date(), "HHmmss");
    }

    /**
     * 取当前时间
     * 
     * @return Timestamp 取当前时间
     */
    public static Timestamp getNowTimeStamp() {
        Date now = new Date();
        return new Timestamp(now.getTime());
    }

    /**
     * 生成6位数随机数
     * 
     * @return String 6位数随机数
     */
    public static String getSixRandom() {
        // 生成6位数随机数
        int authCode = 0;
        final int size = 6;
        final int randSize = 10;
        String randNum = "";
        for (int i = 0; i < size; i++) {
            Random ran = new Random();
            authCode = (int) (ran.nextInt(randSize));
            randNum = randNum.concat(String.valueOf(authCode));
        }
        logger.info("createSixRandom", authCode);
        return randNum;
    }

    /**
     * 
     * 生成随机字符串 <br>
     * 
     * @param userId 用户ID
     * @return String 随机字符串
     */
    public static String createRandomString(long userId) {
        // 生成随机字符串
        Random rand = new Random();
        final int len = 18;
        final int wSize = 71;
        char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                .toCharArray();
        char[] randBuffer = new char[len];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[rand.nextInt(wSize)];
        }
        // 获得随机字符串
        String randString = new String(randBuffer);
        // Base64转码
        String resultString = new String(Base64.encodeBase64((userId + randString).getBytes()));
        // 返回拼接字符串
        return resultString;
    }

    public static Date dayOffset(Date date, int offset) {
        return offsetDate(date, Calendar.DATE, offset);
    }
    public static Date mouthOffset(Date date, int offset){
        return offsetDate(date, Calendar.MONTH,offset);
    }

    public static Date offsetDate(Date date, int field, int offset) {
        Calendar calendar = convert(date);
        calendar.add(field, offset);
        return calendar.getTime();
    }

    private static Calendar convert(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
