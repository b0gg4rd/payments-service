package net.coatli.payments.application.port;

import net.coatli.payments.application.model.RetrieveOnePaymentQueryInput;
import net.coatli.payments.application.model.RetrieveOnePaymentQueryOutput;

public interface RetrieveOnePaymentQuery {

  RetrieveOnePaymentQueryOutput execute(RetrieveOnePaymentQueryInput retrieveOnePaymentQueryInput);

}
