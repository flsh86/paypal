insert into product (id, name, price, quantity) values
(1, 'telefon', 200, 10),
(2, 'komputer', 500, 5),
(3, 'samochód', 25000, 3),
(4, 'toster', 10, 500),
(5, 'herbata', 2, 2);

insert into cart(id) values
(1), (2);

insert into user(id, name, surname) values
(1, 'XYZ', 'XYZ'),
(2, 'ABC', 'QWE');

insert into cart_product(cart_id, product_id, quantity) values
(1, 1, 999),
(1, 2, 1),
(2, 1, 1),
(2, 3, 1);

insert into user_cart(user_id, cart_id) values
(1, 1),
(2, 2);

insert into orders(id, status, cart_id) values
(1,'TEST', 1),
(2, 'SENT', 2);

insert into user_orders (user_id, orders_id) values
(1, 1),
(2, 2);
--