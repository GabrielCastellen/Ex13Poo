package Ex13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public  static  String  DataHoraForStringPadraoH(Date  pDate) {
		SimpleDateFormat  df = new  SimpleDateFormat("dd/MM/yyyy H:mm:ss");
		String s = "";
		try {
			s = df.format(pDate);
		} catch (Exception  ex) {
			ex.printStackTrace ();
			}
		return s;
		}
	
	public  static  Date  StringToDate(String  string) {
		SimpleDateFormat  df = new  SimpleDateFormat("dd/MM/yyyy H:mm:ss");
		Date d = new Date();
		
		try {
			d = df.parse(string);
		} catch (Exception  ex) {
			ex.printStackTrace ();
			}
		return d;
		}
}
