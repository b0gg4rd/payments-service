package net.coatli.payments.adapter.secondary.database.springdata.model.mapper;

import net.coatli.payments.adapter.secondary.database.springdata.model.PaymentDocument;
import net.coatli.payments.application.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentsDatabaseSpringDataMapper {

  PaymentDocument payment2PaymentDocument(Payment payment);

  Payment paymentDocument2Payment(PaymentDocument paymentDocument);

}
