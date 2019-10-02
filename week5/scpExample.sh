#!/bin/bash

scp -i /c/myKeys/myFirstKeyPair.pem /c/training-code/week4/playerwebapp/src/main/resources/connection.properties ec2-user@ec2-3-92-128-203.compute-1.amazonaws.com:connection.properties
