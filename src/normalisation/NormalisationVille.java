package normalisation;

public class NormalisationVille {
	
	public static String normVilleMaj(String ville) {
		
		ville=ville.substring(0, 1).toUpperCase()+ville.substring(1);
		
		return ville;
	}
	
	
	public static String normVille(String ville) {
		//split() pour separer la chaine pour mettre les premieres lettre en maj 
		// replaceall() remplace l�s- en -l�s-
		
		ville=ville.replaceAll("-l�s","-l�s-");		ville=ville.replaceAll("le","-le-");
		ville=ville.replaceAll("l�s-", "-l�s-");	ville=ville.replaceAll("-le", "-le-");
		ville=ville.replaceAll("l�s","-l�s-");		ville=ville.replaceAll("le-", "le");
		
		ville=ville.replaceAll("-sous","-sous-");	ville=ville.replaceAll("-sur","-sur-");
		ville=ville.replaceAll("sous", "-sous-");	ville=ville.replaceAll("sur", "-sur-");
		ville=ville.replaceAll("sous-", "-sous-");	ville=ville.replaceAll("sur-", "-sur-");
		
		
		
		
		
		
		return ville;
		}
	
	
	public static String normCodePostal(String CodePostal) {

        String Add ="0";
        if (CodePostal.length() <= 4)
        {
            CodePostal = Add+CodePostal;
            return CodePostal;
        }
        else if(CodePostal.length()>5)
        {
        	for(int i=0;i<2;i++)
        	{
        		CodePostal=CodePostal.substring(1);	
        	}
        	return CodePostal;
        }
        else  return CodePostal;
      

    }

}