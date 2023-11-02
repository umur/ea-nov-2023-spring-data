
insert into Category (id, name)
values
    (1, 'Category 1'),
    (2, 'Category 2'),
    (3, 'Category 3');

insert into Product (id, name, price, rating, category_id)
values
    (1, 'Product 1', 100.0,1, 1),
    (2, 'Product 2', 200.0,2, 2),
    (3, 'Product 3', 300.0,3, 3);

insert into User (id, first_name, last_name, email, password)
values
    (1, 'User', '1', 'user1', 'user1'),
    (2, 'User', '2', 'user2', 'user2'),
    (3, 'User', '3', 'user3', 'user3');

insert into Address (id, street, city, zip, user_id)
values (1, 'Street 1', 'City 1', 1, 1),
       (2, 'Street 2', 'City 2', 2, 2),
       (3, 'Street 3', 'City 3', 3, 3);

insert  into Review (id, comment, product_id, user_id)
values (1, 'Review 1', 1, 1),
       (2, 'Review 2', 2, 2),
       (3, 'Review 3', 3, 3);