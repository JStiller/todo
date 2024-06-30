# TODO App

## Disclaimer

This is a fun project to dig a little deeper into kotlin and angular. So feel
free to look into the repository but dont use it in production =)

## Goal

The goal is to create yet another todo app based on Kotlin with Spring Boot and Angular.

For the user interface i'll use components from Material Design.

I assume that i need the following endpoints

- POST / - to add new todos
- UPDATE / - to update the status of a todo to done or not done
- GET / - to gather todos

The todo schema will look something like this

id: string
title: string
category: string
description: string
status: boolean

For the pipeline, i'll use github actions.

## Commands

Run `gradle bootRun` in the root directory to get the backend started.
Run `npm run start` in the frontend directory to get the frontend started.
