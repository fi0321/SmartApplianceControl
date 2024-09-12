import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AirConditionerTest {

 private AirConditioner airConditioner;

 @Before
 public void setUp() {
  airConditioner = new AirConditioner();
 }

 @Test
 public void testTurnOn() {
  airConditioner.turnOn();
  assertTrue(airConditioner.isOn());
 }

 @Test
 public void testTurnOff() {
  airConditioner.turnOn();
  airConditioner.turnOff();
  assertFalse(airConditioner.isOn());
 }

 @Test
 public void testIncreaseTemp() {
  airConditioner.turnOn();
  int initialTemp = airConditioner.getTemperature();
  airConditioner.increaseTemp();
  assertEquals(initialTemp + 1, airConditioner.getTemperature());
 }

 @Test
 public void testDecreaseTemp() {
  airConditioner.turnOn();
  int initialTemp = airConditioner.getTemperature();
  airConditioner.decreaseTemp();
  assertEquals(initialTemp - 1, airConditioner.getTemperature());
 }

 @Test
 public void testCannotIncreaseTempAboveMax() {
  airConditioner.turnOn();
  while (airConditioner.getTemperature() < 31) {
   airConditioner.increaseTemp();
  }
  airConditioner.increaseTemp();
  assertEquals(31, airConditioner.getTemperature());
 }

 @Test
 public void testCannotDecreaseTempBelowMin() {
  airConditioner.turnOn();
  while (airConditioner.getTemperature() > 16) {
   airConditioner.decreaseTemp();
  }
  airConditioner.decreaseTemp();
  assertEquals(16, airConditioner.getTemperature());
 }
}
