package com.rw.finance.common.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author huanghongfei
 * @file DateUtils.java
 * @date 2017年12月11日 下午4:45:45
 * @declaration
 */
public class DateUtils {

    /**
     * 时间戳转日期
     *
     * @param timestamp
     * @return date
     */
    public static Date timestampToDate(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(timestamp);
        Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 获取日期时间字符串
     *
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 获取日期字符串
     *
     * @param date
     * @return yyyy-MM-dd
     */
    public static String getDateStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 获取月份字符串
     *
     * @param date
     * @return yyyy-mm
     */
    public static String getMonthStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    /**
     * 根据时间字符串获取时间
     *
     * @param time 1992-10-10 00:00:00
     * @return date
     */
    public static Date getTimeByStr(String time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /***
     *
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss 
     * @return
     */
    public static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /*** 
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014" 
     * @param date  : 时间点 
     * @return
     */
    public static String getCron(java.util.Date date) {
        String dateFormat = "ss mm HH dd MM ?";
        return formatDateByPattern(date, dateFormat);
    } 
	/*public static void main(String[] orgs){
		System.out.println(DateUtils.getCron(new Date()));
	}*/

    /**
     * 取得日期集合
     *
     * @param type
     * @return
     */
    public static List<String> getDateList(String type) {
        // 当前日历
        Calendar cal = Calendar.getInstance();

        // 日期集合
        List<String> date = new ArrayList();
        switch (type) {
            case "near":
                // 第一天
                cal.add(Calendar.DAY_OF_MONTH, -6);
                date.add(DateUtils.getDateStr(cal.getTime()));
                for (int j = 1; j < 7; j++) {
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    date.add(DateUtils.getDateStr(cal.getTime()));
                }
                break;
            case "week":
                // 相差天数
                int day = 0;
                if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
                    day = -6;
                } else {
                    day = 2 - cal.get(Calendar.DAY_OF_WEEK);
                }

                cal.add(Calendar.DAY_OF_WEEK, day);
                date.add(DateUtils.getDateStr(cal.getTime()));
                for (int j = 1; j < 7; j++) {
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    date.add(DateUtils.getDateStr(cal.getTime()));
                }
                break;
            case "month":
                // 当月最初一天
                cal.add(Calendar.MONTH, 0);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                date.add(DateUtils.getDateStr(cal.getTime()));

                // 当月最后一天
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                for (int j = 1; j < calendar.get(Calendar.DAY_OF_MONTH); j++) {
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    String start = DateUtils.getDateStr(cal.getTime());
                    date.add(start);

                    // 跳出循环
                    if (start.equals(DateUtils.getDateStr(calendar.getTime()))) {
                        break;
                    }
                }
                break;
        }

        return date;
    }

    /**
     * 取得日期集合
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> getDateList(String start, String end) {
        // 日期集合
        List<String> date = new ArrayList();

        // 开始日期
        Date date1 = DateUtils.getTimeByStr(start + " 00:00:00");
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(date1);

        // 结束日期
        Date date2 = DateUtils.getTimeByStr(end + " 00:00:00");
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(date2);

        // 遍历增加
        date.add(start);
        Integer days = ((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
        if (days > 1) {
            for (int j = 0; j < days; j++) {
                // 累加一天
                calStart.add(Calendar.DAY_OF_MONTH, 1);
                String now = DateUtils.getDateStr(calStart.getTime());
                date.add(now);

                // 跳出循环
                if (now.equals(DateUtils.getDateStr(calEnd.getTime()))) {
                    break;
                }
            }
        }

        return date;
    }
}
