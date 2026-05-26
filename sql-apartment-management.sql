CREATE TABLE Account(
 id BIGSERIAL PRIMARY KEY,
 email VARCHAR(50) NOTNULL UNIQUE,
 phone VARCHAR(11) UNIQUE,
 username VARCHAR(50) NOTNULL UNIQUE,
 password VARCHAR(100) NOTNULL,
 role VARCHAR(20) DEFAULT 'USER',
 status VARCHAR(20) DEFAULT 'ACTIVE',
 create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


SELECT * FROM Account
Where email = 'tai@gmail.com' OR phone = '123123' OR username = 'tai'


CREATE TABLE Profile(
id BIGSERIAL PRIMARY KEY,
account_id BIGINT NOT NULL UNIQUE,
full_name VARCHAR(50) NOT NULL,
birth_date DATE,
bio VARCHAR(255),
	CONSTRAINT fk_profile_account
		FOREIGN KEY (account_id)
		REFERENCES Account(id)
);


Se