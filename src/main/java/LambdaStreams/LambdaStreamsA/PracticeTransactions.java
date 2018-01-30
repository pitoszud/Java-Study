/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaStreams.LambdaStreamsA;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author UPatryk
 */
public class PracticeTransactions {
    public static void main(String... aArguments) { 
      
      Trader raoul = new Trader("Raoul", "Cambridge");
      Trader mario = new Trader("Mario","Milan");
Trader alan = new Trader("Alan","Cambridge");
Trader brian = new Trader("Brian","Cambridge");

List<Transaction> transactions = Arrays.asList(
new Transaction(brian, 2011, 300),
new Transaction(raoul, 2012, 1000),
new Transaction(raoul, 2011, 400),
new Transaction(mario, 2012, 710),
new Transaction(mario, 2012, 700),
new Transaction(alan, 2012, 950)
);

List<Transaction> trans11 = transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted((v1,v2) -> Integer.compare(v1.getValue(), v2.getValue()))
        .collect(toList());
trans11.stream()
        .forEach(e -> System.out.println(e));
        

        
      
  }
  
  
static class Trader{
private final String name;
private final String city;
public Trader(String n, String c){
this.name = n;
this.city = c;
}
public String getName(){
return this.name;
}
public String getCity(){
return this.city;
}
public String toString(){
return "Trader:"+this.name + " in " + this.city;
}
}

static class Transaction{
   private final Trader trader;
private final int year;
private final int value;
public Transaction(Trader trader, int year, int value){
this.trader = trader;
this.year = year;
this.value = value;
}
public Trader getTrader(){
return this.trader;
}
public int getYear(){
return this.year;
}
public int getValue(){
return this.value;
}
public String toString(){
return "{" + this.trader + ", " +
"year: "+this.year+", " +
"value:" + this.value +"}";
}
}
}
