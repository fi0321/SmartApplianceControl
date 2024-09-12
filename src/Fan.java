import java.util.logging.Logger;

public class Fan implements Appliance {
 private static final Logger logger = Logger.getLogger(Fan.class.getName());
 private int speed = 0; // 0 = off

 public Fan() {}

 @Override
 public void turnOn() {
  if (speed == 0) {
   speed = 1;
  }
  logger.info("Fan is now ON with speed " + speed);
 }

 @Override
 public void turnOff() {
  speed = 0;
  logger.info("Fan is now OFF.");
 }

 @Override
 public boolean isOn() {
  return speed > 0;
 }

 public int getSpeed() {
  return speed;
 }

 public void increaseSpeed() {
  if (speed < 2) {
   speed++;
  } else {
   speed = 0;
  }
  logger.info("Fan speed changed to: " + speed);
 }

 public void decreaseSpeed() {
  if (speed > 0) {
   speed--;
  } else {
   speed = 2;
  }
  logger.info("Fan speed changed to: " + speed);
 }
}
