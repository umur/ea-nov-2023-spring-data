CREATE DATABASE ecommerce_springdata;
USE ecommerce_springdata;

INSERT INTO categories (id, name) values (1, "electronics");
INSERT INTO categories (id, name) values (2, "men clothing");
INSERT INTO categories (id, name) values (3, "children clothing");


INSERT INTO products (id, name, price, rating, category_id) values (1, "Samsung galaxy note ultra", 1000.0, "5 stars", 1);
INSERT INTO products (id, name, price, rating, category_id) values (2, "Winter Fleech", 80.0, "4 stars", 2);
INSERT INTO products (id, name, price, rating, category_id) values (3, "girls hoodie", 20.5, "3 stars", 3);