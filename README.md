# MyProjectShoppingApp QA 

## Why are we doing this? 

This is the my final project(Shopping API) of QA Software Development Bootcamp where we are implementing our learnings during the 10 weeks training.  The project require us to create a working Spring Boot API. With this, we will be able to test our understanding in the following:

* Agile & Project Management (Git)

* Databases & Cloud Fundamentals (MySQL)

* Programming Fundamentals (Java)

* API Development (Spring Boot)

* API Calls using Postman

<details>
<summary>Project Requirements</summary>

> -	Code fully integrated into a Version Control System 
> -	A relational database, locally or within the Cloud, which is used to persist data for the project.
> -	A functional application ‘back-end’, written in a suitable framework of the language covered in training (Java/Spring Boot)
> -	A build (.jar) of your application, including any dependencies it might need, produced using an integrated build tool (Maven).
> -	A series of API calls designed with postman, used for CRUD functionality. (Create, Read, Update, Delete)
</details>

<details>
<summary> Tech Stack </summary>

- Version Control System: **Git**
- Source Code Management: **Github**
- Database Management System: **MySQL**
- Core Language: **Java**
- API Dev platform: **Spring**
- Build Tool: **Maven**
</details>

## How I expected the challenge to go.

## What went well? / What didn't go as planned?

## Possible improvements for future revisions of the project.

## Database
<details>
<summary> User Database Structure </summary>
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/UserDatabaseStructure.png?raw=true)
</details>
 
<details>
<summary> Product Database Structure </summary>
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/ProductDatabaseStructure.png?raw=true)
</details>
 
  
## Methods available in API
## Postman with ScreenShots
<details>
<summary> Create </summary>

<details>
  <summary> Registration </summary>
> Registration - Creates user if username doesn't exist in the database.
  
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanRegisterUser.png?raw=true) 
  
  > MYSQL database showing new user
  
 ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanMySQLBeforeUpdate.png?raw=true)
  
</details> 

  <details>
  
  <summary> Adding Products to Shop </summary>
   
  > Add Product Page
    
   ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/addproductpage.png?raw=true)
    
  > Adding Product
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanAddedProduct.png?raw=true)
    
  > MySQL showing product has been added
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/MySQLProductAdded.png?raw=true)
    
  </details>
</details>


<details>
<summary> Read </summary>
  
  >User Login to display data - POST method
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanLogin.png?raw=true)
  
  >View all users page when Admin has logged in- GET method
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanViewAllUsers.png?raw=true)
  

</details>

<details>
<summary> Update </summary>

<details>
  <summary> Updating User Details </summary>
>Update User Details Page (Only for logged in user) - GET Method
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/ChangeAccountDetailsPage.png?raw=true)

  
>MySQL before update
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanMySQLBeforeUpdate.png?raw=true)

>Change Details (Only for logged in user) - POST Method
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanAccountUpdated.png?raw=true)


>MySQL after update
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanMySQLAfterUpdate.png?raw=true)

  </details>
  
  <details>
  <summary> Shopping </summary>
>Shop Page (Only for logged in user) - GET Method
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanShopPage.png?raw=true)

  
>User purchasing item from shop - POST method
  
![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanShopping.png?raw=true)

  </details>
  
  <details>
    
  <summary> Admin Updating product stock </summary>
   
  > Stock Page Before - GET method
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/AddStockBefore.png?raw=true)
    
  > Stock Page After - POST method
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/AddStockAfter.png?raw=true)
  
  
  </details>
  
<details>
<summary> Delete </summary>
 
> Delete Account Page Before (Deletes only Logged IN users account)

![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanDeleteAccountPageBefore.png?raw=true) 
  
> Delete Account Wrong Credentials Entered

![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/PostmanDeleteAccountWrongPassword.png?raw=true)
  
> Delete Account corrent Credentials Entered
![](https://raw.githubusercontent.com/AliG-123/MyProjectShoppingApp/main/Final%20Project%20Shopping%20App/PostmanAccountDeleted.png) 
 

</details>


## Screenshots showing your postman requests and the output from the API.

## Screenshots of your database to prove that data is being persisted.


