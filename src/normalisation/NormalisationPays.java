package normalisation;

public class NormalisationPays {
	
	public static String normPays(String pays) {
		
		String s1="belgique";
		String s2="luxembourg";
		String s3="Suisse";
		
		pays=pays.trim();
		
		if(pays.equalsIgnoreCase("letzebuerg"))
		{
			return s2;
		}
		else if(pays.equalsIgnoreCase("belgium"))
		{
			return s1;
		}
		else if(pays.equalsIgnoreCase("Switzerland")||(pays.equalsIgnoreCase("Schweiz")))
		{
			return s3;
		}
		else return pays;
	}

}
