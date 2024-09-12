# Smart Home Appliance Control System

## Overview

This project simulates a smart home appliance control system that allows users to manage different appliances: **Light**, **Fan**, and **Air Conditioner**. The appliances can be turned on, off, and adjusted based on their specific behavior. Additionally, the system automatically shuts down all appliances on January 1st, at 1:00 AM every year for maintenance.

## Classes

### 1. `Light`

The `Light` class represents a smart light with the following features:

- **Power Control**: The light can be toggled on and off by switching the power.

### 2. `Fan`

The `Fan` class represents a smart fan with the following features:

- **Speed Control**: The fan has three speed settings (0, 1, and 2).
  - Speed 0: The fan is off.
  - Speed 1 and 2: The fan operates at increasing speeds.
- **Adjustable Speed**: Users can increase and decrease the fan speed. If the fan is at the maximum speed, increasing it will reset it to 0.

### 3. `AirConditioner`

The `AirConditioner` class represents a smart air conditioner with the following features:

- **Mode Control**: The air conditioner can be toggled between on and off.
- **Temperature Control**: The air conditioner allows temperature adjustment between 16°C and 31°C. It can only be adjusted when the air conditioner is on.

### 4. `SmartHomeController`

The `SmartHomeController` class provides an interactive console interface for controlling the smart home appliances. It allows the user to:

- **Control Light**: Toggle the power of the light.
- **Control Fan**: Adjust the speed of the fan.
- **Control Air Conditioner**: Toggle the power and adjust the temperature of the air conditioner.
- **Automatic Update**: On January 1st, at 1:00 AM every year, the system will automatically turn off all appliances for maintenance.

## Usage

### 1. Compile and Run the Application

- **Compile**:

javac src/\*.java -d bin

## Run:

java -cp bin SmartHomeController

## 2. Start the Application

When the application is run, users are presented with a menu for controlling the appliances. They can:

- Control the **Light**, **Fan**, or **Air Conditioner**.
- Quit the application.

## 3. Menu Options

- **Option 1**: Control the Light.
  - Toggle the light on or off.
- **Option 2**: Control the Fan.
  - Increase or decrease the fan speed.
- **Option 3**: Control the Air Conditioner.
  - Turn the air conditioner on or off.
  - Adjust the temperature (when the AC is on).
- **Option 4**: Quit the application.

## 4. Fan Behavior

- pressing the increase speed control will increase the speed, resetting to 0 after reaching the maximum (2) and vice versa when it reaches 0.

## 5. Air Conditioner Behavior

- The air conditioner can only adjust the temperature when it's on. The temperature can be increased or decreased between 16°C and 31°C.

## 6. System Update

- On January 1st, at 1:00 AM, all appliances are turned off for the yearly update. No other actions can be taken during this period.

## Running Tests

### 1. Compile the Tests

First, compile the test files.

use this command to compile the tests:

- javac -cp "bin;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" -d bin tests/\*.java

### 2. Run the Tests

After compiling, you can run the tests using the JUnit test runner. For example, to run the LightTest, FanTest, or AirConditionerTest, you can use the following command:

- java -cp "bin;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore LightTest

Replace LightTest with FanTest or AirConditionerTest to run the corresponding tests.
