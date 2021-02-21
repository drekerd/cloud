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
  import_database
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

import_database() {
  ./gradlew flyWay
}

exec_commands() {
  for var in $@; do
    case "$var" in
    build)
      build
      ;;
    clean)
      clean
      ;;
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
    runMigrations)
      import_database
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
Clean

Build

createDockerImage

removeDockerImage

upContainers

downContainers

unitTests

acceptanceTests

runMigrations

EOF
  ;;

esac
