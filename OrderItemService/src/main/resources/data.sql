DROP TABLE IF EXISTS items;
 
CREATE TABLE items (
  product_code INT AUTO_INCREMENT  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  quantity INT
);
 
INSERT INTO items (product_code, product_name, quantity) VALUES
  (112233, 'Adidas', 20),
  (112234, 'Bata', 30),
  (112235, 'Nike', 25);
