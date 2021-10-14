package testunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import normalisation.*;


public class TestNormalVille {
		
		@Test
		public void postale4chiffres() {
			
			assertEquals("08200", NormalisationVille.normCodePostal("8200"));
		}
		
		@Test
		public void postaleLettre() {
				
			assertEquals("2270", NormalisationVille.normCodePostal("L-2270"));
			
		}
		
		/*@Test
		public void tiret() {
			assertEquals("Montigny-lès-Metz", NormalisationVille.normVille("Montigny lès Metz"));
		}
		
		@Test
		public void accent() {
			assertEquals("Montigny-lès-Metz", NormalisationVille.normVille("Montigny-les-Metz"));
		}*/
		
		@Test
		public void normNumVoie() {
			
			assertEquals("3, rue des alouettes",NormalisationVille.norNumVoie("3", "rue des alouettes"));
		}
		
		@Test
		public void normalVilleBoul() {
			assertEquals("Boulevard",NormalisationVille.normNomVoie("boul"));
		}
		
		@Test
		public void normalVilleBoul2() {
			assertEquals("Boulevard",NormalisationVille.normNomVoie("boul."));
		}
		
		@Test
		public void normalVilleBoul3() {
			assertEquals("Boulevard",NormalisationVille.normNomVoie("bd"));
		}
		
		@Test
		public void normalVilleplace() {
			assertEquals("Place",NormalisationVille.normNomVoie("pl."));
		}
		
		@Test
		public void normalVilleAvenue() {
			assertEquals("Avenue",NormalisationVille.normNomVoie("av."));
		}
		
		@Test
		public void normalVillefaub() {
			assertEquals("Faubourg",NormalisationVille.normNomVoie("faub."));
		}
		
		@Test
		public void normalVillefaub2() {
			assertEquals("Faubourg",NormalisationVille.normNomVoie("fg"));
		}
		
		
}
