package com.paypal.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.order.OrderDTO;
import com.paypal.repositories.UserRepository;
import com.paypal.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


@Service
public class PayPalService {
    private APIContext apiContext;
    private UserRepository userRepository;

    @Autowired
    public PayPalService(APIContext apiContext, UserRepository userRepository) {
        this.apiContext = apiContext;
        this.userRepository = userRepository;
    }

    public Payment createPayment(OrderDTO orderDTO) throws PayPalRESTException {
        User user = userRepository
                .findByOrders_Id(orderDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User has not been found"));

        //Creating Payer
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName(user.getName());
        payerInfo.setLastName(user.getSurname());

        payer.setPayerInfo(payerInfo);

        //URLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/cancel");
        redirectUrls.setReturnUrl("http://localhost:8080/return");

        //Details
//        Details details = new Details();
//        details.setShipping("1");
//        details.setSubtotal("5");
//        details.setTax("1");

        //Payment Amount
        Amount amount = new Amount();
        String total = orderDTO
                .getCartDTO()
                .getCheckOutPrice()
                .setScale(2, RoundingMode.HALF_UP)
                .toString();

        amount.setTotal(total);
        amount.setCurrency("USD");
        amount.setDetails(null);

        //Creating transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDTO.getCartDTO().getProductDTOS().toString());

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        //Payment
        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        return payment.execute(apiContext, paymentExecution);
    }

}
