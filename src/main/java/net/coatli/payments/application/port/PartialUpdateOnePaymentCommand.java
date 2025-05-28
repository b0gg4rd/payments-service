package net.coatli.payments.application.port;

import net.coatli.payments.application.model.PartialUpdateOnePaymentCommandInput;
import net.coatli.payments.application.model.PartialUpdateOnePaymentCommandOutput;

public interface PartialUpdateOnePaymentCommand {

  PartialUpdateOnePaymentCommandOutput execute(PartialUpdateOnePaymentCommandInput createOnePaymentCommandInput);

}
