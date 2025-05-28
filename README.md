# Payments Service

## Requirements

- [Docker 27](https://docs.docker.com/engine/install/)

## Building

```shell
docker run \
  -u $(id -u):$(grep -w docker /etc/group | awk -F\: '{print $3}') \
  --net=host \
  --rm \
  -w $(pwd) \
  -v /etc/group:/etc/group:ro \
  -v /etc/passwd:/etc/passwd:ro \
  -v $(pwd):$(pwd) \
  -v ${HOME}/.m2:${HOME}/.m2 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  azul/zulu-openjdk-alpine:17.0.15 \
  ./mvnw -Djansi.force=true -ntp -P local -U clean verify
```
