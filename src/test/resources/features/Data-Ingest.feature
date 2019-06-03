Feature: Data Ingestion - validating the data flowing from upstream systems into Google Pub Sub

  @Data_Checks
  Scenario Outline: Verify and validate the data flowing from upstream source systems to GCP via the SDP platform
    Given Once the raw data is extracted from "<kafka_topic_name>" Kafka source system
    When the target messages from GCS avro file stored in "<target_file_path>" are extracted
    #When the target messages from Google Pub Sub Topic <pub_sub_topic_name> and Subscription <sub_name> , include for schema file as well-  is read and converted to JSON format
    Then convert the target avro file into json format
    And other than the "<exclude>" attributes, ensure that all the attributes between source and target are matching with "<primary_keys>" as primary keys

    Examples: 
      | kafka_topic_name                     | target_file_path | primary_keys | exclude                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
      | GB-PAYMENTS_MANAGER-PURCHASE-SUCCESS | meta/            | null         | requestId,entitlements_id,orderId,advice_referenceIds,delivery_email,delivery_addressee_lastName,delivery_addressee_firstName,delivery_address_town,delivery_address_countryCode,delivery_address_country,delivery_address_addressLine2,delivery_address_addressLine3,delivery_address_addressLine1,delivery_address_postCode,delivery_address_houseName,delivery_address_nif,delivery_address_province,delivery_address_customsCountryCode,payment_paymentTransactionId,payment_lastDigits,payment_expiryDate,payment_paymentProvider,payment_issuerCountry,payment_signupEmail,referrerInformation_deviceModel,householdId,billingAddress_addressLine1,billingAddress_town,billingAddress_postcode,billingAddress_countryCode,deviceId,userId,activityTimestamp,products_relevantContext_nextRenewalDueDate,products_relevantContext_endDate,products_relevantContext_startDate,subscriptions_updated_context_nextRenewalDueDate,subscriptions_updated_context_startDate,payment_amountAuthorised,charges_tenureNonDiscountedAmountTotal,charges_discounts_value,charges_savingAmount,charges_rate,charges_pointOfSaleAmount,charges_amount,charges_nextRenewalAmount,charges_fullAmount,chargeTotals_nonRecurring_fullAmount,chargeTotals_nonRecurring_pointOfSaleAmount,chargeTotals_total_nextRenewalAmount,chargeTotals_total_fullAmount,chargeTotals_total_pointOfSaleAmount,chargeTotals_recurring_fullAmount,chargeTotals_recurring_pointOfSaleAmount |

  @Date_Compare
  Scenario Outline: Check whether the source file Date column values are matching with Target file Date column values
    Given locate the file "<input_feed_name>" to perform date validation
    When the given file is opened and <source_format>, <target_format> formats are received
    Then On comparing the "<date_column>" it should match for the given "<region>"

    Examples: 
      | input_feed_name                      | source_format      | target_format                  | date_column       | region |
      | GB-PAYMENTS_MANAGER-PURCHASE-SUCCESS | "dd/MM/yyyy HH:mm" | "yyyy-MM-dd'T'HH:mm:SS.SSS'Z'" | activityTimestamp | GB     |

  @PII_Compare
  Scenario Outline: Check whether the source PII column values are matching with Target PII column values (Excluding Email)
    Given locate the file "<input_feed_name>" to perform PII validation
    When the file is opened from the given location for PII comparison
    Then On comparing the "<pii_column>" it should match

    Examples: 
      | input_feed_name                      | pii_column |
      | GB-PAYMENTS_MANAGER-PURCHASE-SUCCESS | deviceId   |

  @PII_EMAIL_Compare
  Scenario Outline: Check whether the source PII Email column values are matching with Target PII Email column values
    Given locate the file "<input_feed_name>" to perform PII validation
    When the file is opened from the given location for PII comparison
    Then On comparing the <pii_email_column>, the obfuscated email should match with expected value

    Examples: 
      | input_feed_name                      | pii_email_column |
      | GB-PAYMENTS_MANAGER-PURCHASE-SUCCESS | email            |

  @Currency_Compare
  Scenario Outline: Check whether the source file Currency column values are matching with Target file Date column values
    Given locate the file "<input_feed_name>" to perform Currency validation
    When the file is opened from the given location for currency comparison
    Then On comparing the <currency_column>, the source amount should match with target amount

    Examples: 
      | input_feed_name                      | currency_column |
      | GB-PAYMENTS_MANAGER-PURCHASE-SUCCESS | email           |
