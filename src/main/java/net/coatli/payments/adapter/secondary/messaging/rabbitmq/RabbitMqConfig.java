package net.coatli.payments.adapter.secondary.messaging.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  @Value("${rabbitmq.exchange}")
  private String exchange;

  @Value("${rabbitmq.queue}")
  private String queue;

  @Value("${rabbitmq.routingkey}")
  private String routingKey;

  @Bean
  public DirectExchange exchange() {

    return
      new DirectExchange(exchange);

  }

  @Bean
  public Queue queue() {

    return
      new Queue(
        queue,
        true);

  }

  @Bean
  public Binding binding(final Queue queue,
                         final DirectExchange exchange) {

    return
      BindingBuilder
        .bind(queue)
        .to(exchange)
        .with(routingKey);

  }

}
