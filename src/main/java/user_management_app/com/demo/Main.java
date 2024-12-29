package user_management_app.com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner checkServerConnection() {
		return args -> {
			System.out.println("Hello to User Management App Server");

			int retries = 5;
			int delay = 2000;
			boolean connected = false;

			for (int i = 0; i < retries; i++) {
				try {
					URL url = new URL("http://localhost:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(2000);

					int responseCode = connection.getResponseCode();
					if (responseCode == HttpURLConnection.HTTP_OK) {
						System.out.println("Server is connected successfully to port 8080");
						connected = true;
						connection.disconnect();
						break;
					} else {
						System.out.println("Failed to connect to port 8080 (Response Code: " + responseCode + ")");
					}
					connection.disconnect();
				} catch (Exception e) {
					System.out.println("Failed to connect to port 8080: " + e.getMessage());
				}

				if (!connected) {
					System.out.println("Retrying... attempt " + (i + 1) + " of " + retries);
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}

			if (!connected) {
				System.out.println("Failed to connect after " + retries + " attempts.");
			}
		};
	}
}

