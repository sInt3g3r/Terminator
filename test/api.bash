#!/bin/bash
# Editor : Patrick Schneeberger
# Desc.  : curl CRUD Api Testscript
# VIM    : set tabstop=3 shiftwidth=3 expandtab 


cType='Content-Type: application/json'
baseUrl='http://localhost:8080/api/'


function cSend() {
   echo "Command Send..."
}

function help() {
   echo 'Examples:'
   echo './api.bash post postTask task.json'
   echo './api.bash del delTask/1'
   echo './api.bash get getTasks'
   echo './api.bash put putTask/1 task.json'
   echo ''
   echo '$1 = Method "post"'
   echo '$2 = Endpoint "postTask", "delTask/id"'
   echo '$3 = json File'
}

if [ "$1" = "post" ]
then
   if [ -n "$2" ]
   then
      if [ -n "$3" ]
      then
         curl -H "$cType" -d @"$3" "$baseUrl""$2"
         cSend
      else
         help
      fi
   else
      help
   fi
elif [ "$1" = "del" ]
then
   if [ -n "$2" ]
   then
      curl -X DELETE "$baseUrl""$2"
      cSend
   else
      help
   fi
elif [ "$1" = "get" ]
then
   if [ -n "$2" ]
   then
      curl -X GET "$baseUrl""$2" | json_pp -json_opt pretty,canonical
   else
      help
   fi
elif [ "$1" = "put" ]
then
   if [ -n "$2" ]
   then
      if [ -n "$3" ]
      then
         curl -X PUT -H "$cType" -d @"$3" "$baseUrl""/$2"
         cSend
      else
         help
      fi
   else
      help
   fi
else
   help
fi
