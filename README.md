# CapstoneProject_UsStudy_Backend
SE Capstone Project Topic UsStudy Backend

# FlyWAy Migration Guide
1 tạo file.sql.
2 đánh version để nhận biết
3 viết script băng ngôn ngữ SQL như bth
4 cài mvn | mvn -install
5 migration db trên local | mvn flyway:migrate -P local

# Lưu ý về Flyway
1 không thay đổi file migration V1_initial.sql bản gốc
2 thay đổi database cần tạo ra 1 version mới không bị conflict