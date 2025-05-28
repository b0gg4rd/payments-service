package net.coatli.payments.adapter.primary.httpapi.model;

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
public class CreateOnePaymentRequest {

  private String a1;

  private Integer a2;

  private String a3;

  private String a4;

  private BigDecimal a5;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
