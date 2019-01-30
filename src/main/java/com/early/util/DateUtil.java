package com.early.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	public static final String DATE_FORMAT_ORCL = "yyyy-MM-dd HH:mm:ss.S";
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_MINI = "yyyyMMdd";
	public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
	public static final String DATE_FORMAT_FULL_MINI = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_FULL_MINI_NO_SECONDS="yyyyMMddHHmm";
	public static final String TIME_FORMAT_MINI ="HH:mm:ss";
	public static final String TIME_FORMAT = "HH:mm";
	
	public static final int EXPIER_TIME = 3;//订单单位时间内不能够重复提交
	
	public static final String DATE_FORMAT_DATE_OHTER = "yyyy.MM.dd";
	
	private static final int FIRST_DAY = Calendar.MONDAY;
	
//	private static final Logger log = Logger.getLogger("DataUtil");
	
	public static final String[] hoursArray = {"00","01","02","03","04","05","06","07","08","09","10",
		"11","12","13","14","15","16","17","18","19","20","21","22","23"};
	
	private DateUtil(){
		
	}
	
	public static int daysBetween(Date date1, Date date2) throws ParseException {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // 同一年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
				{
					timeDistance += 366;
				} else // 不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else // 不同年
		{
			return day2 - day1;
		}
	}  
	  
	//判断选择的日期是否是本周 
	public static boolean isThisWeek(String time)  {  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);  
        try {
			calendar.setTime(format.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);  
        if(paramWeek==currentWeek){  
           return true;  
        }  
        return false;  
    } 

	public static boolean isToday(String time) throws ParseException  
    {  
	   Date date = parseDate(time,"yyyy-MM-dd");
       return isThisTime(date.getTime(),"yyyy-MM-dd");  
    }  
    //判断选择的日期是否是本月  
    public static boolean isThisMonth(String time) throws ParseException  
    {  
    	 Date date = parseDate(time,"yyyy-MM-dd");
         return isThisTime(date.getTime(),"yyyy-MM");  
    }  
    private static boolean isThisTime(long time,String pattern) {  
        Date date = new Date(time);  
         SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
         String param = sdf.format(date);//参数时间  
         String now = sdf.format(new Date());//当前时间  
         if(param.equals(now)){  
           return true;  
         }  
         return false;  
    }  
    
	public static Boolean isSameDay(Date date,Date date1){
		Boolean flag = false;
		String dateString =  new SimpleDateFormat("yyyy-MM-dd").format(date);
		String date1String =  new SimpleDateFormat("yyyy-MM-dd").format(date1);
		if(dateString.equals(date1String)){
			flag = true;
		}
		return flag;
	}
	
	public static String formatCombineDate(Date startDate,Date endDate){
		if(startDate==null || endDate==null){
			return null;
		}
		String date ="";
		try {
			date = formatDate(startDate,"yyyy-MM-dd HH:mm ")+"-"+formatDate(endDate,"HH:mm");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return date;
	}
	/**
	 * 将一个表示日期的字符串按照格式化字符串格式化为日期.
	 * 
	 * @param date 一个表示日期的字符串.
	 * @param fmt 日期的格式化字符串.
	 * @return 返回一个日期对象.
	 * @throws ParseException 如果格式化过程中发生错误.
	 */
	public static Date parseDate(String date,String fmt) throws ParseException {
		return new SimpleDateFormat(fmt).parse(date);
	}
	
	/**
	 * 将一个日期类型的对象按照指定的格式格式化为一个字符串.
	 * 
	 * @param date 一个日期对象.
	 * @param fmt 日期的格式化字符串.
	 * @return 一个日期字符串.
	 * @throws ParseException 如果格式化过程中发生错误.
	 */
	public static String formatDate(Date date,String fmt) throws ParseException {
		return new SimpleDateFormat(fmt).format(date);
	}
	
	/**
	 * 将一个日期字符串按照sourceFmt转换成日期，并且按照targetFmt，再次转换成一个字符串.
	 * 
	 * @param date 一个表示日期的字符串.
	 * @param sourceFmt 源日期格式化字符串.
	 * @param targetFmt 目标日期格式化字符串.
	 * @return 一个日期字符串.
	 * @throws ParseException 如果格式化过程中发生错误.
	 */
	public static String formatDate(String date,String sourceFmt,String targetFmt) throws ParseException {
		return new SimpleDateFormat(targetFmt).format(new SimpleDateFormat(sourceFmt).parse(date));
	}
	
	/**
	 *  获取一个日期当天的最大时间，并仍以日期的数据类型返回比如传入2013-6-26 07:20:32
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getDateForMaxtime(Date date){
		String formatDate;
		try {
			formatDate = formatDate(date,DATE_FORMAT_DATE);
			return parseDate(formatDate+"  23:59:59",DATE_FORMAT_FULL);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	public static Date getDateForMintime(Date date){
		String formatDate;
		try {
			formatDate = formatDate(date,DATE_FORMAT_DATE);
			return parseDate(formatDate+"  00:00:00",DATE_FORMAT_FULL);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getDate(String fmt){
		return new SimpleDateFormat(fmt).format(Calendar.getInstance().getTime());
	}
	
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }  
  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
    
	/**
	 * 分秒转换
	 * @param second
	 * @return
	 */
	public static String changetime(Integer second){
		 int h = 0;
		 int d = 0;
		 int s = 0;
		 
		 String hh="";
		 String dd="";
		 String ss="";
		 
		 int temp = second%3600;
		       if(second>3600){
		         h= second/3600;
		              if(temp!=0){
		         if(temp>60){
		         d = temp/60;
		      if(temp%60!=0){
		         s = temp%60;
		      }
		      }else{
		         s = temp;
		      }
		     }
		    }else{
		        d = second/60;
		     if(second%60!=0){
		        s = second%60;
		     }
		    }
		       
		    if(h<10){
		    	hh="0"+h;
		    }else{
		    	hh=String.valueOf(h);
		    }
		    if(d<10){
		    	dd="0"+d;
		    }else{
		    	dd = String.valueOf(d);
		    }
		    if(s<10){
		    	ss = "0"+s;
		    }else{
		    	ss = String.valueOf(s);
		    }
		   return hh+":"+dd+":"+ss;
	}
	
	 /**
     * 判断当前日期是星期几
     * 
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
	 public static String dayForWeekByDate(Date pTime) throws Exception {
		  Calendar c = Calendar.getInstance();
		  c.setTime(pTime);
		  String week="";
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
			   dayForWeek = 7;
			   week="周日";
		  }else{
			   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
			   if(dayForWeek==1){
				  week="周一"; 
			   }else if(dayForWeek==2){
				   week="周二";
			   }else if(dayForWeek==3){
				   week="周三";
			   }else if(dayForWeek==4){
				   week="周四";
			   }else if(dayForWeek==5){
				   week="周五";
			   }else if(dayForWeek==6){
				   week="周六";
			   }
		  }
		  return week;
	 }
	 
	   /**
	     * 判断当前日期是星期几
	     * 
	     * @param pTime 修要判断的时间
	     * @return dayForWeek 判断结果
	     * @Exception 发生异常
	     */
		 public static String dayForWeek(String pTime) throws Exception {
			  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			  Calendar c = Calendar.getInstance();
			  c.setTime(format.parse(pTime));
			  String week="";
			  int dayForWeek = 0;
			  if(c.get(Calendar.DAY_OF_WEEK) == 1){
				   dayForWeek = 7;
				   week="星期日";
			  }else{
				   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
				   if(dayForWeek==1){
					  week="星期一"; 
				   }else if(dayForWeek==2){
					   week="星期二";
				   }else if(dayForWeek==3){
					   week="星期三";
				   }else if(dayForWeek==4){
					   week="星期四";
				   }else if(dayForWeek==5){
					   week="星期五";
				   }else if(dayForWeek==6){
					   week="星期六";
				   }
			  }
			  return week;
		 }
    
	/**
	 * 时间戳转换成日期类型
	 * @param date
	 * @param fmt
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(Long date,String fmt){
		SimpleDateFormat format = new SimpleDateFormat(fmt);
		String d=format.format(date);
		try {
			return format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取上一个周日
	 * @param c 当前日期   
	 * @return String  
	 * @throws
	 * @author wdl
	 * @date 2015-1-15
	 */
	public static String getLastSunDate(Calendar c){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	    //System.out.println("now date: " + c.getTime());
	    // 减去一个星期
	    c.add(Calendar.WEEK_OF_MONTH, -1);
	    // 上个星期的今天是第几天,星期天是1,所以要减去1
	    int d = c.get(Calendar.DAY_OF_WEEK) - 1;
	    // 添加余下的天数
	    c.add(Calendar.DAY_OF_WEEK, 7 - d);
	  //  System.out.println("last sunday: " + f.format(c.getTime()));
	    return  f.format(c.getTime());
	}
	
	/**
	 * 根据当前日期获取一周时间
	 * @return List<Calendar>  
	 * @author wdl
	 * @date 2015-4-26
	 */
    public static List<Date> getWeekdays(Date inuptDate) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(inuptDate);
    	List<Date> calendarList = new ArrayList<Date>();
        setToFirstDay(calendar);
        for (int i = 0; i < 7; i++) {
        	Date date = new Date();
        	date = calendar.getTime();
        	calendarList.add(date);
            calendar.add(Calendar.DATE, 1);
        }
        return  calendarList;
    }
 
    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
 
    private static void printDay(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd EE");
        System.out.println(dateFormat.format(calendar.getTime()));
    }
    
    /** 
     * 获取当前时间的前一天时间 
     * @param cl 
     * @return 
     */  
    public static Calendar getBeforeDay(Calendar cl){  
        //使用roll方法进行向前回滚  
        //cl.roll(Calendar.DATE, -1);  
        //使用set方法直接进行设置  
        int day = cl.get(Calendar.DATE);  
        cl.set(Calendar.DATE, day-1);  
        return cl;  
    }  
      
    /** 
     * 获取当前时间的后一天时间 
     * @param cl 
     * @return 
     */  
    public static Calendar getAfterDay(Calendar cl){  
        //使用roll方法进行回滚到后一天的时间  
        //cl.roll(Calendar.DATE, 1);  
        //使用set方法直接设置时间值  
        int day = cl.get(Calendar.DATE);  
        cl.set(Calendar.DATE, day+1);  
        return cl;  
    }
    
    //根据时间字符串获取秒数 时间字符串格式:"00:00:10.68" 
    public static int getTimelen(String timelen){
        int min=0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            min+=Integer.valueOf(strs[0])*60*60;//秒
        }
        if(strs[1].compareTo("0")>0){
            min+=Integer.valueOf(strs[1])*60;
        }
        if(strs[2].compareTo("0")>0){
            min+=Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }
    
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        String result = "";
        if(days>0){
        	result = result + days + "天 ";
        }
        if(hours>0 || !result.equals("")){
        	result= result + hours + "小时 ";
        }
        if(minutes>0 || !result.equals("")){
        	result = result + minutes + "分钟 ";
        }
        result = result + seconds + "秒 ";
        return result;
    }
    
    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	/**
	 * 以友好的方式显示时间
	 * 
	 * @param
	 * @return
	 */
	public static String friendlyTime(Date time) {

		if (time == null) {
			return "Unknown";
		}
		String ftime = "";
		Calendar cal = Calendar.getInstance();

		// 判断是否是同一天
		String curDate = dateFormater.get().format(cal.getTime());
		String paramDate = dateFormater.get().format(time);
		if (curDate.equals(paramDate)) {
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0)
				ftime = Math.max(
						(cal.getTimeInMillis() - time.getTime()) / 60000, 1)
						+ "分钟前";
			else
				ftime = hour + "小时前";
			return ftime;
		}

		long lt = time.getTime() / 86400000;
		long ct = cal.getTimeInMillis() / 86400000;
		int days = (int) (ct - lt);
		if (days == 0) {
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0)
				ftime = Math.max(
						(cal.getTimeInMillis() - time.getTime()) / 60000, 1)
						+ "分钟前";
			else
				ftime = hour + "小时前";
		} else if (days == 1) {
			ftime = "昨天";
		} else if (days == 2) {
			ftime = "前天";
		} else if (days > 2 && days <= 10) {
			ftime = days + "天前";
		} else if (days > 10) {
			ftime = dateFormater.get().format(time);
		}
		return ftime;
	}
	
	/**
     * 获取两天的天数差
     * @param smallDate
     * @param bigDate
     * @return
     */
    public static long getApartDayNum(Date smallDate,Date bigDate){
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DATE);
		String bigDateStr = sdf.format(bigDate);
		String smallDateStr = sdf.format(smallDate);
		Date smallDateNoTime = null;
		Date bigDateNoTime = null;
		try {
			smallDateNoTime = sdf.parse(smallDateStr);
			bigDateNoTime = sdf.parse(bigDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long residue = ((bigDateNoTime.getTime() - smallDateNoTime.getTime()) % (60 * 60 * 24 * 1000))>0?1:0;
	    return (bigDateNoTime.getTime() - smallDateNoTime.getTime()) / (60 * 60 * 24 * 1000) + residue;
    }
    
    /**
     * 返回某个时间点的前几天的List 例如“2016-01-01,2016-01-02”
     * @param dateNum
     * @return
     */
    public static List<String> getNowPrevDate(Date date, int dateNum){
    	int sign = -1;
		if(dateNum < 0){
			dateNum = 0 - dateNum;
			sign = 0 - sign;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -sign);
		Date nowDate = null;
		nowDate = calendar.getTime();
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_DATE);
		String  dateStr = "";
		
		for(int i=1;i<=dateNum;i++){
			calendar.setTime(nowDate);
			calendar.add(Calendar.DAY_OF_MONTH, sign);
			nowDate = calendar.getTime();
			dateStr = formatter.format(nowDate);
			dateList.add(dateStr);
		}
		return dateList;
	}

    /**
     * 根据当前时间、过期秒数获取过期时间
     * @param
     * @return
     */
    public static Date getExpireTime(int second){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.SECOND , second);
    	return calendar.getTime();
    }

	/**
	 * 获取当前天凌晨的时间
	 * @return
	 */
	public static long getTodayZeroSecond(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis()/1000;
	}

	/**
	 * 获取当前时间到下一天凌晨的秒数
	 * @return
	 */
	public static int getMinutsToNextday(){
		long todaySecond = getTodayZeroSecond();
		long current = System.currentTimeMillis();
		return (int)(24*60*60-(current/1000 -todaySecond));
	}

	/**
	 * 获取当前月的最后天 例如 传入2018-09
	 * @param monthStr
	 * @return 2018-09-30
	 */
    public static Date getMonthLastDateByMonthStr(String monthStr) throws ParseException {
		Date date = parseDate(monthStr + "-01",DATE_FORMAT_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	public static Date getLastMonthFristDateByMonthStr(String monthStr) throws ParseException {
		Date date = parseDate(monthStr + "-01",DATE_FORMAT_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
}
