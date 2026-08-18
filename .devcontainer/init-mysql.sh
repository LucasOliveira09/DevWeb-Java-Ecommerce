#!/bin/bash

# "fail-fast": se qualquer comando der erro, o script para na hora.
set -e

# Inicia o servidor MySQL (o "service" lê o script /etc/init.d/mysql).
echo "Iniciando MySQL..."
service mysql start

# O comando acima retorna antes do MySQL aceitar conexões.
# Fica tentando até o servidor responder (máx. 30 tentativas de 1s).
# O "mysqladmin ping" é o "ping" no servidor: se responder, o loop para.
# O "sleep 1" espera 1s antes de tentar de novo.
echo "Aguardando MySQL ficar pronto..."
for tentativa in $(seq 1 30); do
    if mysqladmin ping --silent; then
        echo "MySQL pronto."
        break
    fi
    sleep 1
done

# Se passou das 30 tentativas sem resposta, para o script com erro.
if ! mysqladmin ping --silent; then
    echo "Erro: MySQL não respondeu a tempo." >&2
    exit 1
fi

# Cria o banco e o usuário que a aplicação Spring Boot vai usar.
echo "Configurando banco..."

# O "mysql <<EOF" envia os comandos abaixo direto para o MySQL.
mysql <<EOF
CREATE DATABASE IF NOT EXISTS ecommerce
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'sergio'@'%' IDENTIFIED BY '123@Mudar';

GRANT ALL PRIVILEGES ON ecommerce.* TO 'sergio'@'%';

FLUSH PRIVILEGES;
EOF

echo "MySQL configurado com sucesso!"
