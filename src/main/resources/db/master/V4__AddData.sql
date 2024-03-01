--README !!!
--Remember to edit FK in program table
--Run the older script in github first, make sure id in other table start at 1
use Capstone_db
go

INSERT INTO Semester
VALUES
('2024-07-15', '2024-09-09'),
('2024-07-30', '2024-12-01'),
('2024-04-16', '2024-10-29'),
('2024-07-07', '2024-11-15'),
('2024-06-09', '2024-10-20'),
('2024-07-12', '2024-11-09');

--Template
--INSERT INTO Program
--VALUES
--('Active', '2024-02-09',null,'5 months',N'',5000,2,1,1,1,null,null,N'');

--Note: assume that FK in [State] and [UniversityType] start at 1
--Template for table below
--(1,22,57410,'', '')
ALTER TABLE University
ALTER COLUMN [description] nvarchar(700);

INSERT INTO University
VALUES
(1,22,62142,N'Đại học Michigan (U-M, UMich, hay đơn giản là Michigan) là một trường đại học nghiên cứu công lập ở Ann Arbor, Michigan. Được thành lập vào năm 1817, đây là tổ chức giáo dục đại học lâu đời nhất trong tiểu bang. Michigan là một trong những trường đại học nghiên cứu sớm nhất của Mỹ và là thành viên sáng lập của Hiệp hội các trường đại học Mỹ.', N'University of Michigan'),
(2,31,57410,N'Princeton University có hệ thống thư viện với hơn 11 triệu đầu sách. Thư viện chính của trường Firestone chứa khoảng 4 triệu cuốn sách và là một trong những thư viện đại học lớn nhất thế giới. Bên cạnh Thư viện Firestone, nhiều ngành học của trường cũng có các thư viện riêng, bao gồm: Kiến trúc, Lịch sử Nghệ thuật, Nghiên cứu Đông Á, Kỹ thuật, Địa lý, Ngoại giao và chính sách công,...đủ để sinh viên của trường thỏa mãn tìm tòi kiến thức cũng như "tự hào" tuyệt đối với hệ thống thư viên siêu "sịn xò" của trường.', N'Princeton University'),
(2,21,24000,N'Đại học Đông Bắc (NU hoặc NEU) là một trường đại học nghiên cứu tư nhân có cơ sở chính ở Boston, Massachusetts. Được thành lập vào năm 1898, trường được thành lập bởi Hiệp hội Cơ đốc giáo nam thanh niên Boston với tư cách là một học viện toàn nam trước khi được thành lập thành Trường Cao đẳng Đông Bắc vào năm 1916, đạt danh hiệu đại học vào năm 1922. Với hơn 36.000 sinh viên, Northeastern là một trong những trường đại học lớn nhất ở Massachusetts bằng cách ghi danh.', N'Northeastern University');


ALTER TABLE Program
ADD [program_name] nvarchar(255);

ALTER TABLE Program
ALTER COLUMN [description] nvarchar(600);

--Note: don't know price, fake price

INSERT INTO Program
VALUES
('Active', '2024-02-09',null,'2 months',N'Chương trình này giới thiệu chuyên ngành khoa học máy tính rộng hơn cho những người có kiến ​​thức cơ bản về lập trình Java. Nó bao gồm nửa sau của cuốn sách "Computer Science: An Interdisciplinary Approach" ',5000,2,1,1,1,null,null,N'Computer Science: Algorithms, Theory, and Machines'),
('Active', '2024-02-09',null,'2 months',N'Nền tảng của giáo dục trong thiên niên kỷ qua là “đọc, viết và số học”; bây giờ nó là đọc, viết và tính toán. Học lập trình là một phần thiết yếu trong quá trình giáo dục của mỗi học sinh, không chỉ trong các môn khoa học và kỹ thuật mà còn trong nghệ thuật, khoa học xã hội và nhân văn. Ngoài các ứng dụng trực tiếp, đây là bước đầu tiên để hiểu bản chất của tác động không thể phủ nhận của khoa học máy tính đối với thế giới hiện đại.',5000,2,1,1,1,null,null,N'Computer Science: Programming with a Purpose'),
('Active', '2024-02-09',null,'5 months',N'Chương trình này sẽ giới thiệu các khái niệm lập trình cơ bản bao gồm cấu trúc dữ liệu, giao diện chương trình ứng dụng nối mạng và cơ sở dữ liệu, sử dụng ngôn ngữ lập trình Python.',3500,1,1,2,1,null,null,N'Python for Everybody Specialization'),
('Active', '2024-02-09',null,'5 months',N'Tất cả chúng ta đều đàm phán hàng ngày. Ở cấp độ cá nhân, chúng ta thương lượng với bạn bè, gia đình, chủ nhà, người bán xe và người sử dụng lao động, cùng những người khác. Đàm phán cũng là chìa khóa thành công trong kinh doanh. Không doanh nghiệp nào có thể tồn tại nếu không có những hợp đồng sinh lời. Trong một công ty, kỹ năng đàm phán có thể dẫn đến thăng tiến nghề nghiệp.',3500,1,3,2,1,null,null,N'Successful Negotiation: Essential Strategies and Skills'),
('Active', '2024-02-09',null,'6 months',N'Với Thạc sĩ Khoa học về Hệ thống Thông tin của Đại học Đông Bắc, bạn sẽ học cách sử dụng công nghệ để giải quyết những thách thức mà mọi người trong các doanh nghiệp, tổ chức và cộng đồng trên toàn thế giới phải đối mặt. Được thiết kế dành cho sinh viên tốt nghiệp từ mọi nền tảng, MSIS trang bị cho bạn các kỹ năng kỹ thuật và chuyên môn quản lý kinh doanh để thúc đẩy chuyển đổi kỹ thuật số trong bất kỳ tổ chức nào. Bạn sẽ có được kiến ​​thức ứng dụng sâu rộng trên nhiều lĩnh vực công nghệ, bao gồm thiết kế UX, phát triển phần mềm, phân tích dữ liệu và quy trình kinh doanh kỹ thuật số.',2400,3,1,3,1,null,null,N'Master of Science in Information Systems'),
('Active', '2024-02-09',null,'4 months',N'Được tạo vào năm 2014, Chuyên ngành này được cập nhật hàng quý để đảm bảo bạn được đào tạo cập nhật nhất. Chuyên ngành Tiếp thị Truyền thông Xã hội được thiết kế để đạt được hai mục tiêu. Nó cung cấp cho bạn các công cụ phân tích xã hội và đào tạo để giúp bạn trở thành người có ảnh hưởng trên mạng xã hội.',3700,3,2,4,2,null,null,'Social Media Marketing Specialization')
