package normalisation;

public class NormalisationVille {
	
	public static String normVilleMaj(String ville) {
		
		ville=ville.substring(0, 1).toUpperCase()+ville.substring(1);
		
		return ville;
	}
	
	
	public static String normVille(String ville) {
		//split() pour separer la chaine pour mettre les premieres lettre en maj 
		// replaceall() remplace lès- en -lès-
		
		ville=ville.replaceAll("-lès ","-lès-");		ville=ville.replaceAll(" le ","-le-");
		ville=ville.replaceAll(" lès-", "-lès-");		ville=ville.replaceAll("-le ", "-le-");
		ville=ville.replaceAll(" lès ","-lès-");		ville=ville.replaceAll(" le-", "le");
		
		ville=ville.replaceAll("-les ","-lès-");		ville=ville.replaceAll(" à ","-à-");	
		ville=ville.replaceAll(" les-", "-lès-");		ville=ville.replaceAll("-à ","-à-");	
		ville=ville.replaceAll(" les ","-lès-");		ville=ville.replaceAll(" à-","-à-");	
		
		
		ville=ville.replaceAll(" a ","-à-");			ville=ville.replaceAll("-aux ", "-aux-");	
		ville=ville.replaceAll(" a-","-à-");			ville=ville.replaceAll(" aux ", "-aux-");
		ville=ville.replaceAll("-a ","-à-");			ville=ville.replaceAll(" aux-", "-aux-");
		
		
		ville=ville.replaceAll("-sous ","-sous-");		ville=ville.replaceAll("-sur","-sur-");
		ville=ville.replaceAll(" sous ", "-sous-");		ville=ville.replaceAll(" sur ", "-sur-");
		ville=ville.replaceAll(" sous-", "-sous-");		ville=ville.replaceAll("sur-", "-sur-");
		
		
		return ville;
		}
	
	
	public static String normNomVoie(String NomVoie) {
	    String s1= "Boulevard";
	    String s2="Avenue";
	    String s3= "Place";
	    String s4= "Faubourg";

	    NomVoie=NomVoie.trim();

	    if (NomVoie.equalsIgnoreCase("boul") ||  NomVoie.equalsIgnoreCase("boul.") ||  NomVoie.equalsIgnoreCase("bd")) {
	        return s1;
	    }
	    else if (NomVoie.equalsIgnoreCase("av.")) {
	        return s2;
	    }
	    else if (NomVoie.equalsIgnoreCase("faub.") || NomVoie.equalsIgnoreCase("fg")) {
	        return s4;
	    }
	    else if (NomVoie.equalsIgnoreCase("pl.")) {
	        return s3;
	    }
	    else return NomVoie;
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
	
	
	public static String norNumVoie(String numVoie, String nomVoie) {
		return numVoie+", "+nomVoie;
		
	}

}
