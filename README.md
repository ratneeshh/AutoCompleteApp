# Autocomplete System

This project implements a text autocomplete system using a Trie data structure in Java, with a JavaFX user interface. The application suggests possible completions for the prefix entered by the user.

## Project Overview

The autocomplete system efficiently stores a dynamic set of strings where keys are usually strings. It provides suggestions based on prefix matching using a Trie. This project also includes a JavaFX-based graphical user interface to interact with the autocomplete system.

## Features

- Efficient prefix matching using a Trie data structure.
- Autocomplete suggestions based on user input.
- Frequency-based suggestions: more frequently used words appear higher in the suggestions.
- Simple and intuitive JavaFX-based graphical user interface.

## Technologies Used

- Java
- JavaFX
- Maven

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6.0 or higher
- JavaFX SDK 17.0.1

### Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/my-autocomplete-app.git
    cd my-autocomplete-app
    ```

2. **Download and set up JavaFX SDK:**

    - Download the JavaFX SDK from the [Gluon website](https://gluonhq.com/products/javafx/).
    - Extract the JavaFX SDK to a known location on your system.

3. **Configure JavaFX in IntelliJ IDEA:**

    - Open the project in IntelliJ IDEA.
    - Go to `Run -> Edit Configurations`.
    - Select your `AutoCompleteApp` run configuration.
    - In the `VM options` field, add the following line, replacing `/path/to/javafx-sdk-17/lib` with the actual path to the `lib` directory of your JavaFX SDK:

      ```text
      --module-path /path/to/javafx-sdk-17/lib --add-modules javafx.controls,javafx.fxml
      ```

4. **Build the project:**

    ```sh
    mvn clean install
    ```

## Usage

1. **Run the application:**

    - In IntelliJ IDEA, go to `Run -> Run 'AutoCompleteApp'` or press `Shift + F10`.

2. **Using the application:**

    - Start typing in the text field to see autocomplete suggestions.
    - Click on a suggestion to autofill the text field.
    - The Trie data structure will dynamically learn new words as you type and select suggestions.


