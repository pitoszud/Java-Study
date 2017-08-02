

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 *
 * @author UPatryk
 */
public class Dates {
    public static void main(String[] args) {
        LocalTime largeEgg = LocalTime.of(0, 5, 0);  // 0:05:0
        LocalTime mediumEgg = LocalTime.of(0, 3, 30);  // 0:03:30
        LocalTime smallEgg = LocalTime.of(0, 2, 30);  // 0:02:30
        
        
        LocalDate ld1 = LocalDate.of(1982, 5, 9); // == 1982, Month.MAY, 9
        LocalDate ld2 = LocalDate.now();
        
        LocalDateTime ldt1 = LocalDateTime.of(ld1, mediumEgg);
        
        bday(ld1, ld2);
        PeriodAddToLocalDate(365,ld2);
        LocalDatePlusPeriod(365,ld2);
        LocalDatePlus(365,ld2);
        
        formatDateTime(ld1, ldt1);
        formatDateTimeCustom(ldt1);
        formatDateTimeParse();
        
        getDMY(ld1);
        
    }
    
    private static void formatDateTime(LocalDate ld1, LocalDateTime ldt1){
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(dtf.format(ld1)); // 09/05/82
        // System.out.println(dtf.format(lt1)); // java.time.temporal.UnsupportedTemporalTypeException
        System.out.println(dtf.format(ldt1)); // 09/05/82
        
        
        System.out.println(ld1.format(dtf));  // 09/05/82
        // System.out.println(lt1.format(dtf)); // java.time.temporal.UnsupportedTemporalTypeException
        System.out.println(ldt1.format(dtf));  // 09/05/82
    }
    
    private static void formatDateTimeCustom(LocalDateTime ldt1){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM, yyyy; hh:mm:ss");
        System.out.println(dtf.format(ldt1)); // 09 May, 1982; 12:03:30
    }
    
    private static void formatDateTimeParse(){
        LocalDate ld3 = LocalDate.parse("09 05 1982", DateTimeFormatter.ofPattern("dd MM yyyy"));
        System.out.println("before: 09 05 1982");  // before: 09 05 1982
        System.out.println("after: " + ld3); // after: 1982-05-09
        
        LocalDate ld4 = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ISO_DATE);
        System.out.println(ld4);  // 2017-02-13
        
        LocalDate ld5 = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(ld5);  // 2017-02-13
    }
    
    
    private static void bday(LocalDate ld1, LocalDate ld2){
        LocalDate birthday = ld1;
        LocalDate today = ld2;
        
        Period p1 = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("y: " + p1.getYears());
        System.out.println("m: " + p1.getMonths());
        System.out.println("d: " + p1.getDays());
        System.out.println("total d: " + p2);
    }
    
    private static void PeriodAddToLocalDate(int dnum, LocalDate ld){
        Period p = Period.ofDays(dnum);
        Temporal t = p.addTo(ld);
        System.out.println("\n" + ld + " + " + dnum + " days = " + t + " - Temporal = Period.addTo(LocalDate)");
    }
    
    private static void LocalDatePlusPeriod(int dnum, LocalDate ld){
        Period p1 = Period.ofDays(dnum);
        LocalDate ld1 = ld.plus(p1);
        System.out.println("\n" + ld + " + " + dnum + " days = " + ld1 + " - LocalDate.plus(Period.ofDays(365))");
        
        Period p2 = Period.of(0, 0, 365);
        LocalDate ld2 = ld.plus(p2);
        System.out.println("\n" + ld + " + " + dnum + " days = " + ld2 + " - LocalDate.plus(Period.of(0,0,365)");
        
        // Period does not allow chaining, so only last method counts
        Period p3 = Period.ofYears(2).ofMonths(2).ofDays(6);
        LocalDate ld3 = ld.plus(p3);
        System.out.println("\n" + ld + " + 1y 2m 6d = " + ld3 + " - no chaining example");
    }
    
    private static void LocalDatePlus(int dnum, LocalDate ld){
        // LocalDate is immutable same as String so no change is done here
        ld.plusDays(dnum).plusWeeks(1).plusMonths(2).plusYears(3);
        System.out.println("\n" + ld + " + 1 week + 2 months + 3 years = " + ld + " - immutable example");
        
        LocalDate ldPlus = ld.plusDays(dnum).plusWeeks(1).plusMonths(2).plusYears(3);
        System.out.println("\n" + ld + " + 1 week + 2 months + 3 years = " + ldPlus + " - mutable example");
    }
    
    private static void getDMY(LocalDate ld){
        int d = ld.getDayOfMonth();
        int m = ld.getMonthValue();
        int y = ld.getYear();
        
        System.out.println(d + "/" + m + "/" + y);
    }
}
