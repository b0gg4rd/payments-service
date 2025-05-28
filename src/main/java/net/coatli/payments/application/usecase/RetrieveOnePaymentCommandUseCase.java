package net.coatli.payments.application.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.payments.StringLiterals;
import net.coatli.payments.adapter.secondary.database.PaymentsDatabaseSecondaryAdapter;
import net.coatli.payments.application.model.RetrieveOnePaymentQueryInput;
import net.coatli.payments.application.model.RetrieveOnePaymentQueryOutput;
import net.coatli.payments.application.model.mapper.RetrieveOnePaymentCommandUseCaseMapper;
import net.coatli.payments.application.port.RetrieveOnePaymentQuery;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RetrieveOnePaymentCommandUseCase implements RetrieveOnePaymentQuery {

  private final PaymentsDatabaseSecondaryAdapter paymentsDatabaseSecondaryAdapter;

  private final RetrieveOnePaymentCommandUseCaseMapper retrieveOnePaymentCommandUseCaseMapper;

  @Override
  public RetrieveOnePaymentQueryOutput execute(final RetrieveOnePaymentQueryInput retrieveOnePaymentQueryInput) {

    LOGGER.info(
      StringLiterals.LOG_USE_CASE_RETRIEVE_ONE_PAYMENT,
      retrieveOnePaymentQueryInput);

    return
      paymentsDatabaseSecondaryAdapter
        .retrieveOne(retrieveOnePaymentQueryInput.getId())
        .map(retrieveOnePaymentCommandUseCaseMapper::payment2RetrieveOnePaymentQueryOutput)
        .orElseGet(RetrieveOnePaymentQueryOutput::new);

  }

}
