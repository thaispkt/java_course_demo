CREATE DATABASE ThucTap;
-- DROP DATABASE ThucTap;
USE ThucTap;

CREATE TABLE Khoa (
    MaKhoa char(10) primary key,
    TenKhoa char(30),
    DienThoai char(10)
);

CREATE TABLE GiangVien(
    MaGV int primary key,
    HoTenGv char(30),
    Luong decimal(5, 2),
    MaKhoa char(10),
    foreign key (MaKhoa) references Khoa(MaKhoa)
);
-- DROP TABLE GiangVien;

CREATE TABLE SinhVien(
    MaSV int primary key,
    HoTenSV char(40),
    MaKhoa char(10), 
    NamSinh int,
    QueQuan char(30),
    foreign key (MaKhoa) references Khoa(MaKhoa)
);

CREATE TABLE DeTai(
    MaDeTai char(10) primary key,
    TenDeTai char(30),
    Kinhphi int,
    NoiThucTap char(30)
);

CREATE TABLE HuongDan(
    MaSV int primary key,
    MaDeTai char(10),
    MaGV int,
    KetQua decimal(5, 2),    
    foreign key (MaDeTai) references DeTai(MaDeTai),
	foreign key (MaGV) references GiangVien(MaGV)    
);

INSERT INTO
    Khoa
VALUES
    ('Geo', 'Dia ly va QLTN', 3855413),
    ('Math', 'Toan', 3855411),
    ('Bio', 'Cong nghe Sinh hoc', 3855412);

INSERT INTO
    GiangVien
VALUES
    (11, 'Thanh Binh', 700, 'Geo'),
    (12, 'Thu Huong', 500, 'Math'),
    (13, 'Chu Vinh', 650, 'Geo'),
    (14, 'Le Thi Ly', 500, 'Bio'),
    (15, 'Tran Son', 900, 'Math');

INSERT INTO
    SinhVien
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
    DeTai
VALUES
    ('Dt01', 'GIS', 100, 'Nghe An'),
    ('Dt02', 'ARC GIS', 500, 'Nam Dinh'),
    ('Dt03', 'Spatial DB', 100, 'Ha Tinh'),
    ('Dt04', 'MAP', 300, 'Quang Binh');

INSERT INTO
    HuongDan
VALUES
    (1, 'Dt01', 13, 8),
    (2, 'Dt03', 14, 0),
    (3, 'Dt03', 12, 10),
    (5, 'Dt04', 14, 7),
    (6, 'Dt01', 13, Null),
    (7, 'Dt04', 11, 10),
    (8, 'Dt03', 15, 6);
 
   
-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên Khoa của tất cả các giảng viên
	SELECT gv.MaGV,gv.HoTenGv,k.TenKhoa  
	FROM GiangVien gv
	JOIN Khoa k ON gv.MaKhoa = k.MaKhoa;

-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên Khoa của các giảng viên của Khoa ‘DIA LY va QLTN’  
	SELECT gv.MaGV,gv.HoTenGv,k.TenKhoa  
	FROM GiangVien gv
	JOIN Khoa k ON gv.MaKhoa = k.MaKhoa 
	WHERE k.TenKhoa = 'Dia ly va QLTN';
	
-- 3.	Cho biết số sinh viên của Khoa ‘Cong nghe Sinh hoc’
	SELECT k.TenKhoa, COUNT(sv.MaSV) AS SoSinhVien
	FROM SinhVien sv
	JOIN Khoa k ON sv.MaKhoa = k.MaKhoa
	WHERE k.TenKhoa = 'Cong nghe Sinh hoc';

-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên Khoa ‘Toan’
	SELECT sv.MaSV, sv.HoTenSV, YEAR(CURRENT_DATE()) - sv.NamSinh AS Tuoi
	FROM SinhVien sv
	JOIN Khoa k ON sv.MaKhoa = k.MaKhoa
	WHERE k.TenKhoa = 'Toan';

-- 5.	Cho biết số giảng viên của Khoa ‘Cong nghe Sinh hoc’
	SELECT k.TenKhoa, COUNT(gv.MaGV) AS SoGiangVien
	FROM GiangVien gv
	JOIN Khoa k ON gv.MaKhoa = k.MaKhoa 
	WHERE k.TenKhoa = 'Cong nghe Sinh hoc';

