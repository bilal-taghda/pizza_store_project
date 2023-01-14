### pizza_store_project
## Description
backend for pizza-store built by DDD principles, spring-boot as DI container that play role of web(controllers) and application(services)
, hibernate-jpa as orm play role of repository, rabbitmq as MB role event publishers and consumers, H2 in-Memory DB
, spring security to manage jwt auth by email-password and authorities-permissions access
, docker-compose to set-up rabbitmq MB, junit-5 to unit-test  business logic, mockito for integration-test repo and controller functions

## Software features
- there are 4 user roles: CUSTOMER, WORKER, CHEF, DELIVERY. all can register and GET user-account details
- CUSTOMER can place order and get his orders infos
- CHEF can get all orders, change order status to COOKED 
- WORKER can place order, get all orders, change order status to READY
- DELIVERY can get all orders, change order status to DELIVERED  
