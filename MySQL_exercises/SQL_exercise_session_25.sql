CREATE DATABASE ThucTap;
-- DROP DATABASE ThucTap;
USE ThucTap;

CREATE TABLE TBLKhoa (
    Makhoa char(10) primary key,
    Tenkhoa char(30),
    Dienthoai char(10)
);

CREATE TABLE TBLGiangVien(
    Magv int primary key,
    Hotengv char(30),
    Luong decimal(5, 2),
    Makhoa char(10),
    foreign key (Makhoa) references TBLKhoa(Makhoa)
);
-- DROP TABLE TBLGiangVien;

CREATE TABLE TBLSinhVien(
    Masv int primary key,
    Hotensv char(40),
    Makhoa char(10), 
    Namsinh int,
    Quequan char(30),
    foreign key (Makhoa) references TBLKhoa(Makhoa)
);

CREATE TABLE TBLDeTai(
    Madt char(10) primary key,
    Tendt char(30),
    Kinhphi int,
    Noithuctap char(30)
);

CREATE TABLE TBLHuongDan(
    Masv int primary key,
    Madt char(10),
    Magv int,
    KetQua decimal(5, 2),    
    foreign key (Madt) references TBLDeTai(Madt),
	foreign key (Magv) references TBLGiangVien(Magv)    
);

INSERT INTO
    TBLKhoa
VALUES
    ('Geo', 'Dia ly va QLTN', 3855413),
    ('Math', 'Toan', 3855411),
    ('Bio', 'Cong nghe Sinh hoc', 3855412);

INSERT INTO
    TBLGiangVien
VALUES
    (11, 'Thanh Binh', 700, 'Geo'),
    (12, 'Thu Huong', 500, 'Math'),
    (13, 'Chu Vinh', 650, 'Geo'),
    (14, 'Le Thi Ly', 500, 'Bio'),
    (15, 'Tran Son', 900, 'Math');

INSERT INTO
    TBLSinhVien
VALUES
    (1, 'Le Van Son', 'Bio', 1990, 'Nghe An'),
    (2, 'Nguyen Thi Mai', 'Geo', 1990, 'Thanh Hoa'),
    (3, 'Bui Xuan Duc', 'Math', 1992, 'Ha Noi'),
    (4, 'Nguyen Van Tung', 'Bio', null, 'Ha Tinh'),
    (5, 'Le Khanh Linh', 'Bio', 1989, 'Ha Nam'),
    (6, 'Tran Khac Trong', 'Geo', 1991, 'Thanh Hoa'),
    (7, 'Le Thi Van', 'Math', null, 'null'),
    (8, 'Hoang Van Duc', 'Bio', 1992, 'Nghe An');

INSERT INTO
    TBLDeTai
VALUES
    ('Dt01', 'GIS', 100, 'Nghe An'),
    ('Dt02', 'ARC GIS', 500, 'Nam Dinh'),
    ('Dt03', 'Spatial DB', 100, 'Ha Tinh'),
    ('Dt04', 'MAP', 300, 'Quang Binh');

INSERT INTO
    TBLHuongDan
VALUES
    (1, 'Dt01', 13, 8),
    (2, 'Dt03', 14, 0),
    (3, 'Dt03', 12, 10),
    (5, 'Dt04', 14, 7),
    (6, 'Dt01', 13, Null),
    (7, 'Dt04', 11, 10),
    (8, 'Dt03', 15, 6);
 
   
-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
	SELECT g.Magv,g.Hotengv,k.Tenkhoa  
	FROM TBLGiangVien g
	JOIN TBLKhoa k ON g.Makhoa = k.Makhoa;
-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’  
	SELECT g.Magv,g.Hotengv,k.Tenkhoa  
	FROM TBLGiangVien g
	JOIN TBLKhoa k ON g.Makhoa = k.Makhoa 
	WHERE k.Tenkhoa = 'Dia ly va QLTN';
	
-- 3.	Cho biết số sinh viên của khoa ‘Cong nghe Sinh hoc’
SELECT k.Tenkhoa, COUNT(s.Masv) AS SoSinhVien
FROM TBLSinhVien s
JOIN TBLKhoa k ON s.Makhoa = k.Makhoa
WHERE k.Tenkhoa = 'Cong nghe Sinh hoc';

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘Toan’
SELECT s.Masv, s.Hotensv, YEAR(CURRENT_DATE()) - s.Namsinh AS Tuoi
FROM TBLSinhVien s
JOIN TBLKhoa k ON s.Makhoa = k.Makhoa
WHERE k.Tenkhoa = 'Toan';

-- 5.	Cho biết số giảng viên của khoa ‘Cong nghe Sinh hoc’
SELECT k.Tenkhoa, COUNT(g.Magv) AS SoGiangVien
FROM TBLGiangVien g
JOIN TBLKhoa k ON g.Makhoa = k.Makhoa 
WHERE k.Tenkhoa = 'Cong nghe Sinh hoc';

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
SELECT * FROM TBLSinhVien;
SELECT * FROM TBLHuongDan;
SELECT s.Masv, s.Hotensv, s.Makhoa, s.Namsinh, s.Quequan
FROM TBLSinhVien s
LEFT JOIN TBLHuongDan h ON s.Masv = h.Masv
WHERE h.Masv IS NULL;

SELECT *
FROM TBLSinhVien s
LEFT JOIN TBLHuongDan h ON s.Masv = h.Masv;

SELECT *
FROM TBLSinhVien s
JOIN TBLHuongDan h ON s.Masv = h.Masv;

-- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
SELECT k.Makhoa, k.Tenkhoa , COUNT(g.Makhoa) AS SoGiangVien
FROM TBLGiangVien g
JOIN TBLKhoa k ON g.Makhoa = k.Makhoa 
GROUP BY g.Makhoa;

-- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le Van Son’ đang theo học
SELECT * FROM TBLSinhVien;
SELECT k.Tenkhoa, k.Dienthoai AS SoDienThoai
FROM TBLSinhVien sv
JOIN TBLKhoa k ON sv.Makhoa = k.Makhoa 
WHERE sv.Hotensv = 'Le Van Son'

-- II
-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
-- 6.	Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
-- 7.	Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
-- 8.	Cho biết thông tin về các sinh viên thực tập tại quê nhà
-- 9.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
-- 10.	Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
