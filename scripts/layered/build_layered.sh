function build_layered() {
    FOLDER=$1
    APP_NAME=$2
    APP_VERSION=0.0.1-SNAPSHOT

    cd ${FOLDER}/target/

    echo "Extract jar"
    java -jar -Djarmode=layertools ${APP_NAME}-${APP_VERSION}.jar extract

    cd ../../

    echo "Build docker image - " + ${APP_NAME}
    docker build -f ./scripts/layered/Dockerfile \
    --build-arg JAR_FOLDER=${FOLDER} \
    -t ${APP_NAME}:layered .
}

cd ../../
pwd

echo "Build jar with Maven"
    mvn clean package

echo "Build layered Docker images"

build_layered ./discovery-micro discovery-micro
build_layered ./examinator-micro examinator-micro
build_layered ./history-micro history-micro
build_layered ./math-micro math-micro
