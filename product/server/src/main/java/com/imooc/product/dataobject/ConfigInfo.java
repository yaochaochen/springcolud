package com.imooc.product.dataobject;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * 配置信息
 * 
 * @ClassName ConfigInfo
 * @Author yaochaochen
 * @Date 2019-04-13 15:44
 **/

@Data
@Entity
@Getter
@Setter
@Builder
public class ConfigInfo {
    
    
    private Long id;
    
    private long dataId;
    
    private long groupId;
    
    private String content;
    
    private String md5;
    
    private LocalDateTime gmtCreate;
    
    private LocalDateTime gmtModified;
    
    private String srcUser;
    
    private String srcIp;
    
    private String appName;
    
    private String tenantId;
    
    private String cDesc;
    
    private String cUse;
    
    private String effect;
    
    private String type;
    
    private String cSchema;
    
    
    
    
    
    
    
    
}
