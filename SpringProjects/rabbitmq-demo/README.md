# RabbitMQ + Spring Boot Demo

## Prerequisites
- Erlang installed (required by RabbitMQ)
- RabbitMQ server installed and running (`net start rabbitmq`)
- Java 17+
- Maven (or use the IDE's built-in Maven support)

## Run

```
mvn spring-boot:run
```

The app starts on `http://localhost:8080`.

## Test it

Send an order:

```
curl -X POST "http://localhost:8080/orders?order=Order123"
```

Watch the console output — you should see:

```
Sent: Order123
Received: Order123
```

## RabbitMQ Management UI

http://localhost:15672 (user: guest / pass: guest)

Check the **Queues** tab for `orderQueue` to watch message flow.

## Project structure

- `config/RabbitConfig.java` — defines the exchange, queue, and binding
- `producer/OrderProducer.java` — sends messages
- `consumer/OrderConsumer.java` — listens and receives messages
- `controller/OrderController.java` — REST endpoint to trigger sending
