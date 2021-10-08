package normalisation;

public class NormalisationVille {
	
	public static String normVilleMaj(String ville) {
		
		ville=ville.substring(0, 1).toUpperCase()+ville.substring(1);
		//split() pour separer la chaine pour mettre les premieres lettre en maj 
		// replaceall() remplace lès- en -lès-
		
		ville.replaceAll("-lès","-lès-");		ville.replaceAll("le","-le-");
		ville.replaceAll("lès-", "-lès-");		ville.replaceAll("-le", "-le-");
		ville.replaceAll("lès","-lès-");		ville.replaceAll("le-", "le");
		
		
		
		
		
		
		
		
		
		return ville;
		}
	
	

}
