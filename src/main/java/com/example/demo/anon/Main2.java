package com.example.demo.anon;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ml=LocalDateTime.parse("2018-10-10 00:00:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(ml.plusDays(1).toString());
    }

    public static String timeIntersection(String oneTime, String twoTIme) {
        String res = "";
        String[] mod = oneTime.split("-");
        String oneBeg = mod[0];
        String oneEnd = convertHour00(mod[1]);
        List<String> times = new ArrayList<>();
        for (String two : twoTIme.split(",")) {
            String[] tt = two.split("-");
            String twoBeg = tt[0];
            String twoEnd = convertHour00(tt[1]);
            if (oneEnd.compareTo(twoBeg) <= -1 || twoEnd.compareTo(oneBeg) <= -1) {
                continue;
            }
            if (oneBeg.compareTo(twoBeg) >= 1 && oneEnd.compareTo(twoEnd) <= -1) {
                times.add(oneBeg + "-" + convertHour24(oneEnd));
                continue;
            }
            if (twoBeg.compareTo(oneBeg) >= 1 && twoEnd.compareTo(oneEnd) <= -1) {
                times.add(twoBeg + "-" + convertHour24(twoEnd));
                continue;
            }
            if (twoBeg.compareTo(oneEnd) <= -1) {
                times.add(twoBeg + "-" + convertHour24(oneEnd));
                continue;
            }
            if (oneBeg.compareTo(twoEnd) <= -1) {
                times.add(oneBeg + "-" + convertHour24(twoEnd));
                continue;
            }
        }
        for (String str : times) {
            res = res + str + ",";
        }
        if (times.size() == 0) {
            return null;
        }
        return res.substring(0, res.length() - 1);
    }

    public static String convertHour00(String time) {
        String[] mod = time.split(":");
        boolean bol = mod[0].equals("00");
        if (bol) {
            String m = "24";
            for (int i = 1; i < mod.length; i++) {
                m = m + ":" + mod[i];
            }
            return m;
        } else {
            return time;
        }
    }

    public static String convertHour24(String time) {
        String[] mod = time.split(":");
        boolean bol = mod[0].equals("24");
        if (bol) {
            String m = "00";
            for (int i = 1; i < mod.length; i++) {
                m = m + ":" + mod[i];
            }
            return m;
        } else {
            return time;
        }
    }

    public static List<LocalDate> listTimePeriod(LocalDateTime stratTime, LocalDateTime endTime) {
        List<LocalDate> list = new ArrayList<>();
        LocalDate start = stratTime.toLocalDate();
        LocalDate end = endTime.toLocalDate();
        LocalDate mod = start;
        for (; ; ) {
            if (mod.compareTo(end) <= 0) {
                list.add(mod);
            } else
                break;
            mod = mod.plusDays(1);
        }
        return list;
    }

    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate se = LocalDate.parse(start);
        LocalDate ee = LocalDate.parse(end);
        Long dist = ChronoUnit.DAYS.between(se, ee);
        if (dist < 1) {
            Stream.iterate(se, d -> {
                return d.plusDays(1);
            }).limit(dist + 1).forEach(f -> {
                list.add(f.toString());
            });
        }
        System.out.println(se.plusDays(-1).compareTo(ee));
        return list;
    }
}
