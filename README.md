# CloudGrade Spring Boot后端服务项目

本仓库为后端服务项目，基于 Java + Spring Boot 构建，提供 API 接口供前端调用。项目使用 Maven 管理依赖，构建完成后生成可运行的 JAR 包服务。部署时需使用 `.env` 文件配置数据库和服务相关参数。

## 环境配置

在项目根目录下创建 `.env` 文件，内容示例：

```
RDS_URL=jdbc:mysql://数据库IP:3306/数据库名
DB_USERNAME=数据库用户名
DB_PASSWORD=数据库密码
```

> 注意：请将示例中的数据库 IP、用户名、密码替换为实际值。

## 本地构建与部署

### 1. 清理旧的构建

```bash
mvn clean
```

### 2. 构建新的可运行 JAR 包

```bash
mvn package
```

### 3. 构建 JAR 包时跳过测试

```bash
mvn package -DskipTests
```

### 4. 启动服务

- 编写 `start.sh` 和 `stop.sh` 脚本来管理 JAR 包启动和停止。  
- 示例 `start.sh` 内容：

```bash
#!/bin/bash
# 启动服务
export $(cat .env | xargs)
java -jar target/后端服务.jar
```

- 示例 `stop.sh` 内容：

```bash
#!/bin/bash
# 停止服务
PID=$(ps -ef | grep 后端服务.jar | grep -v grep | awk '{print $2}')
if [ -n "$PID" ]; then
    kill -9 $PID
fi
```

### 5. Windows PowerShell 临时执行策略运行

```powershell
Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process
./start.ps1
```

## 注意事项

1. 确保 `.env` 文件中数据库配置正确。  
2. 构建 JAR 包前请先执行 `mvn clean`。  
3. `start.sh` 和 `stop.sh` 需有执行权限：

```bash
chmod +x start.sh
chmod +x stop.sh
```

4. 构建后的 JAR 包会存放在 `target` 文件夹下。
