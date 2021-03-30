#!/bin/bash
echo "Prueba Albo"

echo "Inicializado servidor..."
cd 'prueba'
cd 'target'
echo "Starting servidor..."
echo "Aguarde..."
java -jar prueba-0.0.1-SNAPSHOT.jar

cd ..
cd ..

cd 'albo'
echo "Inicializado front-end..."
echo "Aguarde..."
ng serve -o