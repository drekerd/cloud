#!/usr/bin/env bash

create_docker_image() {
  remove_docker_image
  echo -e '[Creating docker image]'
  docker build . -f ${DOCKER_FILE_PATH} -t ${PROJECT_NAME}
}

remove_docker_image() {
  docker image rm -f ${PROJECT_NAME}
}

up_containers() {
  docker-compose -f ${DOCKER_COMPOSE_FILE} up -d
}

down_containers() {
  docker-compose -f ${DOCKER_COMPOSE_FILE} down --remove-orphans
}

build() {
  ./gradlew build
}

clean() {
  ./gradlew clean
}

unit_tests() {
  ./gradlew test
}

acceptance_tests() {
  ./gradlew acceptanceTests
}

exec_commands() {
  for var in $@; do
    case "$var" in
    createDockerImage)
      create_docker_image
      ;;
    removeDockerImage)
      remove_docker_image
      ;;
    upContainers)
      up_containers
      ;;
    downContainers)
      down_containers
      ;;
    unitTests)
      unit_tests
      ;;
    acceptanceTests)
      acceptance_tests
      ;;
    esac
  done
}

case $1 in
-e)
  exec_commands $@
  ;;
*)

  cat <<-EOF
createDockerImage

removeDockerImage

upContainers

downContainers

unitTests

acceptanceTests

EOF
  ;;

esac
