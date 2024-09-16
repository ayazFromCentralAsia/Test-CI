package com.example.docker_test_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DockerTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerTestProjectApplication.class, args);

		while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Введите исходную валюту (например, USD): ");
			String fromCurrency = scanner.nextLine().toUpperCase();

			System.out.print("Введите конечную валюту (например, EUR): ");
			String toCurrency = scanner.nextLine().toUpperCase();

			System.out.print("Введите сумму для конвертации: ");
			double amount = scanner.nextDouble();

			try {
				double result = CurrencyConvert.convert(fromCurrency, toCurrency, amount);
				System.out.printf("Конвертированная сумма: %.2f %s%n", result, toCurrency);
			} catch (Exception e) {
				System.out.println("Произошла ошибка: " + e.getMessage());
			}
		}
	}
}
