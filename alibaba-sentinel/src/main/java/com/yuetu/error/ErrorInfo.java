package com.yuetu.error;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ErrorInfo
 * @Author yaochaochen
 * @Date 2019-04-11 11:31
 **/
@Getter
@Setter
public class ErrorInfo<T> {
    
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    
    private Integer code;
    private String msg;
    private String url;
    private T data;
    
}
