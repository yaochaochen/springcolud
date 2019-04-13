package com.imooc.product.repository;

import com.imooc.product.dataobject.ConfigInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigInfoRepository extends JpaRepository<ConfigInfo,Integer> {
    
    List<ConfigInfo> findByAAndGroupId(Long groupId);
            
}
