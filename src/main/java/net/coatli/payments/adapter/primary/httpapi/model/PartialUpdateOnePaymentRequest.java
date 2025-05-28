package net.coatli.payments.adapter.primary.httpapi.model;

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
public class PartialUpdateOnePaymentRequest {

  private String a6;

  @Override
  public String toString() {
    return JsonStream.serialize(this);
  }

}
