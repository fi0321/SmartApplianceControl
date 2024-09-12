import java.util.logging.Logger;

public class Light implements Appliance {
 private static final Logger logger = Logger.getLogger(Light.class.getName());
 private boolean power = false;

 public Light() {}

 @Override
 public void turnOn() {
  power = true;
  logger.info("Light is now ON.");
 }

 @Override
 public void turnOff() {
  power = false;
  logger.info("Light is now OFF.");
 }

 @Override
 public boolean isOn() {
  return power;
 }
}
