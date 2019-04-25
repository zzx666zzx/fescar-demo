package io.seata.samples.integration.account.controller;


import io.seata.samples.integration.account.service.ITAccountService;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  账户扣钱
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class TAccountController {

    @Autowired
    private ITAccountService accountService;

    @RequestMapping("/dec_account")
    ObjectResponse decreaseAccount(){
    	
    	AccountDTO accountDTO=new AccountDTO();
    	accountDTO.setUserId("1");
    	accountDTO.setAmount(BigDecimal.valueOf(20));
    	System.out.println("请求账户微服务："+accountDTO.toString());
        return accountService.decreaseAccount(accountDTO);
    }
}

