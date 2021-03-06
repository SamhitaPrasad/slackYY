# slackYY

#Added test cases

##The following scenarios have been implemented :

 1. Sign Up
 2. Sign Up with Password Mismatch.
 3. Sign In
 4. Add New Channel
 5. Send Message
















Yet another slack like application. Built
using [Sails](http://sailsjs.org) framework for Node.js.

You can view the demo of the app in Youtube:

[![SlackYY](https://i.ytimg.com/vi/_Ea2GoNJWAI/maxresdefault.jpg)](https://www.youtube.com/watch?v=_Ea2GoNJWAI&feature=youtu.be)

# Architecture

* [Sails.js](http://sailsjs.com) : Sails is a framework that is built on top
  of [Express](https://github.com/expressjs). The code extensively (specifically the Blueprint
  API) uses the features provided by Sails to achieve things.
* [Socket.io](https://socket.io/) : For real time chat app, we internally use
  socket.io. Sails.js wraps on top of this library and gives a nice
  API for consumption. Socket.io actually has two parts: a client side
  which runs in browser and a server side library for `Node.js`.
* [PostgreSQL Server](https://www.postgresql.org/): We use Postgres as RDBMS backend for storing user, channel
  and the chat messages for later retrieval purpose.
* React/Redux: The frontend application is built using React and
  Redux. The folder `client` contains all the frontend related code.

# How to run ?

## Pre-requisites

1. Latest [LTS Node.js](https://nodejs.org/en/) (I recommend
   using [nvm](https://github.com/creationix/nvm) for installing it.)
2. [Yarn](https://yarnpkg.com/en/docs/install)
3. [PostgreSQL Server](https://www.postgresql.org/)

Note that `postgresql` server should be running up. To see if it's
running on a Linux machine, you have to do:

``` shellsession
$ systemctl status postgresql
● postgresql.service - PostgreSQL RDBMS
   Loaded: loaded (/lib/systemd/system/postgresql.service; enabled; vendor preset: enabled)
   Active: active (exited) since Thu 2017-06-29 20:35:01 IST; 3h 36min ago
  Process: 1138 ExecStart=/bin/true (code=exited, status=0/SUCCESS)
 Main PID: 1138 (code=exited, status=0/SUCCESS)
    Tasks: 0
   Memory: 0B
      CPU: 0
   CGroup: /system.slice/postgresql.service

Jun 29 20:35:01 jane systemd[1]: Starting PostgreSQL RDBMS...
Jun 29 20:35:01 jane systemd[1]: Started PostgreSQL RDBMS.
```

Also you need to have a database named `slacky` present which should
be accessible by a user named `postgres` with password `postgres`. In case you need to change any of the following, please [edit this file](https://github.com/psibi/slackYY/blob/839daa339360e43ffe99c83ce1e1c42d55e083df/config/connections.js#L77).

## Installation instructions

1. `git clone git@github.com:psibi/slackYY.git`

2. `yarn global add sails`

3. `cd slackYY/client`

4. `yarn install`

5. `yarn run build`

6. `cd ..`

7. `yarn install`

8. `sails lift`

Go and visit `http://localhost:1337` to see the application!

# App Organization

These are the important directories you will find:

* views 

Holds the presentaion layer of the code. We
use [EJS](https://github.com/tj/ejs) for embedding templates.

* client

Contains the front-end client code which uses `React` and `Redux`.

* api

Contains the backbonse of the entire application. The server side code
lies here. Models, controllers and Policies are defined here.

* tasks

Grunt tasks and their configuration

* config

Contains different files which can be used for configuring database
connection, routes, policies etc.

* test

Test directory containing integration testing code for controllers and
models related functions.

# Appendix (Dev notes while learning)

## Some goodies

Using blueprint gives automatic REST API

Note that all the requests are GET. For more methods [see here](http://sailsjs.com/documentation/concepts/blueprints/blueprint-actions)

curl "http://localhost:1337/channel/create?name=hello2"

curl "http://localhost:1337/channel/create?name=channel1"

curl "http://localhost:1337/channel/find?id=2"

This also works which is more clean (Follows REST more faithfully):

curl -d '{"name":"channel3"}' -H "Content-Type: application/json" -X POST http://localhost:1337/channel/create

curl -H "Content-Type: application/json" http://localhost:1337/channel

Example of adding Message:

curl -d '{"msg":"dummy msg", "userName": "sibi", "channel": 1}' -H "Content-Type: application/json" -X POST http://localhost:1337/message/create

curl -d '{"email":"sibi@psibi.in","password":"sibi"}' -H "Content-Type: application/json" -X POST http://localhost:1337/login

