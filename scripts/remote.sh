#! /bin/bash

echo "[REMOTE]: Cleaning up..."
rm -rf ~/resources
echo "[REMOTE]: Extracting the package..."
tar zxf ~/tmp/package.tar.gz
echo "[REMOTE]: Installing the content..."
mkdir -p ~/www/
cp -rv ~/resources/public/ ~/www/home/
chmod 755 ~/www/home/ -R
echo "[REMOTE]: Cleaning up..."
rm -rf ~/resources ~/tmp/
mkdir -p ~/tmp
echo "[REMOTE]: Done"
