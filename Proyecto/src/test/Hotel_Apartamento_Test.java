package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Proyect.Hotel;

class Hotel_Apartamento_Test {

	@Test
	void testEs_apto() {
		Hotel h = new Hotel("a1", "Durango", 12.2, 1, 5);
		boolean resultado = h.es_apto();
		assertEquals(resultado, true);
	}

	@Test
	void testPrintCaracteristicas() {
		Hotel h = new Hotel("a1", "Durango", 12.2, 1, 5);
		assertEquals("'a1', 'Durango', 12.2, 1, 5", h.printCaracteristicas());
	}

	@Test
	void testSetTotal() {
		Hotel h = new Hotel("a1", "Durango", 12.2, 1, 5);
		double total = h.setTotal();
		assertEquals(total, 14);
	}

}
