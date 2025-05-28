package net.coatli.payments.adapter.primary.httpapi.model.mapper;

import net.coatli.payments.adapter.primary.httpapi.model.CreateOnePaymentRequest;
import net.coatli.payments.adapter.primary.httpapi.model.PartialUpdateOnePaymentRequest;
import net.coatli.payments.adapter.primary.httpapi.model.RetrieveOnePaymentResponse;
import net.coatli.payments.application.model.CreateOnePaymentCommandInput;
import net.coatli.payments.application.model.PartialUpdateOnePaymentCommandInput;
import net.coatli.payments.application.model.Payment;
import net.coatli.payments.application.model.RetrieveOnePaymentQueryInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonsHttpApiAdapterMapper {

  @Mapping(target = "payment.subject",  source = "a1")
  @Mapping(target = "payment.quantity", source = "a2")
  @Mapping(target = "payment.from",     source = "a3")
  @Mapping(target = "payment.to",       source = "a4")
  @Mapping(target = "payment.amount",   source = "a5")
  CreateOnePaymentCommandInput createOnePaymentRequest2CreateOnePaymentCommandInput(CreateOnePaymentRequest createOnePaymentRequest);

  @Mapping(target = "id", source = "paymentId")
  RetrieveOnePaymentQueryInput toRetrieveOnePaymentQueryInput(String paymentId);

  @Mapping(target = "a0", source = "id")
  @Mapping(target = "a1", source = "subject")
  @Mapping(target = "a2", source = "quantity")
  @Mapping(target = "a3", source = "from")
  @Mapping(target = "a4", source = "to")
  @Mapping(target = "a5", source = "amount")
  @Mapping(target = "a6", source = "status")
  RetrieveOnePaymentResponse payment2RetrieveOnePaymentResponse(Payment payment);

  @Mapping(target = "id",     source = "paymentId")
  @Mapping(target = "status", source = "partialUpdateOnePaymentRequest.a6")
  PartialUpdateOnePaymentCommandInput toPartialUpdateOneCommandInput(String paymentId,
                                                                     PartialUpdateOnePaymentRequest partialUpdateOnePaymentRequest);

}
