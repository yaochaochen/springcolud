#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t hub.c.163.com/springcloud/eureka .

 docker push registry.cn-beijing.aliyuncs.com/ycc_vip/ycc_vip_cent