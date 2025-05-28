package net.coatli.payments.application.model.mapper;

import net.coatli.payments.application.model.Payment;
import net.coatli.payments.application.model.RetrieveOnePaymentQueryOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RetrieveOnePaymentCommandUseCaseMapper {

  @Mapping(target = "payment", source = ".")
  RetrieveOnePaymentQueryOutput payment2RetrieveOnePaymentQueryOutput(Payment payment);

}
