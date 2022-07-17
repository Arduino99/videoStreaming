# Video Streaming Service Coding Challenge for Glue Reply

• The Application has been developed in Java 11 and Spring Boot. 

-Before running the application, head to application.properties and change the username/password according to the mysql credentials setted on local machine. 
Please also check that the table name do not interact with any database schema already present, as upon creation any table with the same name will be dropped and 
recreated.

<img width="1178" alt="Screenshot 2022-07-17 at 23 28 22" src="https://user-images.githubusercontent.com/43646408/179427837-cfd02710-ff2f-4366-b261-24332d2535af.png">


-The application takes as input JSON payloads (you might need to specify depending the client you're using for testing) on the following endpoints:

•POST on /payments/add, with the following template

```
{
    "cardNumber" : "283847595949384",
    "amount" : "111"
}
```

•POST on users/add, with the following template

```
{
     "username": "arduino",
     "password": "@Rduin001",
     "email": "arduino@gmail.com",
     "dob" : "1999-02-22",
     "cardNumber" : "283847595949384"
}
```


You'll also find a three GET methods that to retrieve a list of all the users, a specific user by ID, and a list of all the transactions (alternatively 
you can look up on the Database tables that will be updated at every transaction)





