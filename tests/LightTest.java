import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LightTest {

 private Light light;

 @Before
 public void setUp() {
  light = new Light();
 }

 @Test
 public void testTurnOn() {
  light.turnOn();
  assertTrue(light.isOn());
 }

 @Test
 public void testTurnOff() {
  light.turnOn();
  light.turnOff();
  assertFalse(light.isOn());
 }
}
