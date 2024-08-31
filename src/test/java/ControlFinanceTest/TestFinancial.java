package ControlFinanceTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ControlFinance.FinancialResume;

class TestFinancial {
	FinancialResume financialResume = new FinancialResume();

	@Test
	void testformVerification() {
		assertEquals(1, financialResume.formVerification());
	}
	
	@Test 
	void testSpanTypeEntranceVerification() {
		assertTrue(financialResume.spanTypeVerification("Entrada"));
	}
	
	@Test 
	void testSpanTypeExitVerification() {
		assertTrue(financialResume.spanTypeVerification("Saída"));
	}

	@Test
	void testBtnShowAllVerification() {
		assertEquals(2, financialResume.btnShowAllVerification());
	}
	
	@Test
	void testExcludeButton() {
		assertEquals(0, financialResume.excludeButton());
	}
	
	@Test
	void testBtnShowEntranceVerification() {
		assertEquals(1, financialResume.btnShowEntranceVerification());
	}
	
	@Test
	void testBtnShowExitVerification() {
		assertEquals(1, financialResume.btnShowExitVerification());
	}
	
	@Test
	void testTotalSumVerification() {
		assertTrue(financialResume.totalSumVerification());
	}
	
}
