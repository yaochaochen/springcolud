package com.imooc.product.service;

import com.imooc.product.dataobject.ConfigInfo;

import java.util.List;

/**
 * @ClassName ConfigInfoService
 * @Author yaochaochen
 * @Date 2019-04-13 15:56
 **/
public interface ConfigInfoService {

    /**
     * 获取该分组的配置
     * @param groupId
     * @return
     */
    List<ConfigInfo> findByGroupId(Long groupId);
}
