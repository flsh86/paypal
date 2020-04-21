package com.paypal.rest;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.order.OrderDTO;
import com.paypal.service.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaypalController {
    private PayPalService payPalService;

    @Autowired
    public PaypalController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @PostMapping
    public String payment(@RequestBody OrderDTO orderDTO) throws PayPalRESTException {
        try {
            Payment payment = payPalService.createPayment(orderDTO);
            for (Links link : payment.getLinks()) {
                if(link.getRel().equalsIgnoreCase("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            System.err.println(e);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/success")
    public String successfulPayment(
            @RequestParam(name = "paymentId") String paymentId,
            @RequestParam(name = "PayerID") String payerId) {
            try {
                Payment payment = payPalService.executePayment(paymentId, payerId);
                System.out.println(payment.toJSON());

                if(payment.getState().equals("approved")) {
                    return "success";
                }

            } catch (PayPalRESTException e) {
                System.err.println(e);
            }
            return "redirect:/";
    }
}
