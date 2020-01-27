#!/usr/bin/env bash

# shellcheck disable=SC2046
docker rm $(docker ps -a -q)