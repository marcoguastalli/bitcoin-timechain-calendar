#!/bin/bash
unset JAVA_HOME
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
java -Xmx1024m -jar -Dspring.profiles.active=docker ./target/bitcoin-timechain-calendar-0.0.1-SNAPSHOT.jar