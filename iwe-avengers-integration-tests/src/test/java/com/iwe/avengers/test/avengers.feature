Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://qloka5918k.execute-api.us-east-1.amazonaws.com/dev/'

Scenario: Get Avenger by Id

Given path 'avengers', 'aaaa-bbbb-cccc-dddd'
When method get
Then status 200

Scenario: Creates a new avenger

Given path 'avengers'
And request {name:'Captain America',secretIdentity:'Steve Rogers'}
When method post
Then status 201