#!/bin/bash

# 入参1：自定义容器后缀名,不传入时使用随机数为后缀


image="golang:latest"
local_folder=$PWD
container_name=${PWD##*/}
container_folder=/go/src/$container_name
suffix=$1
if  [ ! -n "$suffix" ]; then
suffix=$RANDOM
fi

echo -e "\ncontainer_name: \033[32m$container_name-$suffix\033[0m"
echo -e "  local_folder: \033[32m$local_folder\033[0m"
echo -e "         image: \033[32m$image\033[0m"

cmd="docker run --rm -it --name $container_name-$suffix -v $local_folder:$container_folder ${image} bash"
echo -e "\n\033[32m${cmd}\033[0m\n"

${cmd}