
CREATE DATABASE truy_van_du_lieu;
   -- drop DATABASE truy_van_du_lieu ;
USE truy_van_du_lieu;
CREATE TABLE Class(
    class_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    ngay_bat_dau DATETIME    NOT NULL,
    status    BIT,
    start_date int not null
);
CREATE TABLE Student(
    student_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone       VARCHAR(20),
    status      BIT,
    class_id     INT         NOT NULL,
    FOREIGN KEY (class_id) REFERENCES Class (class_id)
);

CREATE TABLE `Subject`(
    sup_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sup_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    `status`  BIT  DEFAULT 1
);

CREATE TABLE Mark(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sup_id     INT NOT NULL,
    student_id INT NOT NULL,
    marks      FLOAT   DEFAULT 0 CHECK ( marks BETWEEN 0 AND 100),
    exam_time  TINYINT DEFAULT 1,
    UNIQUE (sup_id, student_id),
    FOREIGN KEY (sup_id) REFERENCES `Subject` (sup_id),
    FOREIGN KEY (student_id) REFERENCES `Student` (student_id)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (student_name, address, phone, status, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (student_name, address, status, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (student_name, address, phone, status, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `Subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (sup_id, student_id, marks, exam_time) VALUES (1, 1, 8, 1);
 select * from Class;
 select * from Student;
 select * from `Subject`;
 select * from Mark;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student
where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from class where month(start_date)  =12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set sql_safe_updates = 0;
update student set class_id = 2 where student_name ='Hung';
set sql_safe_updates = 1;

-- Hiển thị các thông tin:  StudentName, SubName, Mark Dữ liệu sắp xếp theo điểm thi (mark)
-- giảm dần. nếu trùng sắp theo tên tăng dần.
select s.student_name,s.sup_name,m.marks from student s
join mark m on s.student_id = m.student_id
join Subject s on m.sup_id = s.sup_id
order by m.marks desc, s.student_name asc;