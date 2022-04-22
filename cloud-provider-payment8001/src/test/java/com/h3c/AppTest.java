package com.h3c;

import static org.junit.Assert.assertTrue;

import com.atguigu.springcloud.PaymentMain8001;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentMain8001.class)
public class AppTest 
{


    @Autowired
    private PaymentService paymentService;
    @Test
    public void test01(){

        Payment 第11本 = new Payment(10l, "第11本");

        Long 第10本 = paymentService.create(第11本);

        System.out.println("第11本 = " + 第11本);





    }
}
