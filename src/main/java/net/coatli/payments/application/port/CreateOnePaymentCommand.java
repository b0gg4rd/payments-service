package net.coatli.payments.application.port;

import net.coatli.payments.application.model.CreateOnePaymentCommandInput;
import net.coatli.payments.application.model.CreateOnePaymentCommandOutput;

public interface CreateOnePaymentCommand {

  CreateOnePaymentCommandOutput execute(CreateOnePaymentCommandInput createOnePaymentCommandInput);

}
