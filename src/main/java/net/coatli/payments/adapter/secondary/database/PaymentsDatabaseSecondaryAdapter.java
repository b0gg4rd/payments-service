package net.coatli.payments.adapter.secondary.database;

import net.coatli.payments.application.model.Payment;

import java.util.Optional;

public interface PaymentsDatabaseSecondaryAdapter {

  Payment createOne(Payment payment);

  Optional<Payment> retrieveOne(String id);

  Optional<Payment> updateOne(Payment payment);

}
