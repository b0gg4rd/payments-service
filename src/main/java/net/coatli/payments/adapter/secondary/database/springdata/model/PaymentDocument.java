package net.coatli.payments.adapter.secondary.database.springdata.model;

import com.jsoniter.output.JsonStream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.coatli.payments.StringLiterals;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(
  chain = true,
  fluent = false)
@NoArgsConstructor
@Document(collection = StringLiterals.PAYMENTS_COLLECTION_NAME)
public class PaymentDocument {

  private String id;

  private String subject;

  private Integer quantity;

  private String from;

  private String to;

  private BigDecimal amount;

  private String status;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
