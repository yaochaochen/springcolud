package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ConfigInfo;
import com.imooc.product.repository.ConfigInfoRepository;
import com.imooc.product.service.ConfigInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ConfigInfoServiceImpl
 * @Author yaochaochen
 * @Date 2019-04-13 15:58
 **/
@Service
public class ConfigInfoServiceImpl implements ConfigInfoService {
    
    
    @Autowired
    private ConfigInfoRepository repository;
    @Override
    public List<ConfigInfo> findByGroupId(Long groupId) {
        return repository.findByAAndGroupId(groupId);
    }
}
