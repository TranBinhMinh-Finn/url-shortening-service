CREATE TABLE IF NOT EXISTS short_url(
    id INT AUTO_INCREMENT PRIMARY KEY,
    url varchar(100),
    short_code varchar(100),
    created_at timestamp,
    updated_at timestamp,
    access_count INT
);
