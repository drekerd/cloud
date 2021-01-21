# Cloud
Cloud is the main api service for Pricelist application

# Envs
## To manage project env vars, install direnv
https://direnv.net/

Rename file rename `dotenv.exmple` and `dotenvrc.exemple` to `.env` and `.envrc`
If you add new env vars, please do not forget to update dotenv.exemple

- DOCKER_FILE_PATH={path to docker file}
- DOCKER_COMPOSE_FILE={path to docker-compose file}
- PROJECT_NAME={project name }

# First Time Run
Be sure to have installed

| Name              | URL                                       |
| ------------------|-------------------------------------------|
| `direnv`          | https://direnv.net/                       |
| `docker`          | https://docs.docker.com/get-docker/       |
| `docker-compose`  | https://docs.docker.com/compose/install/  |

After install and have your application cloned from git repository proceed with:
1. Create Docker Image 
    - `./cloudBuild.sh -e createDockerImage`
2. Up the application in a docker container
    - `./cloudBuild.sh -e upConatainers`

## Build, Clean, Test, Acceptance Test
You have two alternatives. <br />
You can use either `./gradlew build` or use the file `./cloudBuild.sh -e build` located in the root directory. <br />
For other commands as well `./gradlew test` `./cloudBuild.sh -e build`

## cloudBuild.sh file
The Need for this command is primarily to use control your docker environment
To see what the script **./cloudBuild.sh** file can do just type `./cloudBuild.sh` and it shows a list of commands
To run a command simply type `./cloudBuild.sh -e createDockerImage`
You can also run multiple commands, for exemple:
`./cloudBuild.sh -e createDockerImage upContainers build acceptanceTests`

|Name               | Description                                                                       |
|-------------------|-----------------------------------------------------------------------------------|
| createDockerImage | Creates a docker image based on dockerfile in your project                        |
| removeDockerImage | Removes the image based on the name that is preconfigured                         |
| upContainers      | SetUps the containers based on the image created from command `createDockerImage` |
| downContainers    | Stops and removes the running containers as well as the network                   |
| unitTests         | Runs the unit Tests                                                               |
| AcceptanceTests   | Runs the Acceptance Tests                                                         |

# dockerfile and docker-compose
`cd docker/`

# AcceptanceTests
`cd src/acceptanceTests/`

# AcceptanceTests reports
You can find acceptanceTests reports in `buid/reports/`


