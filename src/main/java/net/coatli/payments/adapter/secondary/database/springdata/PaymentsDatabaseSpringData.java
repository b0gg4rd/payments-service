package net.coatli.payments.adapter.secondary.database.springdata;

import lombok.RequiredArgsConstructor;
import net.coatli.payments.adapter.secondary.database.PaymentsDatabaseSecondaryAdapter;
import net.coatli.payments.adapter.secondary.database.springdata.model.mapper.PaymentsDatabaseSpringDataMapper;
import net.coatli.payments.adapter.secondary.database.springdata.repository.PaymentsSpringDataRepository;
import net.coatli.payments.application.model.Payment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PaymentsDatabaseSpringData implements PaymentsDatabaseSecondaryAdapter {

  private final PaymentsSpringDataRepository paymentsSpringDataRepository;

  private final PaymentsDatabaseSpringDataMapper paymentsDatabaseSpringDataMapper;

  @Override
  public Payment createOne(final Payment payment) {

    return
      paymentsDatabaseSpringDataMapper.paymentDocument2Payment(
        paymentsSpringDataRepository.save(
          paymentsDatabaseSpringDataMapper.payment2PaymentDocument(payment)));

  }

  @Override
  public Optional<Payment> retrieveOne(final String id) {

    return
      paymentsSpringDataRepository
        .findById(id)
        .flatMap(paymentDocument -> Optional.ofNullable(paymentsDatabaseSpringDataMapper.paymentDocument2Payment(paymentDocument)));

  }

  @Override
  public Optional<Payment> updateOne(final Payment payment) {

    return
      paymentsSpringDataRepository
        .findById(payment.getId())
        .map(
          paymentDocument -> paymentsDatabaseSpringDataMapper.paymentDocument2Payment(
            paymentsSpringDataRepository.save(paymentDocument.setStatus(payment.getStatus().name()))));

  }

}
