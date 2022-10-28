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
The future improvement for this Shopping API will be to include testing and achieve over 90% coverage. I would also like to include more functionality such as topping up account balance and also creating entity relationships to the accounts and add an orders section.

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

The homepage is a login page where a user can login to their account or go to another page to register and create an account.

To create an account user must enter the following fields:
* Username
* Password
* First Name
* Last Name (This is not stored)
* Email

Data is then stored in MySQL database and the user is given the role "user" and an account balance of £100

The user can login if an account exists in the database and they will be taken to a normal user page or an admin page depending on if they have the role "user" or "admin"

<details>
<summary>User APIs</summary>

> -	 Welcome User Page (Account details are shown) with navigation bar to go to other links on the website whilst user is logged in
> -	 View Account Balance - User can view there account balance
> -  Buy Products - The user can buy from the shop which displays all the items in the shop and the prices and stock count. If they purchase any item, their account balance will be reduced, the stock count of the item purchased will reduce, and a message is displayed to confirm their purchase of said item.
> -	Change Account Details - The user can go to this page to change the details of their account. They can change the following: Password, First Name, and Email. If they successfully update they will be prompted that details have been updated and can continue navigating on the site.
> -	Delete Account- The user can delete there account but they must confirm the current password on their account and if it is incorrect then user will recieve a "Incorrect password" messsage. If the user enters the correct password, their account will be deleted and they will be directed back to the login page
> - Logout - When the user clicks logout the session is invalidated (session stores logged in user) and they will be redirected to the login page. They will no longer be able to access any of the links above.
</details>

<details>
<summary> Admin APIs </summary>
> -	 Welcome Admin Page (Account details are shown) with navigation bar to go to other links on the website whilst admin is logged in
> -	 Replenish Stock - If admin accesses this api they will be able to view the current products in the shop and will be able to update the stock count of any of the items by clicking add stock which will add 1 to the stock count of the item and the page will be updated to show the new stock count. They will be prompted of a message to confirm which items stock count has been updated. 
> - View Users - On this admin api the admin can view all the users present on the database and change the roles of the a user from "user" to "admin" or vice versa. They will be prompted which user's role has been changed.
> -	Add products - This API displays the shop and all the products in the shop with the product details. The admin can add an item to the shop by inserting data of productID,uniCount,Price, and product name in the fields and click the add product button. This will add the product to the database and the page will be refreshed to show the shop with the new product added.
> - Logout - When the user clicks logout the session is invalidated (session stores logged in user) and they will be redirected to the login page. They will no longer be able to access any of the links above.
</details>
## Screenshots: POSTMAN requests and utput from the API and MySQL database
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
    
  <summary> Admin Updating user roles </summary>
   
  > View all users Page Before - GET method
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/ViewingAllUsers(admin).png?raw=true)
    
  > Changning user roles - POST method
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/ChangingRoles.png?raw=true)
  
   > MySQL after user role changed
    
  ![](https://github.com/AliG-123/MyProjectShoppingApp/blob/main/Final%20Project%20Shopping%20App/MySQLRoleUpdated.png?raw=true)
  
  </details>
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





