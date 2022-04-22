package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.sun.org.apache.bcel.internal.generic.JsrInstruction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "/payment/create",method = {RequestMethod.POST})
    public CommonResult create(@RequestBody Payment payment){
        log.info(" create payment = " + payment);

        Long result = paymentService.create(payment);

        log.info("插入数据后返回的值 = " + result);

        if(result > 0){
            return new CommonResult(200,"插入成功 ip = " + serverPort,result);
        }else{
            return new CommonResult(444,"插入失败 ip = " + serverPort);
        }
    }

    @RequestMapping(value = "/payment/get/{id}",method = {RequestMethod.GET})
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment paymentById = paymentService.getPaymentById(id);

        log.info("查询结果 = " + paymentById);

        if(paymentById != null){
            return new CommonResult(200,"查询成功 ip = " + serverPort,paymentById);
        }else{
            return new CommonResult(444,"查询失败 ip = " + serverPort);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discoverClient(){

        List<String> services = discoveryClient.getServices();

        for (String service : services) {

            log.info("*** service = " + service);

            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("!!!!!! instance = " + instance.getServiceId() +":"+ instance.getHost()
                        +":"+ instance.getPort() +":"+ instance.getUri() + ":" + instance.getInstanceId() );
            }

        }
        return this.discoveryClient;
    }


    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
