Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://qloka5918k.execute-api.us-east-1.amazonaws.com/dev/'

Scenario: Get Avenger by Id

Given path 'avengers', 'aaaa-bbbb-cccc-dddd'
When method get
Then status 200
And match response == {id:'#string', name: '#string', secretIdentity:'#string'}

Scenario: Creates a new avenger

Given path 'avengers'
And request {name:'Captain America',secretIdentity:'Steve Rogers'}
When method post
Then status 201
And match response == {id:'#string', name: '#string', secretIdentity:'#string'}

Scenario: Creates a new aventer without the required data

Given path 'avengers'
And request {name: 'Captain America'}
When method post
Then status 400

Scenario: Delete Avenger by id

Given path 'avengers', 'aaaa-bbbb-cccc-dddd'
When method delete
Then status 204

Scenario: Updates Avenger

Given path 'avengers', 'aaaa-bbbb-cccc-dddd'
And request {name:'Captain America',secretIdentity:'Steve Rogers'}
When method put
Then status 200
And match response == {id:'#string', name: '#string', secretIdentity:'#string'}

Scenario: Update Avenger no parameter

Given path 'avengers', 'aaaa-bbbb-cccc-dddd'
And request {name:'Captain America'}
When method put
Then status 400
