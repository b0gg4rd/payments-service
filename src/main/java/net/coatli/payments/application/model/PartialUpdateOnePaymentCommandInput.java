package net.coatli.payments.application.model;

import com.jsoniter.output.JsonStream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(
  chain = true,
  fluent = false)
@NoArgsConstructor
public class PartialUpdateOnePaymentCommandInput {

  private String id;

  private String status;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
