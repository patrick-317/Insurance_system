
CREATE TABLE customer (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          password VARCHAR(255),
                          name VARCHAR(100),
                          age INT,
                          account VARCHAR(50),
                          gender ENUM('MALE', 'FEMALE') NOT NULL,
                          address VARCHAR(255),
                          phoneNumber VARCHAR(50),
                          job VARCHAR(100),
                          email VARCHAR(100),
                          birthdate DATE,
                          creditRating ENUM('FIRST', 'SECOND', 'THIRD', 'FOURTH', 'FIFTH') NOT NULL,
                          abroad ENUM('DOMESTIC', 'ABROAD') NOT NULL,
                          contractStatus ENUM('ACTIVE', 'PENDING', 'REJECTED', 'EXPIRED') NOT NULL DEFAULT 'PENDING',
                          crime ENUM('NO_RECORD', 'HAS_RECORD') NOT NULL,
                          disease ENUM('HAS_HISTORY', 'NO_HISTORY') NOT NULL,
                          drink ENUM('FREQUENT', 'MODERATE', 'RARE', 'NONE') NOT NULL,
                          drive ENUM('DRIVER', 'NON_DRIVER') NOT NULL,
                          identityNum VARCHAR(50),
                          military ENUM('COMPLETED', 'EXEMPTED', 'NONE') NOT NULL
);

CREATE TABLE insurance (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100),
                           description VARCHAR(255),
                           premium VARCHAR(50),
                           coverage VARCHAR(50),
                           term VARCHAR(50),
                           maxAge INT,
                           exclusions VARCHAR(255),
                           insuranceType ENUM('LIFE_INSURANCE', 'DAMAGE_INSURANCE', 'THIRD_INSURANCE') NOT NULL
);

CREATE TABLE contract (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          customerId INT NOT NULL,
                          insuranceId INT NOT NULL,
                          contractDate DATE,
                          premium VARCHAR(50) NOT NULL,
                          contractStatus ENUM('ACTIVE', 'PENDING', 'REJECTED', 'EXPIRED') NOT NULL DEFAULT 'PENDING',
                          FOREIGN KEY (customerId) REFERENCES customer(id),
                          FOREIGN KEY (insuranceId) REFERENCES insurance(id)
);

CREATE TABLE request (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         customerID INT,
                         accidentInfo VARCHAR(255),
                         beneficiaryInfo VARCHAR(255),
                         bill VARCHAR(50),
                         memberInfo VARCHAR(50),
                         SSN VARCHAR(50),
                         FOREIGN KEY (customerID) REFERENCES customer(id)
);

CREATE TABLE employee (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          accountNum VARCHAR(50),
                          department VARCHAR(100),
                          email VARCHAR(100),
                          employeeID VARCHAR(50) UNIQUE,
                          HP VARCHAR(20),
                          name VARCHAR(100),
                          position VARCHAR(50)
);

CREATE TABLE complaint (
                           customerID INT,
                           employeeID INT,
                           customerInfo VARCHAR(255),
                           date DATE,
                           department VARCHAR(100),
                           details VARCHAR(255),
                           title VARCHAR(100),
                           PRIMARY KEY (customerID, employeeID, date),
                           FOREIGN KEY (customerID) REFERENCES customer(id),
                           FOREIGN KEY (employeeID) REFERENCES employee(id)
);

CREATE TABLE underwriting (
                              customerID INT PRIMARY KEY,
                              FOREIGN KEY (customerID) REFERENCES customer(id)
);

CREATE TABLE payment ( id INT AUTO_INCREMENT PRIMARY KEY, customer_id INT NOT NULL, insurance_id INT NOT NULL, amount DECIMAL(10, 2) NOT NULL, payment_date DATE NOT NULL, status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING', FOREIGN KEY (customer_id) REFERENCES customer(id), FOREIGN KEY (insurance_id) REFERENCES insurance(id));
 ALTER TABLE payment MODIFY amount VARCHAR(255) NOT NULL;
ALTER TABLE payment MODIFY payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;