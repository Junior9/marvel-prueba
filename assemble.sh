#!/bin/bash
echo "Prueba Albo"
cd 'albo'
echo "Instalación de las dependencias front-end..."
echo "Aguarde..."
npm install

echo "Compilando proyecto Agular..."
echo "Aguarde..."
ng build --prod 

cd ..

cd 'prueba'
echo "Instalación de las dependencias back-end..."
echo "Aguarde..."
mvn clean install

