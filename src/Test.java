import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Test {
	
		public static void main(String[] args) throws ParseException {
			String target = "02/06/14";
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date result = df.parse(target);
		    java.sql.Date sqlDate = new java.sql.Date(result.getTime());
		    System.out.println("utilDate:" + result);
		    System.out.println("sqlDate:" + sqlDate);

		  }
}
		