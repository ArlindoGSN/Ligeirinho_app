CREATE TABLE driver (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    status varchar(255) NOT NULL,
    plate VARCHAR(7) UNIQUE NOT NULL,
    color VARCHAR(50),
    model VARCHAR(50),
    number_passengers INT,
    capacity INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
