package com.example.PaypalDemoStore;

/*
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutController {

    
    @RequestMapping(method = RequestMethod.POST)
    public String postCheckout(HttpServletRequest request) {
        SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
        SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

        StringBuffer url = new StringBuffer();
        url.append("http://");
        url.append(request.getServerName());
        url.append(":");
        url.append(request.getServerPort());
        url.append(request.getContextPath());

        String returnURL = url.toString() + "/Checkout";
        String cancelURL = url.toString() + "/index.html";

        details.setReturnURL(returnURL);
        details.setCancelURL(cancelURL);

        setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);
        SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
        expressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutReq);

        // Configuration map containing signature credentials and other required configuration.
        // For a full list of configuration parameters refer in wiki page. 
        // (https://github.com/paypal/sdk-core-java/blob/master/README.md)
        Map<String,String> configurationMap =  getAcctAndConfig();
        
        // Creating service wrapper object to make an API call by loading configuration map.
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);
        try {
            SetExpressCheckoutResponseType setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);
        } catch (Exception e) {
            System.err.println("service.setExpressCheckout "+e);
        }


        return "OK, funcionou";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCheckout() {
        return "OK";
    }

	private Map<String,String> getAcctAndConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		configMap.putAll(getConfig());
				
		// Account Credential
		configMap.put("acct1.UserName", "jb-us-seller_api1.paypal.com");
		configMap.put("acct1.Password", "WX4WTU3S8MY44S7F");
		configMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");
		// Subject is optional, only required in case of third party permission
		//configMap.put("acct1.Subject", "");
		
		// Sample Certificate credential
		// configMap.put("acct2.UserName", "certuser_biz_api1.paypal.com");
		// configMap.put("acct2.Password", "D6JNKKULHN3G5B8A");
		// configMap.put("acct2.CertKey", "password");
		// configMap.put("acct2.CertPath", "resource/sdk-cert.p12");
		// configMap.put("acct2.AppId", "APP-80W284485P519543T");
		
		return configMap;
    }
    
	private Map<String,String> getConfig(){
		Map<String,String> configMap = new HashMap<String,String>();
		
		// Endpoints are varied depending on whether sandbox OR live is chosen for mode
		configMap.put("mode", "sandbox");
		

		// These values are defaulted in SDK. If you want to override default values, uncomment it and add your value.
		// configMap.put("http.ConnectionTimeOut", "5000");
		// configMap.put("http.Retry", "2");
		// configMap.put("http.ReadTimeOut", "30000");
		// configMap.put("http.MaxConnection", "100");
		return configMap;
	}
}
*/