package net.coatli.payments.application.model;

import com.jsoniter.output.JsonStream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(
  chain = true,
  fluent = false)
@NoArgsConstructor
public class Payment {

  private String id;

  private String subject;

  private Integer quantity;

  private String from;

  private String to;

  private BigDecimal amount;

  private PaymentStatus status;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
