import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeFormat {
  public static void main(String[] args) {
      String iso = "yyyy-MM-dd'T'HH:mm:ss.000000000'Z'";
     TimeZone tz = TimeZone.getTimeZone("UTC");
     DateFormat df = new SimpleDateFormat(iso);
     df.setTimeZone(tz);
     String s = df.format(new Date());
     System.out.println(s);
  }
}


