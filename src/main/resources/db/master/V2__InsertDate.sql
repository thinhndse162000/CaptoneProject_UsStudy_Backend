USE Capstone_db
go

ALTER TABLE Major
ALTER COLUMN [description] nvarchar(600);

INSERT INTO Major (major_name,[description])
VALUES
    (N'Khoa học máy tính - Công nghệ thông tin',N'Mỹ là quốc gia đang dẫn đầu về lĩnh vực máy tính, công nghệ trên toàn thế giới. Việc du học Mỹ ngành Công nghệ thông tin sẽ giúp bạn có cơ hội tiếp cận với nền giáo dục tân tiến, cơ sở vật chất hiện đại cùng nhiều cơ hội nghề nghiệp hấp dẫn.'),
    (N'Ngành kinh doanh và quản trị',N'Khi du học Mỹ ngành quản trị kinh doanh, bạn sẽ có nhiều lợi thế hơn học ngành này tại đất nước khác. Trước tiên, Mỹ là trung tâm kinh tế vững mạnh toàn cầu cùng chất lượng đào tạo số một thế giới. Đặc biệt tại Mỹ có rất nhiều trung tâm tài chính cũng như trụ sở của các công ty tài chính phát triển, có bề dày lịch sử. Vì vậy khi theo học ngành này tại Mỹ, cơ hội việc làm sau này của bạn vô cùng rộng mở, cơ hội đầu quân cho các công ty lớn trên thế giới là rất lớn. Bên cạnh đó, tấm bằng ngành Quản trị kinh doanh tại Mỹ được công nhận trên toàn thế giới và thu hút các nhà tuyển dụng hàng đầu'),
    (N'Ngành khoa học xã hội và nhân văn',N'Ngành khoa học xã hội và nhân văn là một lĩnh vực nghiên cứu các chủ đề liên quan đến đời sống con người, bao gồm: xã hội, văn hoá, lịch sử, kinh tế, chính trị, tâm lý học, tâm sinh lý học, pháp luật,... KHXH&NV tập trung vào việc phân tích, diễn giải và hiểu rõ những khía cạnh khác nhau của xã hội và con người, giúp cải thiện chất lượng cuộc sống và đóng góp vào sự phát triển của xã hội.'),
    (N'Ngành nghệ thuật sáng tạo - thiết kế',N'Ngành nghệ thuật sáng tạo và thiết kế là ngành học mà sinh viên khi theo đuổi sẽ được làm quen và trau dồi những kiến thức phù hợp, thực tế với công việc sau này trong nhiều các khía cạnh đa dạng khác nhau liên quan tới nghệ thuật và thiết kế như: âm nhạc (music producer, hướng nghiệp nghề ca sĩ, guitarist,...), mỹ thuật (ngành hội hoạ), sân khấu điện ảnh (ngành diễn viên điện ảnh, ngành nhiếp ảnh, cameraman,...), múa, thiết kế thời trang (các bản thiết kế thời trang)'),
    (N'Ngành kiến trúc - xây dựng',N'Cơ hội việc làm ngành kiến trúc ở Mỹ cực kỳ rộng mở trong những năm gần đây. Đây là một trong những ngành thiếu hụt nhân sự tại Mỹ và nhiều nước trên thế giới. Do đó, chính sách việc làm và định cư cho ngành này rất thông thoáng')

ALTER TABLE UniversityType
ALTER COLUMN [description] nvarchar(600);

INSERT INTO UniversityType
VALUES
    (N'Các trường đại học công lập',N'Các trường đại học công lập là các tổ chức giáo dục đại học được tài trợ bởi các phương tiện công cộng, nghĩa là chúng được nhà nước tài trợ chứ không phải các trường đại học tư. Những trường đại học này có quy mô khác nhau; tuy nhiên, chúng thường có quy mô lớn hơn so với trường tư và có đặc điểm là học phí thấp hơn.'),
    (N'Đại học tư thục',N'Các trường đại học tư không được chính phủ tiểu bang tài trợ và chiếm một số lượng đáng kể trong số lượng tuyển sinh ở Hoa Kỳ. Tuy nhiên, do thực tế là chúng không được tài trợ bằng tiền của người nộp thuế mà chủ yếu dựa vào các khoản quyên góp, tài trợ và học phí. , các trường đại học này có xu hướng có học phí cao hơn các trường đại học công lập.'),
    (N'Các trường đại học tư thục vì lợi nhuận',N'Các trường đại học tư thục vì lợi nhuận khác biệt với các trường phi lợi nhuận vì mục tiêu của họ không chỉ là giáo dục sinh viên mà còn tạo ra doanh thu cho các cổ đông và họ có xu hướng hướng tới việc kiếm tiền. Tuy nhiên, điều này không nhất thiết có nghĩa là các trường đại học này cũng không cung cấp nền giáo dục chất lượng. Trên thực tế, có rất nhiều trường đại học tư thục vì lợi nhuận với chương trình giảng dạy tuyệt vời.'),
    (N'Các trường đại học tư thục phi lợi nhuận',N'Mục đích chính của các trường đại học tư thục phi lợi nhuận không phải là trở thành tổ chức có lợi nhuận cao nhất mà là cung cấp nền giáo dục chất lượng cao. Các tổ chức này thường có danh tiếng tốt hơn so với các tổ chức vì lợi nhuận do họ tập trung hơn vào việc sản xuất các chương trình giảng dạy và giáo dục chất lượng cao.'),
    (N'Các trường đại học nghiên cứu',N'Các trường đại học nghiên cứu có thể là trường đại học công lập và tư thục phi lợi nhuận, được coi là các cơ sở cấp bằng tiến sĩ chi hàng triệu đô la cho chi phí nghiên cứu và có các hoạt động nghiên cứu cao.'),
    (N'Các trường Ivy League',N'Các trường Ivy League bao gồm tám trường đại học có trụ sở tại Đông Bắc Hoa Kỳ và là một hội nghị thể thao của các trường đại học Hoa Kỳ. Tuy nhiên, mối liên kết giữa các trường đại học này vượt ra ngoài thể thao và tất cả đều được đánh giá cao về thành tích học tập xuất sắc, tinh hoa xã hội và tính chọn lọc trong tuyển sinh.')

