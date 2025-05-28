package net.coatli.payments.adapter.secondary.database.springdata.repository;

import net.coatli.payments.adapter.secondary.database.springdata.model.PaymentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsSpringDataRepository extends MongoRepository<PaymentDocument, String> {
}
