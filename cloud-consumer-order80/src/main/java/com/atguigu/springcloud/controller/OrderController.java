package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {


    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/create",method= {RequestMethod.POST})
    public CommonResult<Payment> create(Payment payment){

        System.out.println("payment = " + payment);

//        HttpHeaders httpHeaders = new HttpHeaders();
//
//        MultiValueMap<String,String> requestBody = new LinkedMultiValueMap<>();
//        requestBody.add("id",payment.getId() + "");
//        requestBody.add("serial",payment.getSerial());
//
//        HttpEntity<MultiValueMap> multiValueMapHttpEntity = new HttpEntity<>(requestBody, httpHeaders);
//

//        restTemplate.postForObject("",)
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",multiValueMapHttpEntity,CommonResult.class);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);

    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")int id){

        System.out.println("id = " + id);

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id,CommonResult.class);
    }
}
