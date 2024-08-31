package ControlFinance;

import org.openqa.selenium.By;

public class MainControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModalVerification modalVerification = new ModalVerification();
		//        System.setProperty("webdriver.chrome.driver", "C");
//		verifyInput.VerifyInput();
		System.out.println(modalVerification.openModalVerification());
	}

}
