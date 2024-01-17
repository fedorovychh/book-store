![Logo](https://github.com/fedorovychh/book-store/assets/137708693/1ae57ce8-ae96-4a31-aed6-28d88e0c7962)

📚 The "Book Store" project is an online platform for book enthusiasts. Users have the ability to browse a wide range of books across various genres, explore their descriptions, learn about authors, and discover prices.

The service offers a convenient search for books by categories to provide quick access to literary works. Each user can create a personal account, track purchase history. Adding books to the cart and completing orders is done easily and efficiently, providing customers with a convenient and secure way to purchase their selected literature.


## Tech Stack

🖥 Technologies that used to create an efficient and well-organized environment for the development and management of the Book Store.

**Backend:** Spring Framework (Spring Boot, Spring Security, Spring Data JPA), MySQL

**Database Migration:** Liquibase

**Containerization:** Docker

**API Documentation:** Swagger

**Testing:** JUnit, Mockito, Test Containers

**Build Tool:** Maven

## Features

### Authentication

🔑 Token-based authentication is implemented in the API. To access you are required to acquire a JSON Web Token (JWT) and include it in the Authorization header.

<details>
  <summary>Registration</summary>

* Endpoint ```/api/auth/register```
* HTTP Request: POST
* Request Body:
  ``` 
  {
    "email": "test.user@example.com",
    "password": "12345678",
    "repeatPassword": "12345678",
    "firstName": "Test",
    "lastName": "User",
    "shippingAddress": "123 Main St, City, Country"
  }
  ```
* Response: Status Code 200
* Response Body:
  ``` 
  {
    "id": 1,
    "email": "test.user@example.com",
    "firstName": "Test",
    "lastName": "User",
    "shippingAddress": "123 Main St, City, Country"
  }
  ```

</details>

<details>
  <summary>Login</summary>

* Endpoint ```/api/auth/login```
* HTTP Request: POST
* Request Body:
  ``` 
  {
      "email": "test.user@example.com",
      "password": "12345678"
  }
  ```
* Response: Status Code 200
* Response Body:
  ``` 
  {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
  }
  ```

</details>

### Books and Categories

<details>
  <summary>Available books</summary>

* Endpoint ```/api/books```
* HTTP Request: GET
* Response: Status Code 200
* Response Body:
  ```
  [
      {
          "id": 1,
          "title": "Test Book",
          "author": "Test Author",
          "isbn": "9783161484100",
          "price": 17.50,
          "description": "Description for test book",
          "coverImage": "https://www.example.com/images/book3.jpg",
          "categories": [1]
      },
      {
          "id": 2,
          "title": "Test Book 2",
          "author": "Test Author 2",
          "isbn": "9783161484101",
          "price": 21.00,
          "description": "Description for test book 2",
          "coverImage": "https://www.example.com/images/book3.jpg",
          "categories": [1]
      }
  ]
  ```

</details>

<details>
  <summary>Certain book</summary>

* Endpoint ```/api/books/1```
* HTTP Request: GET
* Response: Status Code 200
* Response Body:
  ```
  {
      "id": 1,
      "title": "Test Book",
      "author": "Test Author",
      "isbn": "9783161484100",
      "price": 17.50,
      "description": "Description for test book",
      "coverImage": "https://www.example.com/images/book3.jpg",
      "categories": [1]
  }
  ```

</details>

<details>
  <summary>Available categories</summary>

* Endpoint ```/api/categories```
* HTTP Request: GET
* Response: Status Code 200
* Response Body:
  ```
  [
      {
          "id": 1,
          "name": "Fantasy Adventure",
          "description": "Fantasy adventure books"
      },
      {
          "id": 2,
          "name": "Dystopian Fiction",
          "description": "Novels in a dystopian setting"
      },
      {
          "id": 3,
          "name": "Post-Apocalyptic Fiction",
          "description": "Post-apocalyptic novels"
      }
  ]
  ```

</details>

<details>
  <summary>Certain category</summary>

* Endpoint ```/api/categories/1```
* HTTP Request: GET
* Response: Status Code 200
* Response Body:
  ```
  {
      "id": 1,
      "name": "Fantasy Adventure",
      "description": "Fantasy adventure books"
  }
  ```

</details>

<details>
  <summary>Available books by category</summary>

* Endpoint ```/api/categories/1/books```
* HTTP Request: GET
* Response: Status Code 200
* Response Body:
  ```
  [
      {
          "id": 1,
          "title": "Test Book",
          "author": "Test Author",
          "isbn": "9783161484100",
          "price": 17.50,
          "description": "Description for test book",
          "coverImage": "https://www.example.com/images/book3.jpg",
          "categories": [1]
      }
  ]
  ```

</details>

### Shopping Cart

<details>
  <summary>Add book to shopping cart</summary>

* Endpoint ```/api/cart```
* HTTP Request: POST
* Request Body:
  ```
  {
    "bookId": "1",
    "quantity": "3"
  }
  ```
* Response Body:
  ```
  {
      "id": 1,
      "bookId": 1,
      "bookTitle": "Test Book",
      "quantity": 3
  }
  ```

</details>

<details>
  <summary>User's shopping cart</summary>

* Endpoint ```/api/cart```
* HTTP Request: GET
* Response: Status Code 200
* Response Body:
  ```
  [
      {
          "id": 1,
          "bookId": 1,
          "bookTitle": "Test Book",
          "quantity": 3
      }
  ]
  ```

</details>

<details>
  <summary>Update item in shopping cart</summary>

* Endpoint ```/api/cart/cart-items/1```
* HTTP Request: PUT
* Request Body:
  ```
  {
    "quantity": "2"
  }
  ```
* Response Body:
  ```
  {
      "id": 1,
      "bookId": 1,
      "bookTitle": "Test Book",
      "quantity": 2
  }
  ```

</details>

<details>
  <summary>Delete item from shopping cart</summary>

* Endpoint ```/api/cart/cart-items/1```
* HTTP Request: DELETE

</details>

### Orders

<details>
  <summary>Place an order</summary>

* Endpoint ```/api/orders```
* HTTP Request: POST
* Request Body:
  ```
  {
      "shippingAddress": "123 Main St, City, Country"
  }
  ```
* Response Body:
  ```
  {
      "id": 1,
      "userId": 1,
      "orderItems": [
          {
              "id": 1,
              "bookId": 1,
              "quantity": 3
          }
      ],
      "orderDate": "2024-01-07T12:02:51.316180965",
      "total": 52.50,
      "status": "PENDING"
  }
  ```

</details>

<details>
  <summary>Orders history</summary>

* Endpoint ```/api/orders```
* HTTP Request: GET
* Response Body:
  ```
  [
      {
          "id": 1,
          "userId": 1,
          "orderItems": [
              {
                  "id": 1,
                  "bookId": 1,
                  "quantity": 3
              }
          ],
          "orderDate": "2024-01-07T12:02:51.316180965",
          "total": 52.50,
          "status": "PENDING"
      }
  ]
  ```

</details>

<details>
  <summary>Certain order (returns all items from order)</summary>

* Endpoint ```/api/orders/1/items```
* HTTP Request: GET
* Response Body:
  ```
  [
        {
            "id": 1,
            "bookId": 1,
            "quantity": 3
        }
  ]
  ```

</details>

<details>
  <summary>Certain item from certain order</summary>

* Endpoint ```/api/orders/1/items/1```
* HTTP Request: GET
* Response Body:
  ```
  {
      "id": 1,
      "bookId": 1,
      "quantity": 3
  }
  ```

</details>

## For administrators 👨‍💻

### Books and categories

<details>
  <summary>Create new book</summary>

* Endpoint ```/api/books```
* HTTP Request: POST
* Request Body:
  ```
  {
        "title": "Test Book",
        "author": "Test Author",
        "isbn": "9783161484100",
        "price": 17.50,
        "description": "Description for test book",
        "coverImage": "https://www.example.com/images/book3.jpg",
        "categories": [1]
  }
  ```
* Response Body:
  ```
  {
      "id": 1,
      "title": "Test Book",
      "author": "Test Author",
      "isbn": "9783161484100",
      "price": 17.50,
      "description": "Description for test book",
      "coverImage": "https://www.example.com/images/book3.jpg",
      "categories": [1]
  }
  ```

</details>

<details>
  <summary>Update existing book</summary>

* Endpoint ```/api/books/1```
* HTTP Request: PUT
* Request Body:
  ```
  {
        "title": "Test Book",
        "author": "Test Author",
        "isbn": "9783161484100",
        "price": 27.50,
        "description": "Description for test book",
        "coverImage": "https://www.example.com/images/book3.jpg",
        "categories": [1]
  }
  ```
* Response Body:
  ```
  {
      "id": 1,
      "title": "Test Book",
      "author": "Test Author",
      "isbn": "9783161484100",
      "price": 27.50,
      "description": "Description for test book",
      "coverImage": "https://www.example.com/images/book3.jpg",
      "categories": [1]
  }
  ```

</details>

<details>
  <summary>Delete existing book</summary>

* Endpoint ```/api/books/1```
* HTTP Request: DELETE

</details>

<details>
  <summary>Create category</summary>

* Endpoint ```/api/categories```
* HTTP Request: POST
* Request Body:
  ```
  {
      "name": "Horror",
      "description": "Horror books"
  }
  ```
* Response Body:
  ```
  {
      "id": 4,
      "name": "Horror",
      "description": "Horror books"
  }
  ```

</details>

<details>
  <summary>Update existing category</summary>

* Endpoint ```/api/categories/1```
* HTTP Request: PUT
* Request Body:
  ```
  {
      "name": "Horror",
      "description": "Horror and not only books"
  }
  ```
* Response Body:
  ```
  {
      "id": 4,
      "name": "Horror",
      "description": "Horror and not only books"
  }
  ```

</details>


<details>
  <summary>Delete existing category</summary>

* Endpoint ```/api/categories/1```
* HTTP Request: DELETE

</details>

### Orders

<details>
  <summary>Update existing order</summary>


* Endpoint ```/api/orders/1```
* HTTP Request: PATCH
* Request Body:
  ```
  {
      "status": "CONFIRMED"
  }
  ```
* Response Body:
  ```
  [
      {
          "id": 1,
          "userId": 1,
          "orderItems": [
              {
                  "id": 1,
                  "bookId": 1,
                  "quantity": 3
              }
          ],
          "orderDate": "2024-01-07T12:02:51.316180965",
          "total": 52.50,
          "status": "CONFIRMED"
      }
  ]
  ```

</details>

## Inside the Book Store

The project is structured using Layered Architecture, providing a clear separation of concerns with distinct levels. Each level is responsible for specific aspects of functionality, ensuring a well-organized and modularized design.

1. **Controller Layer:**
   Responsible for handling HTTP requests and interacting with clients. Controllers contain logic to process requests and invoke corresponding services.

2. **Service Layer:**
   Implements the business logic of the application. Services interact with repositories and mappers for data processing and storage.

3. **Repository Layer:**
   Handles interactions with the database. Repositories are responsible for retrieving and storing data in accordance with the business logic.

4. **Security Layer:**
   Manages authentication and authorization, securing access to protected resources through role-based access control (e.g., USER and ADMIN roles).

5. **DTO (Data Transfer Object) Layer:**
   Contains objects used for data transfer between levels, optimizing data exchange and eliminating unnecessary information in responses.

6. **Mapper Layer:**
   Utilized for converting objects between entities and Data Transfer Objects (DTOs).

7. **Test:**
   Includes tests to verify the correctness of various parts of the application, including controllers, services, and repositories.

Entities include:
- **Book:** Represents a book with details such as title, author, and other characteristics.
- **Category:** Used for classifying books into categories.
- **Shopping Cart:** Contains information about items added to a user's shopping cart.
- **Cart Item:** Represents an item in the cart with a link to a specific book.
- **User:** Represents a user with account details and roles.
- **Role:** Defines user roles (e.g., USER and ADMIN).
- **Order:** Stores information about orders, including purchase details and other attributes.
- **Order Item:** Links books to a specific order and stores the quantity of purchased copies.

## Challenges And Solutions

During development, I faced with some problems and needed to solve it.

Initially, I utilized the H2 database for testing purposes. However, as the application expanded, the Liquibase scripts required more intricate modifications. This led to compatibility issues, as H2 doesn't fully support certain commands, such as adding constraints in separate scripts.

To circumvent these limitations, I implemented Docker within the project and transitioned to using MySQL for testing. This resolved the compatibility concerns and enabled me to execute the Liquibase scripts seamlessly.

## Possible Improvements

### Payment Integration:

**Checkout experience:** I'll be incorporating a payment system, likely utilizing the Stripe API, to enable secure and convenient online payments. This will allow users to effortlessly complete their orders and make purchases directly within the application.

**Enhanced revenue generation:** By providing a frictionless payment process, we can anticipate increased sales and revenue.

**Streamlined order management:** Integration with a payment gateway will also facilitate a more efficient order management process, simplifying financial tracking and reconciliation.

### Dynamic Book Filtering:

**Improved search capabilities:** I'm planning to implement a robust filtering system that empowers users to dynamically refine their book searches based on specific criteria. This could include genre, author, publication date, price range, or other relevant attributes.

**Personalized browsing experience:** By empowering users to tailor their search results, we can cater to their individual preferences and create a more engaging and fulfilling browsing experience.

**Enhanced discoverability:** Dynamic filtering will make it easier for users to discover books that align with their interests, potentially leading to increased engagement and sales.

These enhancements are strategically important to make a user experience better.

## How to run Book Store API
1. Install [Docker](https://www.docker.com/products/docker-desktop/)
2. Clone [current project](https://github.com/fedorovychh/book-store) repository
3. Configure a "**.env**" file with necessary environment variables:
    - change user
    - change password
4. Your spring.datasource url, username and password should match .env config
5. Run the command `mvn clean package`
6. Use `docker-compose build` to build Docker container
7. Use `docker-compose up` to run Docker container
8. Access the locally running application at http://localhost:8088/api
