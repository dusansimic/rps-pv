#!/bin/bash

podman run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres docker.io/library/postgres:17.5-alpine > .postgres-cid
