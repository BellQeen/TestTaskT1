package ru.bulaev.testtask.TestTaskT1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1) Запускаем приложение;
 * 2) В браузере в адресной строке пишем запрос: http://localhost:8080/charFrequency?input=
 * (после "input=" нужно написать необходимую нам строку с символами);
 * 3) После этого в браузере выдастся ответ в виде JSON.
 */

@SpringBootApplication
public class TestTaskT1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestTaskT1Application.class, args);
	}

}