ALTER TABLE ProgramType
ALTER COLUMN [description] nvarchar(300);

INSERT INTO ProgramType (type_name,description)
VALUES
    (N'Du học tự túc',N'hình thức du học trong đó du học sinh tự chi trả các chi phí liên quan đến du học.  Có một số xu hướng du học phổ biến với học sinh, sinh viên Việt Nam.'),
	(N'Du học học bổng toàn phần',N'là gói học bổng bao gồm 100% học phí và các khoản tiền sinh hoạt (tiền ăn, tiền nhà ở, tiền bảo hiểm), và các chi phí học tập khác như tiền tại liệu, vật dụng để học tập và nghiên cứu.'),
    (N'Du học học bổng 1 phần',N'Dạng học bổng này thường do các trường, các tổ chức xã hội, các công ty, các các nhân… cung cấp. Nó có thể là học bổng cả một khóa học, hoặc chỉ một vài năm học, một vài kỳ học, hoặc thậm chí chỉ một vài tháng, hay chỉ là một khóa học ngắn hạn như học bổng trao đổi sinh viên.')

INSERT INTO State (state_name)
VALUES (N'Tiểu bang Alabama'),
    (N'Tiểu bang Alaska'),
    (N'Tiểu bang Arizona'),
    (N'Tiểu bang Arkansas'),
    (N'Tiểu bang California'),
    (N'Tiểu bang Colorado'),
    (N'Tiểu bang Connecticut'),
    (N'Tiểu bang Delaware'),
    (N'Tiểu bang Florida'),
    (N'Tiểu bang Georgia'),
    (N'Tiểu bang Hawaii'),
    (N'Tiểu bang Idaho'),
    (N'Tiểu bang Illinois'),
    (N'Tiểu bang Indiana'),
    (N'Tiểu bang Iowa'),
    (N'Tiểu bangKansas'),
    (N'Tiểu bangKentucky'),
    (N'Tiểu bangLouisiana'),
    (N'Tiểu bangMaine'),
    (N'Tiểu bangMaryland'),
    (N'Tiểu bang Massachusetts'),
    (N'Tiểu bang Michigan'),
    (N'Tiểu bang Minnesota'),
    (N'Tiểu bang Mississippi'),
    (N'Tiểu bang Missouri'),
    (N'Tiểu bang Montana'),
    (N'Tiểu bang Nebraska'),
    (N'Tiểu bang Nevada'),
    (N'Tiểu bang New Hampshire'),
    (N'Tiểu bang New Jersey'),
    (N'Tiểu bang New Mexico'),
    (N'Tiểu bang New York'),
    (N'Tiểu bang North Carolina'),
    (N'Tiểu bang North Dakota'),
    (N'Tiểu bang Ohio'),
    (N'Tiểu bang Oklahoma'),
    (N'Tiểu bang Oregon'),
    (N'Tiểu bang Pennsylvania'),
    (N'Tiểu bang Rhode Island'),
    (N'Tiểu bang South Carolina'),
    (N'Tiểu bang South Dakota'),
    (N'Tiểu bang Tennessee'),
    (N'Tiểu bang Texas'),
    (N'Tiểu bang Utah'),
    (N'Tiểu bang Vermont'),
    (N'Tiểu bang Virginia'),
    (N'Tiểu bang Washington'),
    (N'Tiểu bang West Virginia'),
    (N'Tiểu bang Wisconsin'),
    (N'Tiểu bang Wyoming'),
    (N'Tiểu bang Washington D.C.'),
    (N'Tiểu bang Puerto Rico');
