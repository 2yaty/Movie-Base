
# MovieBase Application

## Overview
MovieHub is a web application that allows admins to search for movies using the OMDb API, add them to a local database, and manage the movie list. Regular users can browse, search, and rate movies stored in the database.

## Features
### **Admin Features**
- Login functionality.
- Search for movies via the OMDb API.
- Add or remove movies from the local database.
- Batch add/remove movies.

### **Regular User Features**
- Login functionality.
- View a list of movies added by the admin.
- Search for specific movies in the database.
- View detailed movie information.
- Rate movies.

### **Additional Features**
- Pagination for efficient browsing.
- Global exception handling.
- JWT-based authentication & authorization.

---

## Technologies Used
### **Frontend:**
- Angular 16+

### **Backend:**
- Spring Boot (Java 8+)
- PostgreSQL
- JWT Authentication
- OMDb API Integration

---

## Installation & Setup
### **1. Clone the Repository**
```sh
git clone https://github.com/2yaty/Movie-Base.git
cd Movie-Base
```

### **2. Backend Setup**
#### **Environment Variables**
Add the following:
```properties
DATABASE_URL=YOUR_DATABASE_URL_WITH_USERNAME_AND_PASSWORD_INCLUDED

omdb.api.key=YOUR_OMDB_API_KEY
```
#### **Build & Run Backend**
```sh
mvn clean install
mvn spring-boot:run
```

### **3. Frontend Setup**
```sh
cd frontend
npm install
ng serve
```

---

## API Endpoints
### **Auth Controller**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/login` | Login user & return JWT token |
| `POST` | `/api/auth/register` | Register a new user |

### **Movie Controller**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/movies` | Get all movies |
| `GET` | `/api/movies/{id}` | Get movie details |
| `POST` | `/api/movies` | Add a new movie (Admin only) |
| `DELETE` | `/api/movies/{id}` | Delete a movie (Admin only) |

### **OMDb Controller**
| Method | Endpoint                            | Description |
|--------|-------------------------------------|-------------|
| `GET` | `/api/omdb/search?title={title}`    | Search movies in OMDb API |
| `GET` | `/api/omdb/details?imdbId={imdbId}` | Get movie details from OMDb |
| `POST` | `/api/omdb/add`                     | Add a movie from OMDb to DB |

### **Rating Controller**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/ratings` | Rate a movie |
| `GET` | `/api/ratings/{movieId}` | Get ratings for a movie |

---

## Database Schema
### **Tables**
#### **User**
| Column | Type |
|---------|--------|
| id | UUID |
| username | String |
| password | String |
| role | ENUM (ADMIN, USER) |

#### **Movie**
| Column | Type |
|---------|--------|
| id | UUID |
| title | String |
| imdbId | String |
| year | Integer |
| genre | String |
| posterUrl | String |

#### **Rating**
| Column | Type               |
|---------|--------------------|
| id | UUID               |
| user_id | UUID (FK to User)  |
| movie_id | UUID (FK to Movie) |
| rating | Integer            |

---

## Future Enhancements
- User profiles with watchlists.
- More advanced filtering & sorting.
- Social features like comments & recommendations.

---

## License
This project is licensed under the MIT License.

