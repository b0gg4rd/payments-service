package net.coatli.payments.adapter.secondary.messaging.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.payments.StringLiterals;
import net.coatli.payments.adapter.secondary.messaging.PaymentsMessagingSecondaryAdapter;
import net.coatli.payments.application.model.Payment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class PaymentsMessagingRabbitMq implements PaymentsMessagingSecondaryAdapter {

  private final RabbitTemplate rabbitTemplate;

  @Value("${rabbitmq.exchange}")
  private String exchange;

  @Value("${rabbitmq.routingkey}")
  private String routingKey;

  @Override
  public void sendStatusUpdated(final Payment payment) {

    rabbitTemplate.convertAndSend(
      exchange,
      routingKey,
      payment.toString());

    LOGGER.info(
      StringLiterals.STATUS_UPDATED_SENT,
      payment);

  }

}
