CREATE DATABASE ProductSystem;
-- DROP DATABASE ProductSystem;
USE ProductSystem;
-- Creating the Supplier table
-- DROP TABLE Supplier;
CREATE TABLE Supplier (
    SupplierID INT AUTO_INCREMENT PRIMARY KEY,
    SupplierName VARCHAR(255) NOT NULL
);

-- Inserting sample data into Supplier table
-- DELETE FROM Supplier;
INSERT INTO Supplier (SupplierName) VALUES
('Samsung Electronics'),
('Apple Inc.'),
('Dell Technologies'),
('HP Inc.'),
('Sony Corporation'),
('Asus'),
('Huawei'),
('Xiaomi'),
('Lenovo');

SELECT * FROM Supplier;
-- Creating the Product table
-- DROP TABLE Product;
CREATE TABLE Product (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    ImportPrice INT NOT NULL,
    ListPrice INT NOT NULL,
    Quantity INT NOT NULL,
    Discount DECIMAL(3, 2),
    AddedDate DATE,
    SupplierID INT,
    ProductType VARCHAR(50),
    FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)
);

-- Inserting sample data into Product table
-- DELETE FROM Product;
INSERT INTO Product (ProductName, ImportPrice, ListPrice, Quantity, Discount, AddedDate, SupplierID, ProductType) VALUES
('Samsung Galaxy S21', 18000000, 20000000, 100, 0.05, '2023-01-10', 1, 'Mobile'),  
('Apple iPhone 15', 22000000, 25000000, 80, 0.07, '2023-02-15', 2, 'Mobile'),
('Samsung Galaxy Tab A8', 4000000, 4500000, 50, 0.05, '2023-03-05', 1, 'Tablet'),
('Apple iPad 8th Gen', 4800000, 5000000, 70, 0.03, '2023-04-10', 2, 'Tablet'), 
('Sony WH-1000XM4', 3600000, 3800000, 120, 0.06, '2023-05-20', 5, 'Headphones'),
('MacBook Pro 16-inch', 40000000, 41000000, 30, 0.05, '2023-09-15', 2, 'Laptop'),
('Asus Zenfone Max', 8500000, 9000000, 100, 0.05, '2023-06-10', 6, 'Mobile'),
('Huawei P Smart', 4200000, 4600000, 80, 0.15, '2023-07-10', 7, 'Mobile'), 
('Xiaomi Redmi Note 10', 8800000, 10000000, 90, 0.07, '2023-06-25', 8, 'Mobile'),
('Lenovo ThinkPad E14', 4900000, 5300000, 65, 0.10, '2023-08-15', 9, 'Laptop');


-- 1. Lấy danh sách tất cả sản phẩm
SELECT * FROM Product;

-- 2. Chỉ lấy các thông tin về mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết, số lượng, % giảm giá của các sản phẩm
SELECT ProductID, ProductName, ImportPrice, ListPrice, Quantity, Discount FROM Product;

-- 3. Lấy mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết của những sản phẩm có số lượng còn lại > 60
SELECT ProductID, ProductName, ImportPrice, ListPrice FROM Product WHERE Quantity > 60;

-- 4. Lấy 3 sản phẩm mới nhất vừa được thêm vào Hệ thống
SELECT * FROM Product ORDER BY AddedDate DESC LIMIT 3;

-- 5. Lấy sản phẩm mà tên sản phẩm có chứa chữ 'Samsung'
SELECT * FROM Product WHERE ProductName LIKE '%Samsung%';

-- 6. Lấy các sản phẩm với tên có chứa 'MacBook' và giá niêm yết (giá bán) trên 7,000,000
SELECT * FROM Product WHERE ProductName LIKE '%MacBook%' AND ListPrice > 7000000;

-- 7. Lấy các sản phẩm với tên có giá niêm yết (giá bán) từ 8,000,000 đến 10,000,000
SELECT * FROM Product WHERE ListPrice BETWEEN 8000000 AND 10000000;

-- 8. Lấy mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết, số lượng, tên nhà cung cấp của tất cả sản phẩm
SELECT P.ProductID, P.ProductName, P.ImportPrice, P.ListPrice, P.Quantity, S.SupplierName
FROM Product AS P
JOIN Supplier AS S ON P.SupplierID = S.SupplierID;

-- 9. Lấy mã sản phẩm, tên sản phẩm, giá nhập, giá niêm yết (giá bán), số lượng, mã nhà cung cấp, tên nhà cung cấp, loại sản phẩm, tên loại sản phẩm của những sản phẩm có giá lớn hơn 5.000.000.
SELECT P.ProductID, P.ProductName, P.ImportPrice, P.ListPrice, P.Quantity, S.SupplierID, S.SupplierName, P.ProductType
FROM Product AS P
JOIN Supplier AS S ON P.SupplierID = S.SupplierID
WHERE P.ListPrice > 5000000;

-- 10. Lấy tất cả sản phẩm là máy tính bảng (tablet)
SELECT * FROM Product WHERE ProductType = 'Tablet';
