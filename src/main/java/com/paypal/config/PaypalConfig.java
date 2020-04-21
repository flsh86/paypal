package com.paypal.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {
    @Value("${paypal.client.id}")
    private String clientId;
    @Value("${paypal.server.id}")
    private String serverId;
    @Value("${paypal.mode}")
    private String mode;

    public PaypalConfig() {
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
//        Map<String, String> configuration = new HashMap<>();
//        configuration.put("mode", mode);
//        return new APIContext(clientId, serverId, mode, configuration);
        return new APIContext(clientId, serverId, mode);
    }

}
