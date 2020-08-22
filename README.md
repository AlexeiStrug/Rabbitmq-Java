# Rabbitmq-Java
Simple project with different types of messaging

# Getting started 
Execute docker commad for run rabbitmq on localhost:
```bash
   docker run -d --hostname docker-rabbitmq -p 5672:5672 -p 15672:15672 --name rabbitmq -v rabbitmq:/var/lib/rabbitmq  rabbitmq:management 
``````

Configure Producers and Consumers which provided in Java classes.
