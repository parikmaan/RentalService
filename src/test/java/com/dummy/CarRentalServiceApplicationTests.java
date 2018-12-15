package com.dummy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dummy.rentalservice.controller.ReservationController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ReservationController.class, secure = false)
public class CarRentalServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}

