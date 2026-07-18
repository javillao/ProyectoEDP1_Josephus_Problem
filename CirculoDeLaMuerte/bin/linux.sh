#!/bin/bash

cd $1 || exit 1

# Allow local container connections to X11 server
xhost +local:docker

# Run passing display variables and volumes
docker run -it --rm \
  -e DISPLAY=$DISPLAY \
  -v /tmp/.X11-unix:/tmp/.X11-unix \
  proyectopoo-p2t1-javafx-app
