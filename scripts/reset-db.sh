#!/usr/bin/env bash

set -e

echo "Resetting MongoDB database: trainingdb"

docker exec nfs-java-mongo mongosh \
  -u user \
  -p password \
  --authenticationDatabase admin \
  --eval "db.getSiblingDB('trainingdb').instructors.drop()"

echo "Importing seed data"

docker cp seed/instructors.json nfs-java-mongo:/tmp/instructors.json

MSYS_NO_PATHCONV=1 docker exec nfs-java-mongo mongoimport \
  -u user \
  -p password \
  --authenticationDatabase admin \
  --db trainingdb \
  --collection instructors \
  --file /tmp/instructors.json \
  --jsonArray

echo "Seed complete"