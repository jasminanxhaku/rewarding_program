# Customer Rewarding Program

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar
spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
Given a record of every transaction during a three-month period, calculate the reward points earned for each
customer per month and total.

# To run
- mvn clean compile
- mvn spring-boot:run

# Endpoints:
1. Get rewards for all customers' endpoint -> /rewards
2. Get rewards for customer with Id -> /rewards/{customerId} 

http://localhost:8080/rewards/all
http://localhost:8080/rewards/1

# Database
To log into the H2 database to check the data in tables use following link:
http://localhost:8080/h2  
JDBC URL =jdbc:h2:mem:testdb


