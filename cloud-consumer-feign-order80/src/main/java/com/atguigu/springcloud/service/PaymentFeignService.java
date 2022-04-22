package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther zzyy
 * @create 2020-02-19 23:59
 */
@Component
@FeignClient(value="cloud-payment-service")
public interface PaymentFeignService
{
    @RequestMapping(value = "/payment/get/{id}",method = {RequestMethod.GET})
    public CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout();

}
