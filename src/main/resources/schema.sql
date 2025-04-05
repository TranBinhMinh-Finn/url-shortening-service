CREATE table IF NOT EXISTS short_url(
    id INT AUTO_INCREMENT PRIMARY KEY,
    url varchar(100),
    short_code varchar(100)
);