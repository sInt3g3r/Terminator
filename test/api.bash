#!/bin/bash

cType='Content-Type: application/json'
baseUrl='http://localhost:8080/api/'


function cSend() {
	echo "Command Send..."
}


if [ "$1" = "post" ]
then
	if [ -n "$2" ]
	then
		if [ -n "$3" ]
		then
			curl -H "$cType" -d @"$3" "$baseUrl""$2"
			cSend
		fi
	fi
elif [ "$1" = "delete" ]
then
	if [ -n "$2" ]
	then
		if [ -n "$3" ]
		then
			curl -X DELETE "$baseUrl""$2""/$3"
			cSend
		fi
	fi
elif [ "$1" = "get" ]
then
	if [ -n "$2" ]
	then
		curl -X GET "$baseUrl""$2" | json_pp -json_opt pretty,canonical
	fi
else
	echo '$1 = Method "post"'
	echo '$2 = Endpoint "newTask"'
	echo '$3 = json File, id' 
fi
