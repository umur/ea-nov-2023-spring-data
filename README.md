# Lab 3 - Spring Data I with RESTful Web Services 

In this lab, I createed a spring boot application from scratch that interacts with database.


## API Documentation
Use Swagger
```
http://localhost:8080/swagger-ui/index.html
```

###  Requirements
---
* Make domain models for
	* `Category` with `id` and `name`.
		* A `Category` can have many `Products`.
	* `Product` with `id, name, price` and `rating`.
		* A `Product` can belong to only one `Category`.
		* A `Product` can have many `Reviews`.
	* `User` with `id, email, password, firstName, lastname`.
		* `User` can create many `Reviews`.
		* `User` can have only one `Address`.
	* `Address` with `id, street, zip` and `city`.
		* An `Address` can belong to only one `User`. 
	* `Review` with `id, comment`.
		* A `Review` can only belong to one `User` and `Product`.

* Implement CRUD operations and build REST API for all domain models.

* Implement the following queries by using `Naming Convention`. Create REST endpoints for them.
	* Find all products that cost more than `minPrice`.
	* Find all products in `cat` category and cost less than `maxPrice`.
	* Find all products that contain `keyword` in the name.
	* Find reviews of the product whose id is `id`. 

### Technical Details
---
* Use n-tier software architecture model.
* Populate your database with dummy data using `data.sql`.
* Create a postman collection that includes sample requests for all of your endpoints.

