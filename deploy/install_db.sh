#!/bin/sh
DEPLOY_DIR=`dirname "$0"`
oc new-app --param-file="$DEPLOY_DIR"/postgres.params postgresql-persistent --labels=app=ticket-postgres,demo=matcher
