#!/bin/bash
echo "Prueba Albo"
cd 'albo'

echo "........."
echo "Paso 1 : Instalación de las dependencias Angular(Front-end)"
echo "Paso 2 : Compilación del proyecto"
echo "Paso 3 : Instalación de las dependencias Java (Back-End)"
echo "Paso 3 : Inicia Servidor"
echo "........."

echo "Instalación de las dependencias front-end..."
echo "Aguarde algunos segundos..."
npm install

echo "Compilando proyecto Agular..."
echo "Aguarde..."
ng build --prod 

cd ..

cd 'prueba'
echo "Instalación de las dependencias back-end..."
echo "Aguarde..."
mvn clean install

echo "Inicializado servidor..."
cd 'target'
echo "Starting servidor..."
echo "Aguarde..."
java -jar prueba-0.0.1-SNAPSHOT.jar