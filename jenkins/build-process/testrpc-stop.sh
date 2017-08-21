#!/bin/bash

ps -ef | grep testrpc | cut -d' ' -f2 | xargs kill -9
