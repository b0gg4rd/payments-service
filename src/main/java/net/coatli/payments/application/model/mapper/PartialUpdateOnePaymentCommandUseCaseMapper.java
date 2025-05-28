package net.coatli.payments.application.model.mapper;

import net.coatli.payments.application.model.PartialUpdateOnePaymentCommandInput;
import net.coatli.payments.application.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartialUpdateOnePaymentCommandUseCaseMapper {

  @Mapping(target = "id",     source = "id")
  @Mapping(target = "status", source = "status")
  Payment partialUpdateOnePaymentCommandInput2Payment(PartialUpdateOnePaymentCommandInput partialUpdateOnePaymentCommandInput);

}
