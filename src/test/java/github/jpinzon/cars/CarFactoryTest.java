package github.jpinzon.cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

	@Test
	public void testCarFactory() {
		Assertions.assertTrue(CarFactory.getCar("Electrical", "Example field") instanceof ElectricalCar);
		Assertions.assertTrue(CarFactory.getCar("Petrol", "Example field") instanceof PetrolCar);
		Assertions.assertTrue(CarFactory.getCar("Diesel", "Example field") instanceof DieselCar);
		Assertions.assertTrue(CarFactory.getCar("Hybrid", "Example field") instanceof HybridCar);
	}
}
