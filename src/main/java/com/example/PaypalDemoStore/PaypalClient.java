package com.example.PaypalDemoStore;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

public class PaypalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "AQjqpbGtWF1n5gJRJAUTTyX4lzdRzalI48T3mybRUVciLii2DAvazh3N1bUUir2UpUgXtg4zWl0Mushe",
    "EHm451-YYn5O1B67-Mfzq3TTZg9Z3bld92Rbn0vCp9ZXEPhzD_qeqRY7_qqMsx1H-JyQ77FrjMbkVTt4");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}