-- Create a MySQL user for your CRM application
CREATE USER 'vikashcrm'@'localhost' IDENTIFIED BY 'vikashcrm123';

-- Grant full privileges to that user on all databases (you can limit it later)
GRANT ALL PRIVILEGES ON *.* TO 'vikashcrm'@'localhost';

-- Ensure compatibility with MySQL native password authentication
ALTER USER 'vikashcrm'@'localhost' IDENTIFIED WITH mysql_native_password BY 'vikashcrm123';

