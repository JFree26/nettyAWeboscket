package com.example.demo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {
        System.out.println(new DecimalFormat("###,###.00").format(1121211102.128));
}

    public static  List<LocalDateTime> timeCut5(String requestTime) {
        List<LocalDateTime> time = new ArrayList();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String ti : requestTime.split(",")) {
            String[] d = ti.split("-");
            LocalDateTime begin = LocalDateTime.parse(date + " " + d[0] + ":00", df);
            LocalDateTime end = LocalDateTime.parse(date + " " + d[1] + ":00", df);
            LocalDateTime mod = begin;
            while (mod.isBefore(end) || mod.isEqual(end)) {
                time.add(mod);
                mod = mod.plusMinutes(5);
            }
        }
        return time;
    }

   public static void  match(){
       String url = "http:/klsfnklnklwnl.csfwfwn.cn??1231=sjkfjkf&sfwfw=1212";
       String regex = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$";
       Pattern pattern = Pattern.compile(regex);
       if (pattern.matcher(url).matches()) {
           System.out.println("是正确的网址");
       } else {
           System.out.println("非法网址");
       }
   }



}
