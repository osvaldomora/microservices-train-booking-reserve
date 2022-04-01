package train.ticket.booking.app.train.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import train.ticket.booking.app.train.dto.TrainSearchByDetsReponseDTO;
import train.ticket.booking.app.train.dto.response.TrainDto;
import train.ticket.booking.app.train.service.ITrainService;

@WebMvcTest(TrainController.class)
class TrainControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ITrainService trainService;
	
	
	private TrainDto trainDto;
	private TrainSearchByDetsReponseDTO trainSearchDto;
	
	@Test
	void trainsTest() throws Exception {
		trainDto = new TrainDto();
		
		when(trainService.findById(Mockito.anyInt(), Mockito.anyInt())).thenReturn(trainDto);
		
		mockMvc.perform(get("/trains/1/seats/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
		

		
	}
	
	@Test
	void searchTrainBySourceDestinationTest() throws Exception {
		trainSearchDto = new TrainSearchByDetsReponseDTO("Details fetch successfully", 200);
		
		when(trainService.findBySearchDetails(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(trainSearchDto);
		
		mockMvc.perform(get("/trains/search/test/test/2020")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	void testPort() throws Exception {
		mockMvc.perform(get("/trains/port")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		//assertThat(this.bookingService.getPort()).isEqualTo(8890);
	}

}
