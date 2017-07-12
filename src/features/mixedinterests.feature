Feature: test if there are no mixed interests for the employees;

In order to avoid mixed interests
as an employee
i want to check if my customers have another postalcode than me

Scenario: no neighbours as a customer
 Given a new customer signs up
 When the selected employee has the same postal code
 Then it should say: "sorry no neighbours as a customer"


