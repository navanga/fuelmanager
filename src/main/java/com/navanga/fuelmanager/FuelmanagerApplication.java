package com.navanga.fuelmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FuelmanagerApplication implements CommandLineRunner {

//	@Autowired
//	private FuelService fuelService;

	public static void main(String[] args) {
		SpringApplication.run(FuelmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<FuelStationPriceDTO>  fuelStationPriceDTOList = fuelService.findPriceByLocation("2155", FuelType.E10);
//
//		fuelStationPriceDTOList.stream().forEach(System.out::println);

	}
}
