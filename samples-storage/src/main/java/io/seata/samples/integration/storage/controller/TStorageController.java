package io.seata.samples.integration.storage.controller;


import io.seata.samples.integration.common.dto.CommodityDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.storage.service.ITStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@RestController
@RequestMapping("/storage")
@Slf4j
public class TStorageController {


    @Autowired
    private ITStorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("dec_storage")
    ObjectResponse decreaseStorage(){
    	CommodityDTO commodityDTO=new CommodityDTO();
    	commodityDTO.setCommodityCode("C201901140001");
    	commodityDTO.setCount(10);
    	commodityDTO.setName("水杯");
        System.out.println("请求库存微服务："+commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }
}

