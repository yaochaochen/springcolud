package com.imooc.product.controller;

import com.imooc.product.VO.ResultVO;
import com.imooc.product.dataobject.ConfigInfo;
import com.imooc.product.service.ConfigInfoService;
import com.imooc.product.utils.JsonUtil;
import com.imooc.product.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ConfigInfoController
 * @Author yaochaochen
 * @Date 2019-04-13 16:02
 **/
@Slf4j
@RestController("/config")
public class ConfigInfoController {
    
    @Autowired
    private ConfigInfoService configInfoService;
    
    
    
    
    @GetMapping("/{groupId}")
    
    public ResultVO<List<ConfigInfo>> findByGoupId(@PathVariable("groupId") Long groupId) {
        
        List<ConfigInfo> list = configInfoService.findByGroupId(groupId);
        
        log.info("根据分组Id查询配置信息groupId ={},查询结果result= {}",groupId, JsonUtil.toJson(list));
        return ResultVOUtil.success(list);
    }
    
    
    
}
