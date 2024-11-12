CREATE TABLE customers
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50),
    age      INT,
    email    VARCHAR(100),
    country  VARCHAR(50),
    city     VARCHAR(50)
);

INSERT INTO customers (name, age, email, country, city) VALUES ('john', 30, 'john@example.com', 'USA', 'New York');