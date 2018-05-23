#!/bin/bash

javac -d bin src/gayet/simon/*.java;
javac -cp bin -d bin src/fr/battleship/*.java;
cd bin;
java fr.battleship.TestIA ; 

rm gayet/simon/*.class;
rm fr/battleship/*.class;

cp ai_proof.csv ../ai_proof.csv;
rm ai_proof.csv;
cd ..; 
 
