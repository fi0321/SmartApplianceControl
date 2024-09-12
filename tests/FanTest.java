import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FanTest {

 private Fan fan;

 @Before
 public void setUp() {
  fan = new Fan();
 }

 @Test
 public void testTurnOn() {
  fan.turnOn();
  assertTrue(fan.isOn());
 }

 @Test
 public void testTurnOff() {
  fan.turnOn();
  fan.turnOff();
  assertFalse(fan.isOn());
 }

 @Test
 public void testIncreaseSpeed() {
  fan.increaseSpeed(); // Increase speed from 0 to 1
  assertEquals(1, fan.getSpeed());

  fan.increaseSpeed(); // Increase speed from 1 to 2
  assertEquals(2, fan.getSpeed());

  fan.increaseSpeed(); // Cycle back to 0
  assertEquals(0, fan.getSpeed());
 }

 @Test
 public void testDecreaseSpeed() {
  fan.increaseSpeed(); // Fan speed should now be 1
  fan.increaseSpeed(); // Fan speed should now be 2
  fan.decreaseSpeed(); // Fan speed should now be 1
  assertEquals("Fan speed should decrease to 1", 1, fan.getSpeed());
 }

 @Test
 public void testMaxSpeedCycle() {
  fan.increaseSpeed(); // Speed = 1
  fan.increaseSpeed(); // Speed = 2
  fan.increaseSpeed(); // Speed = 0 (reset)
  assertEquals(0, fan.getSpeed());
 }
}
