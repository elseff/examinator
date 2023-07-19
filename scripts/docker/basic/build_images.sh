function build_image() {
    JAR_FILE=$1
    APP_NAME=$2

    docker build -f ./scripts/docker/basic/Dockerfile --build-arg JAR_FILE=${JAR_FILE} -t ${APP_NAME}:latest .
}

APP_VERSION=0.0.1-SNAPSHOT

cd ../../../

echo "Build Docker images"

build_image ./discovery-micro/target/discovery-micro-${APP_VERSION}.jar discovery-micro
build_image ./examinator-micro/target/examinator-micro-${APP_VERSION}.jar examinator-micro
build_image ./history-micro/target/history-micro-${APP_VERSION}.jar history-micro
build_image ./math-micro/target/math-micro-${APP_VERSION}.jar math-micro