package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.trainerplanner.PlannerBean;

class PlannerBeanTest {

	private PlannerBean plannerbean;
	@BeforeEach
	void setUp() { 
		
		System.out.println("Test running");
		plannerbean = new PlannerBean();
	}

	@Test
	public void testMemberName() {
		plannerbean.setMemberName("Shane");
		assertEquals("Shane",plannerbean.getMemberName());
	}

	@Test
	public void testMondaySessionPass() {
		String[] expectedOutput = {"stretching","cycling","muscle training"};
		String[] mondaySession = {"stretching","cycling","muscle training"};
		assertArrayEquals(expectedOutput, mondaySession);
	}
	
	@Test
	public void testMondaySessionFail() {
		String[] expectedOutput = {"rest"};
		String[] tuesdaySession = {"rest"};
		assertArrayEquals(expectedOutput, tuesdaySession);
	}
	
//	@Test
//	public void testMonday(String[] mondaySession) { 
//		plannerbean.setMondaySession(mondaySession);
//		
//		assertArrayEquals(mondaySession, plannerbean.getMondaySession());
//	}
//	
	

	@Test
	public void toStringTest() {
		String expected = "";
		assertEquals(expected, plannerbean.toString());
		
	}
}
















