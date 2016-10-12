#!/bin/bash -ex

for i in 1 2 3 4 5 ; do 
	curl 'http://localhost:8080/' -H "X-Id-GlouGlou: $i"
done