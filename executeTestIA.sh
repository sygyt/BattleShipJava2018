#!/bin/bash

javac -d bin src/gayet/simon/*.java;
javac -cp bin -d bin src/fr/battleship/*.java;
cd bin;
java fr.battleship.TestIA ; 

cp ai_proof.csv ../ai_proof.csv;
rm ai_proof.csv;
cd ..; 
 
