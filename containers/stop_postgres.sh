#!/bin/bash

POSTGRES_CID=$(cat .postgres-cid)

podman stop $POSTGRES_CID
podman rm $POSTGRES_CID

rm .postgres-cid
