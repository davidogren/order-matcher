#!/bin/sh
pg_dump -s -U devuser1 -d matcher -h 0.0.0.0