-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
	SELECT sv.MaSV, sv.HoTenSV, sv.MaKhoa, sv.NamSinh, sv.QueQuan
	FROM SinhVien sv
	LEFT JOIN HuongDan hd ON sv.MaSV = hd.MaSV
	WHERE hd.MaSV IS NULL;

-- 7.	Đưa ra mã Khoa, tên Khoa và số giảng viên của mỗi Khoa
	SELECT k.MaKhoa, k.TenKhoa , COUNT(gv.MaKhoa) AS SoGiangVien
	FROM GiangVien gv
	JOIN Khoa k ON gv.MaKhoa = k.MaKhoa 
	GROUP BY gv.MaKhoa;

-- 8.	Cho biết số điện thoại của Khoa mà sinh viên có tên ‘Le Van Son’ đang theo học
	SELECT k.TenKhoa, k.DienThoai AS SoDienThoai
	FROM SinhVien sv
	JOIN Khoa k ON sv.MaKhoa = k.MaKhoa 
	WHERE sv.HoTenSV = 'Le Van Son';

-- II
-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
	SELECT dt.MaDeTai, dt.TenDeTai
	FROM GiangVien gv
	JOIN HuongDan hd ON gv.MaGV = hd.MaGV
	JOIN DeTai dt ON hd.MaDeTai = dt.MaDeTai
	WHERE gv.HoTenGv = 'Tran Son';

-- 2.	Cho biết tên đề tài không có sinh viên nào được thực tập
	SELECT TenDeTai
	FROM DeTai
	WHERE MaDeTai NOT IN (SELECT MaDeTai FROM HuongDan);

-- 3.	Cho biết mã số, họ tên, tên Khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
	SELECT gv.MaGV, gv.HoTenGV, k.TenKhoa
	FROM GiangVien gv
	JOIN Khoa k ON gv.MaKhoa = k.MaKhoa
	WHERE gv.MaGV IN (
	    SELECT MaGV
	    FROM HuongDan
	    GROUP BY MaGV
	    HAVING COUNT(MaSV) >= 3
	);

-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
	SELECT MaDeTai, TenDeTai, KinhPhi
	FROM DeTai
	WHERE KinhPhi = (SELECT MAX(KinhPhi) FROM DeTai);

-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
	SELECT dt.MaDeTai, dt.TenDeTai
	FROM DeTai dt
	JOIN HuongDan hd ON dt.MaDeTai = hd.MaDeTai
	GROUP BY dt.MaDeTai, dt.TenDeTai
	HAVING COUNT(hd.MaSV) > 2;

-- 6.	Đưa ra mã số, họ tên và điểm của các sinh viên Khoa ‘DIA LY và QLTN’
	SELECT sv.MaSV, sv.HoTenSV, hd.KetQua
	FROM SinhVien sv
	LEFT JOIN HuongDan hd ON sv.MaSV = hd.MaSV
	WHERE sv.MaKhoa = (SELECT MaKhoa FROM Khoa WHERE TenKhoa = 'Dia ly va QLTN');

-- 7.	Đưa ra tên Khoa, số lượng sinh viên của mỗi Khoa
	SELECT k.TenKhoa, COUNT(sv.MaSV) AS SoLuongSV
	FROM Khoa k
	LEFT JOIN SinhVien sv ON k.MaKhoa = sv.MaKhoa
	GROUP BY k.TenKhoa;

-- 8.	Cho biết thông tin về các sinh viên thực tập tại quê nhà
	SELECT sv.MaSV, sv.HoTenSV, sv.QueQuan, dt.NoiThucTap, dt.TenDeTai
	FROM SinhVien sv
	JOIN HuongDan hd ON sv.MaSV = hd.MaSV
	JOIN DeTai dt ON hd.MaDeTai = dt.MaDeTai
	WHERE sv.QueQuan = dt.NoiThucTap;

-- 9.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
	SELECT sv.MaSV, sv.HoTenSV, hd.KetQua
	FROM SinhVien sv
	LEFT JOIN HuongDan hd ON sv.MaSV = hd.MaSV
	WHERE hd.KetQua IS NULL;

-- 10.	Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
	SELECT sv.MaSV, sv.HoTenSV
	FROM SinhVien sv
	JOIN HuongDan hd ON sv.MaSV = hd.MaSV
	WHERE hd.KetQua = 0;
