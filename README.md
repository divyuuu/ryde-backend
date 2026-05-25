# Ryde Backend

REST API for **Ryde** — user accounts, JWT authentication, and ride data on PostgreSQL. Pairs with the [Ryde Frontend](https://github.com/divyuuu/ryde-frontend) React app.

## Tech stack

| | |
|---|---|
| Runtime | Java 21 |
| Framework | Spring Boot 4 |
| Data | Spring Data JPA, PostgreSQL |
| Security | Spring Security, JWT (jjwt), BCrypt |

## Features

- User signup and login with role (`DRIVER` or `PASSENGER`)
- JWT-protected endpoints
- CORS for `http://localhost:5173` (frontend dev server)

> **Status:** Auth and user lookup are implemented. Ride booking and driver/passenger services are in progress.

## Prerequisites

- **Java 21**
- **Maven** (or `./mvnw` / `mvnw.cmd`)
- **PostgreSQL** with database `geolocation`

```sql
CREATE DATABASE geolocation;
```

## Environment variables

| Variable | Description |
|----------|-------------|
| `DB_USERNAME` | PostgreSQL username |
| `DB_PASSWORD` | PostgreSQL password |
| `JWT_SECRET` | Long random string for signing JWTs |

Do not commit real secrets. Use IDE env, shell exports, or a local file you gitignore.

`application.properties` uses `jdbc:postgresql://localhost:5432/geolocation` and `ddl-auto=update`.

## Run locally

From the **ryde-backend** repository root:

```bash
git clone https://github.com/divyuuu/ryde-backend.git
cd ryde-backend
```

**Windows (PowerShell):**

```powershell
$env:DB_USERNAME="your_user"
$env:DB_PASSWORD="your_password"
$env:JWT_SECRET="your_secret_key"
.\mvnw.cmd spring-boot:run
```

**macOS / Linux:**

```bash
export DB_USERNAME=your_user
export DB_PASSWORD=your_password
export JWT_SECRET=your_secret_key
./mvnw spring-boot:run
```

API base: **http://localhost:8080**

## API overview

### Public

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/auth/signup` | Create account |
| `POST` | `/api/auth/login` | Login → JWT + user |

### Protected (`Authorization: Bearer <token>`)

| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/api/users/{uuid}` | User profile |

### In development

| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/api/rides` | Ride booking (stub) |

### Example: login

```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "yourpassword"
}
```

## Screenshots (optional)

Store under `docs/screenshots/` in **this** repo if you want API docs visuals:

| File | Content |
|------|---------|
| `api-running.png` | Terminal showing Spring Boot started on 8080 |
| `api-login-postman.png` | Successful login in Postman or Insomnia |

```markdown
![Login API](docs/screenshots/api-login-postman.png)
```

## Tests

```bash
./mvnw test
```

## Related repository

| Repo | Link |
|------|------|
| **ryde-backend** (this repo) | https://github.com/divyuuu/ryde-backend |
| **ryde-frontend** | https://github.com/divyuuu/ryde-frontend |

## License

All rights owned by @divyuuu
