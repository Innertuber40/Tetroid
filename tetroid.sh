#!/usr/bin/env bash

javac -cp lanterna.jar:. Tetroid.java
resize -s 20 80
java -cp lanterna.jar:. Tetroid
