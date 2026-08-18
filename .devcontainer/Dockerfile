# Use Maven and OpenJDK 21 as base image
FROM maven:3.9.6-openjdk-21

# Install necessary tools including MySQL server
RUN apt-get update && apt-get install -y \
    git \
    curl \
    vim \
    mysql-server \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /workspaces/DevWeb-Java-Ecommerce

# Copy initialization scripts
COPY init-mysql.sh .devcontainer/init-mysql.sh
COPY start.sh .devcontainer/start.sh

# Make scripts executable
RUN chmod +x .devcontainer/init-mysql.sh .devcontainer/start.sh

# Expose ports
EXPOSE 8080 3306

# Start the application
CMD [".devcontainer/start.sh"]