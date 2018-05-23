#!/bin/bash

javac -d bin src/gayet/simon/*.java;
cd bin;
java gayet.simon.Battleship ; 
rm gayet/simon/*.class;
cd ..; 
 
