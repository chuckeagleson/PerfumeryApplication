package ok.boutique.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;


import ok.boutique.dao.ProducerRepository;
import ok.boutique.dao.ProductRepository;
import ok.boutique.dao.UserRepository;
import ok.boutique.security.SecurityConfig;
import ok.boutique.service.impl.ProducerServiceImpl;
import ok.boutique.service.impl.ProductServiceImpl;


@WebMvcTest(OverviewController.class)
@Import(SecurityConfig.class)
public class OverviewControllerTest {
	

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ProducerServiceImpl producerService;
	@MockBean
	private ProductServiceImpl productService;
	@MockBean
	private ProducerRepository producerRepo;
	@MockBean
	private ProductRepository productRepo;
	@MockBean
	private UserRepository userRepo;


	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Home")));
	}

}
