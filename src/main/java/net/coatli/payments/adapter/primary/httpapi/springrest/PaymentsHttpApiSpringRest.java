package net.coatli.payments.adapter.primary.httpapi.springrest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coatli.payments.adapter.primary.httpapi.model.CreateOnePaymentRequest;
import net.coatli.payments.adapter.primary.httpapi.model.PartialUpdateOnePaymentRequest;
import net.coatli.payments.adapter.primary.httpapi.model.RetrieveOnePaymentResponse;
import net.coatli.payments.adapter.primary.httpapi.model.mapper.PersonsHttpApiAdapterMapper;
import net.coatli.payments.application.port.CreateOnePaymentCommand;
import net.coatli.payments.StringLiterals;
import net.coatli.payments.application.port.PartialUpdateOnePaymentCommand;
import net.coatli.payments.application.port.RetrieveOnePaymentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(StringLiterals.PAYMENTS_PATH)
public class PaymentsHttpApiSpringRest {

  private final CreateOnePaymentCommand createOnePaymentCommand;

  private final RetrieveOnePaymentQuery retrieveOnePaymentQuery;

  private final PartialUpdateOnePaymentCommand partialUpdateOnePaymentCommand;

  private final PersonsHttpApiAdapterMapper personsHttpApiAdapterMapper;

  @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createOnePayment(@RequestBody final CreateOnePaymentRequest createOnePaymentRequest) {

    LOGGER.info(
      StringLiterals.LOG_CREATE_ONE_PAYMENT,
      createOnePaymentRequest);

    final var createOnePaymentCommandOutput = createOnePaymentCommand.execute(personsHttpApiAdapterMapper.createOnePaymentRequest2CreateOnePaymentCommandInput(createOnePaymentRequest));

    LOGGER.info(
      StringLiterals.LOG_PAYMENT_ID_CREATED,
      createOnePaymentCommandOutput.getId());

    return
      ResponseEntity
        .status(HttpStatus.CREATED)
        .header(
          StringLiterals.HEADER_A0,
          createOnePaymentCommandOutput.getId())
        .build();

  }

  @GetMapping(
    value = StringLiterals.PAYMENT_ID_PATH,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RetrieveOnePaymentResponse> retrieveOnePayment(@PathVariable final String paymentId) {

    LOGGER.info(
      StringLiterals.LOG_RETRIEVE_ONE_PAYMENT,
      paymentId);

    final var retrieveOnePaymentQueryOutput = retrieveOnePaymentQuery.execute(personsHttpApiAdapterMapper.toRetrieveOnePaymentQueryInput(paymentId));

    LOGGER.info(
      StringLiterals.LOG_PAYMENT_FOUND,
      retrieveOnePaymentQueryOutput);

    return
      Optional
        .ofNullable(retrieveOnePaymentQueryOutput.getPayment())
        .map(personsHttpApiAdapterMapper::payment2RetrieveOnePaymentResponse)
        .map(retrieveOnePaymentResponse ->
          ResponseEntity
            .ok()
            .body(retrieveOnePaymentResponse))
        .orElseGet(() -> ResponseEntity.notFound().build());

  }

  @PatchMapping(
    value = StringLiterals.PAYMENT_ID_PATH,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> updateOnePayment(@PathVariable final String paymentId,
                                           @RequestBody final PartialUpdateOnePaymentRequest partialUpdateOnePaymentRequest) {

    LOGGER.info(
      StringLiterals.LOG_PARTIAL_UPDATE_ONE_PAYMENT,
      partialUpdateOnePaymentRequest);

    final var partialUpdateOnePaymentCommandOutput = partialUpdateOnePaymentCommand.execute(
      personsHttpApiAdapterMapper.toPartialUpdateOneCommandInput(
        paymentId,
        partialUpdateOnePaymentRequest));

    LOGGER.info(
      StringLiterals.LOG_PAYMENT_UPDATED,
      partialUpdateOnePaymentCommandOutput);

    return
      Optional
        .ofNullable(partialUpdateOnePaymentCommandOutput.getPayment())
        .map(payment -> ResponseEntity.noContent().build())
        .orElseGet(() -> ResponseEntity.notFound().build());

  }

}
