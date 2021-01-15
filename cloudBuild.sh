#!/usr/bin/env bash

create_docker_image() {
  remove_docker_image
  echo -e '[Creating docker image]'
  docker build . -f ${DOCKER_FILE_PATH} -t ${PROJECT_NAME}
}

remove_docker_image() {
  docker image rm -f ${PROJECT_NAME}
}

case $1 in
createDockerImage)
  create_docker_image
  ;;
removeDockerImage)
  remove_docker_image
  ;;
*) ;;

esac
