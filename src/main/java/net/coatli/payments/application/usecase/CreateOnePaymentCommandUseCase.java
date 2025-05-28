package net.coatli.payments.application.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.payments.adapter.secondary.database.PaymentsDatabaseSecondaryAdapter;
import net.coatli.payments.application.model.CreateOnePaymentCommandInput;
import net.coatli.payments.application.model.CreateOnePaymentCommandOutput;
import net.coatli.payments.application.model.mapper.CreateOnePaymentCommandUseCaseMapper;
import net.coatli.payments.application.port.CreateOnePaymentCommand;
import net.coatli.payments.StringLiterals;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateOnePaymentCommandUseCase implements CreateOnePaymentCommand {

  private final PaymentsDatabaseSecondaryAdapter paymentsDatabaseSecondaryAdapter;

  private final CreateOnePaymentCommandUseCaseMapper createOnePaymentCommandUseCaseMapper;

  @Override
  public CreateOnePaymentCommandOutput execute(final CreateOnePaymentCommandInput createOnePaymentCommandInput) {

    LOGGER.info(
      StringLiterals.LOG_USE_CASE_CREATE_ONE_PAYMENT,
      createOnePaymentCommandInput);

    return
      createOnePaymentCommandUseCaseMapper.payment2CreateOnePaymentCommandOutput(
        paymentsDatabaseSecondaryAdapter.createOne(
          createOnePaymentCommandUseCaseMapper.createOnePaymentCommandInput2Payment(createOnePaymentCommandInput)));

  }

}
