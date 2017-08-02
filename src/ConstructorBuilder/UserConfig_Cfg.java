package ConstructorBuilder;
import  java.util.regex.Pattern;
   /**
      <P>Builder for {@link UserConfig}.</P>
      <P>Validation of all fields occurs in the <CODE>UserConfig</CODE> constructor. However, each validation requirement is document only in this classes setter functions.</P>
    **/
   public class UserConfig_Cfg implements UserConfig_Fieldable  {
      public String sName    ;
      public int    iAge     ;
      public String sFavColor;
      /**
         <P>Create a new instance with the user's name.</P>
 
         @param  s_name  May not be {@code null} or empty, and must contain only letters, digits, and underscores. Get with {@code UserConfig#getName() getName()}{@code ()}*.
       **/
      public UserConfig_Cfg(String s_name)  {
         sName = s_name;
      }
      //self-returning setters...START
         /**
            <P>Set the user's age.</P>
 
            @param  i_age  May not be less than zero. Get with {@code UserConfig#getName() getName()}{@code ()}*.
            @see  #favoriteColor(String)
          **/
         public UserConfig_Cfg age(int i_age)  {
            iAge = i_age;
            return  this;
         }
         /**
            <P>Set the user's favorite color.</P>
 
            @param  s_color  Must be {@code "red"}, {@code "blue"}, {@code green}, or {@code "hot pink"}. Get with {@code UserConfig#getName() getName()}{@code ()}*.
            @see  #age(int)
          **/
         public UserConfig_Cfg favoriteColor(String s_color)  {
            sFavColor = s_color;
            return  this;
         }
      //self-returning setters...END
      //getters...START
         public String getName()  {
            return  sName;
         }
         public int getAge()  {
            return  iAge;
         }
         public String getFavoriteColor()  {
            return  sFavColor;
         }
      //getters...END
      /**
         <P>Build the UserConfig, as configured.</P>
 
         @return  <CODE>(new {@link UserConfig#UserConfig(UserConfig_Fieldable) UserConfig}(this))</CODE>
       **/
      public UserConfig build()  {
         return (new UserConfig(this));
      }
   }