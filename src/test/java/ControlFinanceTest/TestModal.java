package ControlFinanceTest;

import ControlFinance.ModalVerification;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestModal {
	ModalVerification modalVerification = new ModalVerification();
	@Test
	void testOpenModal() {
		assertEquals(true, modalVerification.openModalVerification());
	}
	
	@Test
	void testInvalidInput() {
		assertEquals(true,  modalVerification.invalidInput());
	}
	
	@Test
	void testValidInput() {
		assertEquals(true, modalVerification.validInput());
	}
	
	@Test
	void testSubmitVerification() {
		assertEquals(false, modalVerification.submitVerification());
	}
	
	@Test
	void testBtnEntranceVerification() {
		assertEquals(true, modalVerification.btnEntranceVerification());
	}
	
	@Test
	void testBtnExitVerification() {
		assertEquals(true, modalVerification.btnExitVerification());
	}
	
	@Test 
	void testcancelModalVerification() {
		assertEquals(false, modalVerification.cancelModalVerification());
	}


	
}

