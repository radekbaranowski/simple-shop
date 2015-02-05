#!/bin/bash
$CATALINA_HOME/bin/shutdown.sh
echo "Copying simple-shop.war to "$CATALINA_HOME"/webapps directory"
cp ./target/simple-shop.war $CATALINA_HOME/webapps
$CATALINA_HOME/bin/startup.sh
if [ `wget -S http://localhost:8080/simple-shop/shop 2>&1 | grep -c '200 OK'` ==  "1" ]
then
    echo "Application available under http://"`hostname`":8080/simple-shop/shop"
else
    echo "something went wrong"
fi
