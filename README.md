# Perfomance Test for Kafka and RabbitMQ + WebUI interface

Perfomance Test for Kafka + RabbitMQ written in Java with Env.Variables for Kubernetes following Twelve-Factor App methodology
to segregate server configuration from app.

It also helps you to control the app.


# It works out-of-box, and it's full customized!

I also build a very simple WebUI for Producer and Consumer in HTML: Path is "localhost:8989/producer" and "localhost:8990/consumer".

You can port-forward it:

kubectl port-forward service/producer 8989:8989

kubectl port-forward service/consumer 8990:8989

Docker images fails if you don't pass the same env. variables that we have inside of Kubernetes manifests:

Docker Image for Producer: docker pull neuhausmatheus/producer:v2.0.1

Docker Image for Consumer: docker pull neuhausmatheus/consumer:v2.0.1


# Take a look into "screenshot" folder to have an idea of what we have here!
