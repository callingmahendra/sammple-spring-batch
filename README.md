# sammple-spring-batch

## Project Description

This project is a sample Spring Batch application that demonstrates how to configure and run a batch job using Spring Batch and Spring Boot.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/callingmahendra/sammple-spring-batch.git
   cd sammple-spring-batch
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Configuration

The application is configured to read input data from a CSV file located at `src/main/resources/sample-data.csv`. The batch job processes the data and writes the output to the console.

## License

This project is licensed under the Apache License, Version 2.0. See the [LICENSE](LICENSE) file for details.
