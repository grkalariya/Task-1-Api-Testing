# Task-3 Best Buy Api Playground Testing using REST Assured
This doucment explains the testing approch used, software dependancy, setup and steps to understand and run the tests easily.

## Testing Approch
During this Api testing task, *BDD (Business Driven Development)* testing approch has been used to ensure quick test understadning and easy maintenance. In this task, I have automated products, stores, services and categories apis for Best Buy Api Playground, with help of Java, REST Assured, TestNG, Maven, etc. software and libraries. 

## Software & Other Library Dependancy
* Java
* Maven
* rest-assured
* testng
* json-schema-validator
* json-path
* xml-path
* java-hamcrest
* hamcrest-core
* hamcrest-library

**NOTE** - Also Best Buy API playground enviorment must needed to setup and running in localhost as explained here: [Guide](https://github.com/bestbuy/api-playground/#getting-started)

## Test Suit & Test Cases
* __restAssuredProductApiTests__  -  Testsuit of Products Api tests using REST Assured library
  * __Get_Products_Api_Tests__   -  Get products Api tests
    * testGetProductsList
    * testGetProductsListWithLimit
    * testGetProductsListWithSkip
    * testGetProductsListWithLimitAndSkip
  * __Get_Product_With_Id_Api_Tests__ - Get product with given Id Api tests
    * testGetProductWithIdApi
  * __Post_Products_Api_Tests__ - Post (Create new) product Api tests
    * testPostProductDataApi
  * __Delete_Products_Api_Tests__ - Delete existing product Api tests
    * testDeleteProductApi
  * __Patch_Product_With_Id_Api_Tests__ - Patch (Update) existting product Api tests
    * testUpdateProductWithIdApi
    
* __restAssuredStoreApiTests__  -  Testsuit of stores Api tests using REST Assured library
  * __Get_Stores_Api_Tests__   -  Get stores Api tests
    * testGetStoresList
    * testGetStoresListWithLimit
    * testGetStoresListWithSkip
    * testGetStoresListWithLimitAndSkip
  * __Get_Store_With_Id_Api_Tests__ - Get store with given Id Api tests
    * testGetStoreWithIdApi
  * __Post_Stores_Api_Tests__ - Post (Create new) store Api tests
    * testPostStoreDataApi
  * __Delete_Stores_Api_Tests__ - Delete existing store Api tests
    * testDeleteStoreApi
  * __Patch_Store_With_Id_Api_Tests__ - Patch (Update) existting store Api tests
    * testUpdateStoreWithIdApi
    
* __restAssuredServiceApiTests__  -  Testsuit of services Api tests using REST Assured library
  * __Get_Services_Api_Tests__   -  Get services Api tests
    * testGetServicesList
    * testGetServicesListWithLimit
    * testGetServicesListWithSkip
    * testGetServicesListWithLimitAndSkip
  * __Get_Service_With_Id_Api_Tests__ - Get service with given Id Api tests
    * testGetServiceWithIdApi
  * __Post_Services_Api_Tests__ - Post (Create new) service Api tests
    * testPostServiceDataApi
  * __Delete_Services_Api_Tests__ - Delete existing service Api tests
    * testDeleteServiceApi
  * __Patch_Service_With_Id_Api_Tests__ - Patch (Update) existting service Api tests
    * testUpdateServiceWithIdApi
    
* __restAssuredCategoryApiTests__  -  Testsuit of categories Api tests using REST Assured library
  * __Get_Categories_Api_Tests__   -  Get categories Api tests
    * testGetCategoriesList
    * testGetCategoriesListWithLimit
    * testGetCategoriesListWithSkip
    * testGetCategoriesListWithLimitAndSkip
  * __Get_Category_With_Id_Api_Tests__ - Get category with given Id Api tests
    * testGetCategoryWithIdApi
  * __Post_Categories_Api_Tests__ - Post (Create new) category Api tests
    * testPostCategoryDataApi
  * __Delete_Categories_Api_Tests__ - Delete existing category Api tests
    * testDeleteCategoryApi
  * __Patch_Category_With_Id_Api_Tests__ - Patch (Update) existting category Api tests
    * testUpdateCategoryWithIdApi
    
## Running Tests
In your IDE go to the project then, src > test > java
* __Run all tests under a Testsuit__ - Select a testsuit file (i.e. restAssuredProductApiTests), then right click > Run As > TestNG Test
* __Run a single test file under a Testsuit__ - Select a test file under a test suit (i.e. restAssuredServiceApiTests > Post_Services_Api_Tests), then right click > Run As > TestNG Test
