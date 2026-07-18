# Circulo de la Muerte

Circulo de la Muerte is a JavaFX desktop application that visually demonstrates the Josephus problem (also known as the "Josephus permutation" or "Circle of Death"). The app arranges a configurable number of people in a circle and removes them one by one according to the selected starting position and direction until only one survivor remains.

## What the app does

- Displays a circular visual representation of the Josephus problem
- Lets the user choose:
  - the number of people in the circle
  - the initial person to start the elimination
  - whether elimination proceeds clockwise or counter-clockwise
- Starts and restarts the simulation interactively
- Uses a circular doubly linked list to model the elimination process

## Project structure

- `src/main/java/` - Java source files, including the JavaFX controller and the main application entry point
- `src/main/resources/` - FXML layout, CSS styles, and images used by the interface
- `bin/` - shell entrypoint scripts for building and launching the application with Docker

## Entrypoints in `bin/`

- `bin/build.sh` - builds the Docker image used to run the JavaFX application
- `bin/linux.sh` - runs the container in a Linux environment with the required display settings
- `bin/wsl.sh` - builds the Docker image for a WSL-based workflow

## Requirements

- Docker
- A working graphical display environment (for Linux/WSL)
- Java 21 and Maven are needed if you want to run the project outside Docker

## Running with Docker

From the project root, build the image:

```bash
./bin/build.sh
```

Then run the app on Linux:

```bash
./bin/linux.sh .
```

For WSL, use:

```bash
./bin/wsl.sh .
```

Then run the image with a compatible X server configuration for your environment.

## Running locally with Maven

If you prefer not to use Docker, you can run the application directly with Maven:

```bash
mvn clean javafx:run
```

## Notes

- The interface is built with JavaFX FXML and includes a stylized background image, a slider for the number of participants, a starting position selector, direction selection, and start/restart controls.
- This project was initially a college assignment, then it was dockerized by the author with AI assist.
