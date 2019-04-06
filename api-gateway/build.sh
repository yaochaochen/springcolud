#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U


docker build -t registry.cn-beijing.aliyuncs.com/ycc_vip/ycc_vip_cent/api-gateway .

docker push registry.cn-beijing.aliyuncs.com/ycc_vip/ycc_vip_cent/api-gateway