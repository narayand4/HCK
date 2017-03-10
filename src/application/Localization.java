package application;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
	protected void localeDemo(){
		/*String lang = "en";
		String country = "US";*/
		
		String lang = "ge";
		String country = "GE";
		
		Locale local = new Locale(lang, country);
		ResourceBundle r = ResourceBundle.getBundle("application.Bundle",local);
		String str = r.getString("wish");
		System.out.println(str);
	}
}
