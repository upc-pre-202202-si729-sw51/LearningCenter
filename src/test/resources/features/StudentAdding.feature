Feature: Student Adding
  As a Developer
  I want to add Student through API
  So that It can be available to applications.

  Background:
    Given The Endpoint "http://localhost:%d/api/v1/students" is available

    @student-adding
    Scenario: Add Student
      When A Post Request is sent with values "John Doe", 36, "Anywhere"
      Then A Response is received with Status 200
      And An Student Resource is included in Response Body, with values "John Doe", 36, "Anywhere"

      @student-duplicated
      Scenario: Add Student with existing Name
        Given An Student Resource with values "Jason Bourne", 42, "Secret Place" is already stored
        When A Post Request is sent with values "Jason Bourne", 42, "Secret Place"
        Then A Response is received with Status 400
        And A Message is included in Response Body, with values "Not all constraints satisfied for Student: An Student with the same name already exists."
