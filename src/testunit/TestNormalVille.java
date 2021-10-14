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
		
		@Test
		public void tiret() {
			assertEquals("Montigny-lès-Metz", NormalisationVille.normVille("Montigny lès Metz"));
		}
		
		@Test
		public void accent() {
			assertEquals("Montigny-lès-Metz", NormalisationVille.normVille("Montigny-les-Metz"));
		}
		
		
}
