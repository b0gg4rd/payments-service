package net.coatli.payments.application.model.mapper;

import net.coatli.payments.application.model.CreateOnePaymentCommandInput;
import net.coatli.payments.application.model.CreateOnePaymentCommandOutput;
import net.coatli.payments.application.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateOnePaymentCommandUseCaseMapper {

  @Mapping(target = ".", source = "payment")
  Payment createOnePaymentCommandInput2Payment(CreateOnePaymentCommandInput createOnePaymentCommandInput);

  @Mapping(target = "id", source = "payment.id")
  CreateOnePaymentCommandOutput payment2CreateOnePaymentCommandOutput(Payment payment);

}
