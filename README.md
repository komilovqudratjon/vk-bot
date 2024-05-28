

# VK Bot Integration with Spring Boot

## Overview

This project is a Spring Boot application that integrates with VK's BotAPI. The bot's primary functionality is to echo back any text sent to it. This repository contains the complete source code for the bot, configuration files, and instructions on how to set up and run the application.

## Features

- **Echo Bot**: The bot will reply with the same text that it receives.
- **Spring Boot**: The application is built using Spring Boot.
- **Configuration Files**: All necessary parameters for the application are configurable via `application.yml`.
- **POJO & Kotlin Data Classes**: All interaction entities are represented as POJOs for Java and data classes for Kotlin.
- **Kotlin Support**: The use of Kotlin is a plus but not mandatory.
- **No External VkApi Libraries**: The implementation does not use any pre-built VkApi libraries for Java.
- **ngrok Support**: The application supports using `ngrok` for exposing localhost to the internet.

## Requirements

- Java 11+
- Maven or Gradle
- ngrok (for local development)
- VK account and Bot setup

### Obtaining VK Access Token

1. **Register your application** on [VK's developer page](https://vk.com/dev).
2. **Authorize your application** using the following URL format:

    ```
    https://oauth.vk.com/authorize?client_id=YOUR_APP_ID&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=groups,offline&response_type=token&v=5.131
    ```

   Replace `YOUR_APP_ID` with your application's ID.

3. **Get the Access Token**:

   After authorizing the application, you will be redirected to a URL similar to:

    ```
    https://oauth.vk.com/blank.html#access_token=vk1.a.your_access_token&expires_in=0&user_id=your_user_id
    ```

   Copy the `access_token` from the URL.

## Configuration

The application requires several configuration parameters which should be set in the `application.yml` file:

```yaml
vk:
  token: YOUR_VK_BOT_TOKEN
  groupId: YOUR_VK_GROUP_ID

server:
  port: 8888
```

## Setup and Running

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have JDK 11 or higher installed.
2. **Build Tool**: Either Maven or Gradle should be installed.
3. **ngrok**: Install ngrok for creating a secure tunnel to your localhost.

### Steps

1. **Clone the Repository**:

    ```sh
    git clone https://github.com/komilovqudratjon/vk-bot.git
    cd vk-bot-spring-boot
    ```

2. **Configure Application**:

   Open the `src/main/resources/application.properties` file and update the `vk.api.token` and `vk.api.confirmation_token` 

3. **Run ngrok**:

    ```sh
    ngrok http 8888
    ```

   Copy the generated `https` URL from ngrok and set it as your callback URL in VK's bot settings.

4. **Build and Run the Application**:

    - **Using Maven**:

        ```sh
        mvn clean install
        mvn spring-boot:run
        ```

5. **Test the Bot**:

   Send a message to your VK bot, and it should reply with the same text.

## Project Structure

- **src/main/java/com/example/vkbot**: Contains the main application code.
  - **VkBotApplication.java**: The main Spring Boot application class.
  - **config**: Contains configuration classes.
  - **controller**: Contains the controller classes for handling incoming requests.
  - **model**: Contains POJOs and data classes for representing VK entities.
  - **service**: Contains service classes for handling bot logic.
- **src/main/resources**: Contains configuration files and other resources.


## Troubleshooting

- **Bot not responding**: Check if ngrok is running and the callback URL in VK's settings is correct.
- **Configuration errors**: Ensure all necessary parameters are correctly set in the `application.yml`.

## Contributing

If you have any suggestions or find any issues, please feel free to open an issue or submit a pull request or contact me at [Telegram](https://t.me/ProgrammerAndEngineer).
