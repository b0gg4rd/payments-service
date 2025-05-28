package net.coatli.payments;

public interface StringLiterals {

  String PAYMENTS_PATH = "/payments";

  String PAYMENT_ID_PATH = "/{paymentId}";

  String HEADER_A0 = "a0";

  String LOG_CREATE_ONE_PAYMENT = "Operative create-one-payment '{}'";

  String LOG_PAYMENT_ID_CREATED = "Payment's unique identifier '{}'";

  String LOG_USE_CASE_CREATE_ONE_PAYMENT = "Create one payment command '{}'";

  String LOG_USE_CASE_RETRIEVE_ONE_PAYMENT = "Retrieve one payment query '{}'";

  String LOG_USE_CASE_UPDATE_ONE_PAYMENT = "Update one payment command '{}'";

  String LOG_RETRIEVE_ONE_PAYMENT = "Operative retrieve-one-payment '{}'";

  String LOG_PAYMENT_FOUND = "Payment found '{}'";

  String LOG_PARTIAL_UPDATE_ONE_PAYMENT = "Operative partial-update-one-payment '{}'";

  String LOG_USE_CASE_PARTIAL_UPDATE_ONE_PAYMENT = "Partial update one payment command '{}'";

  String LOG_PAYMENT_UPDATED = "Payment updated '{}'";

  String PAYMENTS_COLLECTION_NAME = "payments";

}
