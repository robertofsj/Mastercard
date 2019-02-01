package com.mastercard.challenge;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.mastercard.challenge.resource.ResponseCityBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Test
	public void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
        ResponseCityBean bean = restTemplate.getForObject("http://localhost:8080/connected?origin=Boston&destination=Philadelphia", ResponseCityBean.class);
        
        assertTrue(bean.getConnected().equals("Yes"));
	}
}

