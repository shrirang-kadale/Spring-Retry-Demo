package com.example.springretry;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BackendAdapterImpl implements BackendAdapter {

	@Override
	public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) {

		if (simulateretry) {
			System.out.println("Simulateretry is true, so try to simulate exception scenerio.");

			// This block will execute until max attempts of spring retry and afterwards fallback method gets called
			if (simulateretryfallback) {
				throw new RemoteServiceNotAvailableException(
						"Don't worry!! Just Simulated for Spring-retry... Must fallback as all retry will get exception!!!");
			}
			
			// Here I can not call the remote service so I am creating the random number between (0, 1, 2, 3)
			// If 1 or 3 gets generated then pretending that the remote method gets called with successful response
			// Logic to generate the random number from 0 (inclusive) to 3
			int random = new Random().nextInt(4);

			System.out.println("Random Number : " + random);
			
			// If 0 or 2 gets generated then pretending that remote method called with unsuccessful response that is exception
			if (random % 2 == 0) {
				throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
			}
		}

		return "Hello from Remote Backend!!!";
	}

	// Fallback method
	// This method gets called when all retry operations failed/remote service is down
	@Override
	public String getBackendResponseFallback(RuntimeException e) {
		System.out.println("All retries completed, so Fallback method called!!!");
		return "All retries completed, so Fallback method called!!!";
	}
}
