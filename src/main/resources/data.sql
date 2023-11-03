-- initialize users table (id, email, password, firstName, lastname)
INSERT INTO users (`email`, `password`, `first_name`, `last_name`)
VALUES ('johnDoe@gmail.com', 'password', 'John', 'Doe'),
       ('johnDoe2@gmail.com', 'password', 'John', 'Doe2'),
       ('johnDoe3@gmail.com', 'password', 'John', 'Doe3'),
       ('johnDoe4@gmail.com', 'password', 'John', 'Doe4');

-- initialize addresses table (id, street, city, zip, user_id)
INSERT INTO addresses (`street`,  `zip`,`city`, `user_id`)
VALUES ('street1', 'zip1', 'city1', 1),
       ('street2', 'zip2', 'city2', 2),
       ('street3', 'zip3', 'city3', 3),
       ('street4', 'zip4', 'city4', 4);

-- initialize categories table (id, name)
INSERT INTO categories (`name`)
VALUES ('category1'),
       ('category2'),
       ('category3'),
       ('category4');

-- initialize products table (id, name, price,rating, category_id)
INSERT INTO products (`name`, `price`, `rating`, `category_id`)
VALUES ('product1', 1.00, 1, 1),
       ('product2', 2.00, 2, 2),
       ('product3', 3.00, 3, 3),
       ('product4', 4.00, 4, 4);

-- initialize reviews table (id, rating, comment, user_id, product_id)
INSERT INTO reviews (`rating`, `comment`, `user_id`, `product_id`)
VALUES (1, 'comment1', 1, 1),
       (2, 'comment2', 2, 2),
       (3, 'comment3', 3, 3),
       (4, 'comment4', 4, 4);

