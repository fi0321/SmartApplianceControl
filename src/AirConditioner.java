import java.util.logging.Logger;

public class AirConditioner implements Appliance {
 private static final Logger logger = Logger.getLogger(AirConditioner.class.getName());
 private boolean mode = false; // false = off, true = on
 private int temperature = 18;

 public AirConditioner() {}

 @Override
 public void turnOn() {
  mode = true;
  logger.info("Air Conditioner is now ON.");
 }

 @Override
 public void turnOff() {
  mode = false;
  logger.info("Air Conditioner is now OFF.");
 }

 @Override
 public boolean isOn() {
  return mode;
 }

 public int getTemperature() {
  return temperature;
 }

 public void increaseTemp() {
  if (mode && temperature < 31) {
   temperature++;
   logger.info("Temperature increased to: " + temperature);
  }
 }

 public void decreaseTemp() {
  if (mode && temperature > 16) {
   temperature--;
   logger.info("Temperature decreased to: " + temperature);
  }
 }
}
