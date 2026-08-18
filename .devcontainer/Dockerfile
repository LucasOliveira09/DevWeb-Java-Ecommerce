# Base: já vem com Temurin JDK 21 e Maven 3.9 instalados.
# Variante "noble" = Ubuntu 24.04 (mesma base do Ubuntu original).
FROM maven:3.9-eclipse-temurin-21-noble

# Evita que os pacotes do apt perguntem algo durante a instalação (build não interativo).
ENV DEBIAN_FRONTEND=noninteractive

# Instala as ferramentas que a base NÃO traz:
#   mysql-server-8.0 -> banco usado pela aplicação (versão fixada, sem surpresas)
#   git / git-lfs     -> versionamento de código
#   curl              -> testar a API (ex.: curl http://localhost:8080/produtos)
#   unzip / zip       -> descompactar arquivos baixados
# apt-get clean + rm  -> limpa o cache para a imagem ficar menor.
RUN apt-get update && apt-get install -y \
    mysql-server-8.0 \
    git \
    git-lfs \
    curl \
    unzip \
    zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

