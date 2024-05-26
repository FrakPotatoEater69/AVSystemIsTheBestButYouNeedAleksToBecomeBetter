# Elevator System Project

Welcome to the Elevator System Project! 🚀 This README will guide you through the functionality of the project, highlighting the key design patterns used and why this system is simply awesome.

## Table of Contents
- [Introduction](#introduction)
- [**Development Steps**](#development-steps)
- [Key Features](#key-features)
- [Design Patterns](#design-patterns)
- [How It Works](#how-it-works)
- [Usage](#usage)
- [Why This Project Rocks](#why-this-project-rocks)
- [Conclusion](#conclusion)

## Introduction

The Elevator System Project simulates an elevator control system that efficiently manages multiple elevators in a building. Whether you're dealing with high-rise office buildings or residential complexes, this project provides a scalable solution to handle elevator requests smoothly and effectively.

## Development Steps

### 1. Architecture Planning

Architecture planning is crucial for any application to ensure good scalability, allowing for future additions or adjustions in functionality. From the technical assignment, I read "Najprostsze rozwiązanie to FCFS (first-come, first-serve) wg kolejności zgłoszeń" and immediately realized that we could use the **Strategy** pattern for ElevatorSystem operation. This pattern allows changing the entire operation by simply replacing one interface implementation, which helps maintain low coupling. Embedding the functionality directly into the ElevatorSystem class would increase dependency and reduce flexibility. 

The interface for this pattern is named `Distributor`, and all its implementations are located in the `distributorImpl` package.

### 2. Elevator Functionality

For the elevators' functionality, I utilized two patterns: **Final-state machine** and **Command**. These patterns help maintain low coupling between parts of the application and allow for easy addition of new functionalities in the future.

- **Finite-state machine**: Manages the various states of the elevators. The states are stored in the `states` package, with the interface being `ElevatorState`.
- **Command pattern**: Encapsulates commands to be executed on the elevators. The `ElevatorCommand` interface and its implementations are located in the `commands` package.

### 3. Interface-Driven Design

At the start of the development, I chose an interface-driven design approach. This means initially describing all interfaces and planning their interactions. Once the interfaces were well-defined, I proceeded to implement the functionality.

### 4. Console Output

I considered creating a UI using JavaFX, where the `step()` method would execute every second for all elevators. However, simulating user actions in such a setup would be complex and time-consuming. Given the limited time available(as I mentioned, my delay in sending the solution was due to my love for my insurance agent), I decided to implement a console output for simplicity and clarity.

### 5. Elevator States and Commands

Elevators have four states, and as I developed the Distributors, I also created the corresponding commands. Following the SOLID principles was a priority throughout the development process to ensure a robust and maintainable system.

### 6. Main Class and User Input

The main class, `ElevatorSystem`, maintains a list of all elevators and contains the primary method, `run()`, which handles user input. For user input, a separate class, `ConsoleInputHandler`, was added. This class validates all (or almost all) user inputs using the `Validator` class and its static methods.

---

I hope this explanation provides a clear and detailed overview of the development process. If needed, I can delve into more specifics, but I wanted to keep this concise to respect your time 😁.


## Key Features
- **Efficient Elevator Dispatching**: Uses advanced algorithms to minimize wait times and optimize elevator movements.
- **Dynamic Command Handling**: Allows adding commands dynamically with checks to ensure the best service.
- **State Management**: Elevators seamlessly transition between different states (e.g., moving up, moving down, receiving orders).

## Design Patterns

### Strategy Pattern

The Strategy Pattern is employed to handle different distribution strategies for elevator requests. This allows the system to switch between various algorithms, such as First-Come-First-Serve or Same-Direction-Priority, without altering the core logic.

Classes implementing the Strategy Pattern:
- `Distributor` interface
- `FirstComeFirstServeDistributor` class

### Command Pattern

The Command Pattern encapsulates requests as objects, allowing parameterization of other objects with different requests, queuing of requests, and logging the history of requests. This pattern is used extensively for elevator commands to add, move, and execute various elevator operations.

Classes implementing the Command Pattern:
- `ElevatorCommand` interface
- Various command implementations like `AddCommandAsFirst`, `MoveToCommand`, `ReceiveCommand`, etc.

## How It Works
1. **Initialization**: The system initializes with a specified number of elevators and floors.
2. **Command Handling**: Commands such as moving to a floor or picking up a passenger are added dynamically based on real-time input.
3. **State Management**: Elevators change states based on their current activities and command queue, ensuring smooth transitions between operations.

## Usage

**Start the System**:
```
java -jar AVSystemIsTheBestButYouNeedAleksToBecomeBetter.jar <number_of_elevators> <number_of_floors>
```

**Example:**
```
java -jar AVSystemIsTheBestButYouNeedAleksToBecomeBetter.jar 4 10
```

**Commands**:
- **Order Elevator**: `pickup <floor number> <direction>`
- **Next Step**: `s`
- **Stop the System**: `stop`

Commands can be entered in the console to simulate real-time elevator requests and operations.

## Why This Project Rocks
- **Scalability**: Easily handles multiple elevators and complex request patterns.
- **Flexibility**: The use of design patterns ensures the system is easy to extend and modify.
- **Efficiency**: Intelligent algorithms minimize wait times and optimize elevator usage.
- **Maintainability**: Clean, well-structured code makes it easy to understand and maintain.

## Conclusion

This Elevator System Project demonstrates the power of good design and the effective use of design patterns. It's robust, efficient, and ready to tackle any elevator dispatching challenge. Whether you're a developer looking to understand the implementation of design patterns in a real-world scenario or a building manager in need of a reliable elevator system, this project has got you covered.

Enjoy the ride! 🎉


