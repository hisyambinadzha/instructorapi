# Instructor API Documentation

## Project Name
Instructor API

## Base URL
`http://localhost:8080/api/v1`

## Authentication Endpoints

### Register

**Endpoint:** `POST /api/auth/register`

**Request Body:**

```markdown
{
  "username": "admin",
  "password": "password123",
  "role": "ADMIN"
}
```

**Response:**

```markdown
{
  "message": "User registered successfully"
}
```

### Login

**Endpoint:** `POST /api/auth/login`

**Request Body:**

```markdown
{
  "username": "admin",
  "password": "password123"
}
```

**Response:**

```markdown
{
  "token": "jwt-token-here"
}
```

## Instructor CRUD Endpoints

### Get All Instructors

**Endpoint:** `GET /instructors`

**Response:**

```markdown
[
  {
    "id": "1",
    "name": "John Doe",
    "email": "john.doe@example.com",
    "specialization": "Java",
    "status": "ACTIVE",
    "yearsExperience": 5
  },
  ...
]
```

### Get Instructor by ID

**Endpoint:** `GET /instructors/{id}`

**Response:**

```markdown
{
  "id": "1",
  "name": "John Doe",
  "email": "john.doe@example.com",
  "specialization": "Java",
  "status": "ACTIVE",
  "yearsExperience": 5
}
```

### Create Instructor

**Endpoint:** `POST /instructors`

**Request Body:**

```markdown
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "specialization": "Java",
  "status": "ACTIVE",
  "yearsExperience": 5
}
```

**Response:**

```markdown
{
  "id": "1",
  "name": "John Doe",
  "email": "john.doe@example.com",
  "specialization": "Java",
  "status": "ACTIVE",
  "yearsExperience": 5
}
```

### Update Instructor

**Endpoint:** `PUT /instructors/{id}`

**Request Body:**

```markdown
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "specialization": "Java",
  "status": "ACTIVE",
  "yearsExperience": 5
}
```

**Response:**

```markdown
{
  "id": "1",
  "name": "John Doe",
  "email": "john.doe@example.com",
  "specialization": "Java",
  "status": "ACTIVE",
  "yearsExperience": 5
}
```

### Delete Instructor

**Endpoint:** `DELETE /instructors/{id}`

**Response:**

```markdown
{
  "message": "Instructor deleted successfully"
}
```

## Search Endpoint

**Endpoint:** `GET /instructors?specialization={specialization}&name={keyword}`

**Response:**

```markdown
[
  {
    "id": "1",
    "name": "John Doe",
    "email": "john.doe@example.com",
    "specialization": "Java",
    "status": "ACTIVE",
    "yearsExperience": 5
  },
  ...
]
```

## Pagination Endpoint

**Endpoint:** `GET /instructors/paged?page={page}&size={size}`

**Response:**

```markdown
{
  "content": [
    {
      "id": "1",
      "name": "John Doe",
      "email": "john.doe@example.com",
      "specialization": "Java",
      "status": "ACTIVE",
      "yearsExperience": 5
    },
    ...
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalElements": 100,
  "totalPages": 10,
  "last": false,
  "number": 1,
  "size": 10,
  "numberOfElements": 10,
  "sort": {
    "sorted": false,
    "unsorted": true
  },
  "first": true,
  "empty": false
}
```

## Security Requirement for Each Endpoint

| Endpoint               | Security Requirement |
|------------------------|----------------------|
| `POST /api/auth/register` | No authentication required |
| `POST /api/auth/login`  | No authentication required |
| `GET /instructors`       | No authentication required |
| `POST /instructors`       | Authentication required |
| `PUT /instructors`       | Authentication required |
| `DELETE /instructors`       | Authentication required |