-- Insert Categories
INSERT INTO Category (id, name) VALUES (1, 'Electronics');
INSERT INTO Category (id, name) VALUES (2, 'Clothing');
INSERT INTO Category (id, name) VALUES (3, 'Furniture');

-- Insert Products
INSERT INTO Product (id, name, price, rating, category_id) VALUES (1, 'Smartphone', 499.99, 4.5, 1);
INSERT INTO Product (id, name, price, rating, category_id) VALUES (2, 'Laptop', 899.99, 4.2, 1);
INSERT INTO Product (id, name, price, rating, category_id) VALUES (3, 'T-shirt', 19.99, 4.0, 2);
INSERT INTO Product (id, name, price, rating, category_id) VALUES (4, 'Sofa', 699.99, 4.7, 3);

-- Insert Addresses
INSERT INTO Address (id, street, zip, city) VALUES (1, '123 Main St', '12345', 'New York');
INSERT INTO Address (id, street, zip, city) VALUES (2, '456 Elm St', '54321', 'Los Angeles');

-- Insert Users
INSERT INTO User (id, email, password, first_name, last_name, address_id) VALUES (1, 'user1@example.com', 'password123', 'John', 'Doe', 1);
INSERT INTO User (id, email, password, first_name, last_name, address_id) VALUES (2, 'user2@example.com', 'securePass', 'Jane', 'Smith', 2);


-- Insert Reviews
INSERT INTO Review (id, comment, user_id, product_id) VALUES (1, 'Great product!', 1, 1);
INSERT INTO Review (id, comment, user_id, product_id) VALUES (2, 'Fast delivery', 2, 2);

ALTER TABLE category AUTO_INCREMENT =  4;
ALTER TABLE product AUTO_INCREMENT =  5;
ALTER TABLE address AUTO_INCREMENT =  3;
ALTER TABLE user AUTO_INCREMENT =  2;
ALTER TABLE review AUTO_INCREMENT =  2;

