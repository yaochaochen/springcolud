#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t alitest/springcloud/config .

 docker push registry.cn-beijing.aliyuncs.com/ycc_vip/ycc_vip_cent
