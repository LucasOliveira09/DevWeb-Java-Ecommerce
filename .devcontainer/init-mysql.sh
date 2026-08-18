#!/bin/bash
set -e

echo "Waiting for MySQL to be ready..."
# Wait for MySQL to accept connections
for i in {1..30}; do
  if mysqladmin ping -h"localhost" -P"3306" -uroot -proot --silent; then
    echo "MySQL is ready!"
    break
  fi
  echo "MySQL not ready yet... ($i/30)"
  sleep 1
done

# If we've tried 30 times and still not ready, exit with error
if ! mysqladmin ping -h"localhost" -P"3306" -uroot -proot --silent; then
  echo "Error: MySQL did not become ready in time."
  exit 1
fi

echo "Creating admin user..."
mysql -h"localhost" -P"3306" -uroot -proot <<-EOSQL
  CREATE USER IF NOT EXISTS 'admin'@'%' IDENTIFIED BY 'admin123';
  GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION;
  FLUSH PRIVILEGES;
EOSQL

echo "Admin user created successfully."