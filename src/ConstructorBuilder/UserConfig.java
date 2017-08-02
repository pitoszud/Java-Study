package ConstructorBuilder;
import  java.util.regex.Pattern;
   /**
      <P>Information about a user -- <I>[builder: UserConfig_Cfg]</I></P>
      <P>Validation of all fields occurs in this classes constructor. However, each validation requirement is document only in the builder's setter functions.</P>
      <P>{@code java xbn.z.xmpl.lang.builder.finalv.UserConfig}</P>
    **/
   public class UserConfig  {
      public static final void main(String[] igno_red)  {
         UserConfig uc = new UserConfig_Cfg("Kermit").age(50).favoriteColor("green").build();
         System.out.println(uc);
      }
      private final String sName    ;
      private final int    iAge     ;
      private final String sFavColor;
      /**
         <P>Create a new instance. This sets and validates all fields.</P>
 
         @param  uc_f  May not be {@code null}.
       **/
      public UserConfig(UserConfig_Fieldable uc_f)  {
         //transfer
            try  {
               sName  = uc_f.getName();
            }  catch(NullPointerException rx)  {
               throw  new NullPointerException("uc_f");
            }
            iAge      = uc_f.getAge();
            sFavColor = uc_f.getFavoriteColor();
         //validate
            try  {
               if(!Pattern.compile("\\w+").matcher(sName).matches())  {
                  throw  new IllegalArgumentException("uc_f.getName() (\"" + sName + "\") may not be empty, and must contain only letters digits and underscores.");
               }
            }  catch(NullPointerException rx)  {
               throw  new NullPointerException("uc_f.getName()");
            }
            if(iAge < 0)  {
               throw  new IllegalArgumentException("uc_f.getAge() (" + iAge + ") is less than zero.");
            }
            try  {
               if(!Pattern.compile("(?:red|blue|green|hot pink)").matcher(sFavColor).matches())  {
                  throw  new IllegalArgumentException("uc_f.getFavoriteColor() (\"" + uc_f.getFavoriteColor() + "\") is not red, blue, green, or hot pink.");
               }
            }  catch(NullPointerException rx)  {
               throw  new NullPointerException("uc_f.getFavoriteColor()");
            }
      }
      //getters...START
         /**
            <P>The user's name.</P>
 
            @return  A non-{@code null}, non-empty string.
            @see  UserConfig_Cfg#UserConfig_Cfg(String)
            @see  #getAge()
            @see  #getFavoriteColor()
          **/
         public String getName()  {
            return  sName;
         }
         /**
            <P>The user's age.</P>
 
            @return  A number greater-than-or-equal-to zero.
            @see  UserConfig_Cfg#age(int)
            @see  #getName()
          **/
         public int getAge()  {
            return  iAge;
         }
         /**
            <P>The user's favorite color.</P>
 
            @return  A non-{@code null}, non-empty string.
            @see  UserConfig_Cfg#age(int)
            @see  #getName()
          **/
         public String getFavoriteColor()  {
            return  sFavColor;
         }
      //getters...END
      public String toString()  {
         return  "getName()=" + getName() + ", getAge()=" + getAge() + ", getFavoriteColor()=" + getFavoriteColor();
      }
   }