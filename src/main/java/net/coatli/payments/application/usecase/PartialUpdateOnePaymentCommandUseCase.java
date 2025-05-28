package net.coatli.payments.application.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.payments.StringLiterals;
import net.coatli.payments.adapter.secondary.database.PaymentsDatabaseSecondaryAdapter;
import net.coatli.payments.adapter.secondary.messaging.PaymentsMessagingSecondaryAdapter;
import net.coatli.payments.application.model.PartialUpdateOnePaymentCommandInput;
import net.coatli.payments.application.model.PartialUpdateOnePaymentCommandOutput;
import net.coatli.payments.application.model.mapper.PartialUpdateOnePaymentCommandUseCaseMapper;
import net.coatli.payments.application.port.PartialUpdateOnePaymentCommand;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PartialUpdateOnePaymentCommandUseCase implements PartialUpdateOnePaymentCommand {

  private final PaymentsDatabaseSecondaryAdapter paymentsDatabaseSecondaryAdapter;

  private final PaymentsMessagingSecondaryAdapter paymentsMessagingSecondaryAdapter;

  private final PartialUpdateOnePaymentCommandUseCaseMapper partialUpdateOnePaymentCommandUseCaseMapper;

  @Override
  public PartialUpdateOnePaymentCommandOutput execute(final PartialUpdateOnePaymentCommandInput partialUpdateOnePaymentCommandInput) {

    LOGGER.info(
      StringLiterals.LOG_USE_CASE_PARTIAL_UPDATE_ONE_PAYMENT,
      partialUpdateOnePaymentCommandInput);

    return
      paymentsDatabaseSecondaryAdapter
        .updateOne(partialUpdateOnePaymentCommandUseCaseMapper.partialUpdateOnePaymentCommandInput2Payment(partialUpdateOnePaymentCommandInput))
        .map(
          payment -> {
            paymentsMessagingSecondaryAdapter.sendStatusUpdated(payment);
            return new PartialUpdateOnePaymentCommandOutput().setPayment(payment);
        })
        .orElse(new PartialUpdateOnePaymentCommandOutput());


  }

}
