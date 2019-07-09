# A web page to simulate a basic shopping cart page on a web store.

1. Whether the page looks nice does not matter. However, it must be clear to avoid
user confusion.
2. It shows at least one product with its name, item number and price.
3. It shows the buyer’s information: her first name, last name, email, phone number
and shipping address (country, state, zip, street). The shipping address shall be a valid
address in the US. All buyer information shall be prefilled in editable HTML fields on the page.
4. The button to initiate PayPal payment process. This button shall be rendered by the
PayPal client side script integrated on this page and the advanced server integration.
5. Server side program(s).
    * The server side program(s) shall be developed using the advanced server integration
of PayPal Express Checkout.
    * You can either develop the program(s) by yourself from scratch, or integrate a
PayPal SDK.
8. The payment process
    *    The payment process shall be initiated by the user clicking the button mentioned
above, using the advanced integration of PayPal Express Checkout.
    * The buyer’s information shall be passed to PayPal so that the buyer does not have to
input any of her information on PayPal again.
9. A thank-you page
    * The buyer shall go back to your thank-you page after checkout on PayPal side.
    * The thank-you page shall display the transaction ID created for this checkout