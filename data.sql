CREATE DATABASE ecommerce_springdata;
USE ecommerce_springdata;

INSERT INTO categories (id, name) values (1, "electronics");
INSERT INTO categories (id, name) values (2, "men clothing");
INSERT INTO categories (id, name) values (3, "children clothing");


INSERT INTO products (id, name, price, rating, category_id) values (1, "Samsung galaxy note ultra", 1000.0, "5 stars", 1);
INSERT INTO products (id, name, price, rating, category_id) values (2, "Winter Fleech", 80.0, "4 stars", 2);
INSERT INTO products (id, name, price, rating, category_id) values (3, "girls hoodie", 20.5, "3 stars", 3);


INSERT INTO users (id, email, first_name, last_name, password) VALUES (1, "dunky@mail.com", "Geoffrey", "Opiyo", "xxxzzz");
INSERT INTO users (id, email, first_name, last_name, password) VALUES (2, "khan@mail.com", "Khan", "Nguyen", "12345");
INSERT INTO users (id, email, first_name, last_name, password) VALUES (3, "tonny@mail.com", "Tonny", "Kakooza", "abc");
INSERT INTO users (id, email, first_name, last_name, password) VALUES (4, "arinda@mail.com", "Hillar", "Arinda", "123");


INSERT INTO reviews (id, comments, product_id, user_id) VALUES (2, "It meet my expectation, I will rebuy for sure", 1, 1);
INSERT INTO reviews (id, comments, product_id, user_id) VALUES (2, "Product didn't meet my expectation, total trash", 2, 4);

