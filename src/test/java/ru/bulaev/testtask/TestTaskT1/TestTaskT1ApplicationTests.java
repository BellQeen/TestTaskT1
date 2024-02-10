package ru.bulaev.testtask.TestTaskT1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestTaskT1ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	/// Тест обычной строки
	@Test
	public void testCharFrequencySimple() throws Exception {
		String input = "aaaaabcccc";

		mockMvc.perform(get("/charFrequency").param("input", input))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"a\":5,\"c\":4,\"b\":1}"));
	}

	/// Тест более сложной строки
	@Test
	public void testCharFrequencyComplain() throws Exception {
		String input = "Ju8s2UU7J8sJ";

		mockMvc.perform(get("/charFrequency").param("input", input))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"J\":3,\"8\":2,\"s\":2,\"U\":2,\"u\":1,\"2\":1,\"7\":1}"));
	}

	/// Тест строки из 1 символа
	@Test
	public void testCharFrequencyOneChar() throws Exception {
		String input = "j";

		mockMvc.perform(get("/charFrequency").param("input", input))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"j\":1}"));
	}

	/// Тест пустой строки
	@Test
	public void testCharFrequencyEmptyInput() throws Exception {
		String input = "";

		mockMvc.perform(get("/charFrequency").param("input", input))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"j\":1}"));
	}

	/// Тест некорректного запроса
	@Test
	public void testCharFrequency() throws Exception {

		mockMvc.perform(get("/charFrequency"))
				.andExpect(status().isBadRequest());
	}

}
