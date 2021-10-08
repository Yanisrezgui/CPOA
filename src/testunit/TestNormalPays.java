package testunit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import normalisation.*;


public class TestNormalPays {
	
	@Test
	public void normalPayslux() {
		assertEquals("luxembourg",NormalisationPays.normPays("letzebuerg "));
	}
	
	@Test
	public void normalPaysbelg() {
		assertEquals("belgique",NormalisationPays.normPays("belgium"));
	}
	
	@Test
	public void normalPayssui() {
		assertEquals("suisse",NormalisationPays.normPays("Switzerland"));
	}
	
	@Test
	public void normalPayssui2() {
		assertEquals("suisse",NormalisationPays.normPays("Schweiz"));
	}
	
	@Test
	public void normalPays() {
		assertEquals("bonjour",NormalisationPays.normPays("bonjour"));
	}
}
