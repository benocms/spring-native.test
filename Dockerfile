FROM ghcr.io/graalvm/graalvm-ce:ol8-java17-22.3.2 AS builder
ADD . /build
WORKDIR /build
RUN microdnf install -y unzip zip
RUN \
# Install SDKMAN
curl -s "https://get.sdkman.io" | bash; \
source "$HOME/.sdkman/bin/sdkman-init.sh"; \
# Install GraalVM Native Image
gu install native-image;

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk flush candidates && sdk install gradle 7.5"
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && gradle --version
RUN native-image --version

ENV JASYPT_ENCRYPTOR_PASSWORD=ABCDEFGH
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && gradle nativeCompile -Djasypt.encryptor.password=ABCDEFGH

RUN ls -ll
CMD [ "sh", "-c", "./build/native/nativeCompile/my-service"]