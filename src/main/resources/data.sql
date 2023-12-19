insert into brand (image, name) values ('http://img1.png', 'apple');
insert into brand (image, name) values ('http://img2.png', 'samsung');
insert into brand (image, name) values ('http://img3.png', 'lenovo');

INSERT INTO product (name, description, price, image, brand_id)
VALUES
    ('Product A', 'Description for Product A', 50, 'http://productA-image.png', 1),
    ('Product B', 'Description for Product B', 75, 'http://productB-image.png', 1),
    ('Product C', 'Description for Product C', 100, 'http://productC-image.png', 1);