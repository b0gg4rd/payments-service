package net.coatli.payments.adapter.secondary.messaging;

import net.coatli.payments.application.model.Payment;

public interface PaymentsMessagingSecondaryAdapter {

   void sendStatusUpdated(Payment payment);

}
