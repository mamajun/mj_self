#!/usr/bin/env bash
temp=`awk '{printf "%10s\n\r",$1}' test.txt`
echo $temp
echo "test"
