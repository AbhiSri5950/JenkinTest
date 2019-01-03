package com.fa.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.fa.controller.EmployeeController;
import com.fa.service.EmployeeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = { "classpath:dispatcher-servlet.xml", "classpath:application-context.xml" })
//@WebAppConfiguration
public class EmployeeTest {

	MockMvc mockMvc;

	@Mock
	//@Autowired
	//@InjectMocks
	EmployeeService empServiceMock;
	
	@InjectMocks 
	EmployeeController empController;
	 	
	//@Autowired
	WebApplicationContext context;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
	}

	@Test
	public void testContextForNotNull() throws Exception {
		
		//EmployeeService empServiceMock=Mockito.mock(EmployeeService.class);
		
		Mockito.when(empServiceMock.m1(Matchers.anyString())).thenReturn(Matchers.anyString());
		
		MvcResult mockResult = mockMvc.perform(MockMvcRequestBuilders.post("/getemployee/{id}", "1"))
				.andExpect(MockMvcResultMatchers.view().name("employee"))
				.andExpect(MockMvcResultMatchers.model().size(1))
				.andExpect(MockMvcResultMatchers.model().attribute("employee",
						hasProperty("empId", is("1"))
				)).andDo(MockMvcResultHandlers.print()).andReturn();

		ModelAndView mav = mockResult.getModelAndView();
		mav.getModelMap();
		Assert.assertEquals(mav.getViewName(), "employee");

	}

}
