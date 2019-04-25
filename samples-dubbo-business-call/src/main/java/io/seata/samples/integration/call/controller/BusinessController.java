package io.seata.samples.integration.call.controller;

import io.seata.samples.integration.call.service.BusinessService;
import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: heshouyou
 * @Description  Dubbo业务执行入口
 * @Date Created in 2019/1/14 17:15
 */
@RestController
@RequestMapping("/business/dubbo")
@Slf4j
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @RequestMapping("/buy")
    ObjectResponse handleBusiness(){
    	//张三用户id为1，买10个商品，单价20元，一共支付200
    	BusinessDTO businessDTO =new BusinessDTO();
    	businessDTO.setCommodityCode("C201901140001");
    	businessDTO.setAmount(BigDecimal.valueOf(200));
    	businessDTO.setCount(10);
    	businessDTO.setUserId("1");
    	businessDTO.setName("水杯");
        System.out.println("请求参数："+businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
