//package gym.com.valid;
import java.util.regex.*;

class MailTextField
{
   public boolean email(String str) 
   {
 
	
      //Set the email pattern string
      Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

      //Match the given string with the pattern
      Matcher m = p.matcher(str);

      //check whether match is found 
      boolean matchFound = m.matches();
return matchFound;

   }
}
