🌐 **Selenium Automation Framework**
**(Cucumber + TestNG + Selenium WebDriver + Extent Reports + POM + Singleton Driver)**
📘 **Overview**

This repository contains a complete end-to-end UI automation framework built using modern test automation best practices.

**It demonstrates:**

BDD (Behavior-Driven Development) with Cucumber

Test orchestration with TestNG

Browser automation using Selenium WebDriver

One-browser execution using a Singleton DriverManager

Reusable Page Object Model (POM)

Advanced Extent Reports with screenshots

Clean, maintainable step definitions

This framework is designed to be:

✔ Scalable
✔ Maintainable
✔ Easy to debug
✔ CI/CD ready
✔ Multi-feature and multi-scenario friendly

📁 **Project Structure**
src
 ├── test
 │    ├── java
 │    │    ├── com.stepdefinition
 │    │    │    ├── steps.java                # All step definitions
 │    │    │    ├── steprunner.java           # TestNG + Cucumber runner
 │    │    │    ├── DriverManager.java        # Singleton WebDriver
 │    │    │    ├── ITestListenerClass.java   # Extent report + screenshots
 │    │    │
 │    │    ├── Pages
 │    │    │    ├── LoginPage.java            # POM page for login
 │    │    │
 │    │
 │    └── resources
 │         ├── function.feature               # Feature file with scenarios
 └──

🚀 **Key Features**

⭐ **1. Singleton WebDriver Instance**

Ensures:

Only one browser window is opened for the entire execution

Faster execution

Fewer flaky tests

No session conflicts

⭐ **2. Cucumber BDD**

Readable tests using Gherkin syntax:

Given User is on login page
When user enters <username> and <password>
Then user is able to login

⭐ **3. TestNG Runner**

Controls execution lifecycle

Start driver once (@BeforeSuite)

Quit driver once (@AfterSuite)

Integrates ITestListener for reporting

⭐ **4. Page Object Model (POM)**

Clean separation of locators + actions.

Example:
public void Sigin(){
    signinButton.click();
}
⭐ **5. Extent Reports**

auto-generated HTML report

screenshots attached for failed tests

dark theme and structured logs

⭐ 6. Cross-Browser Ready

Supports Chrome, Firefox, Edge when needed.

⚙️** Setup Instructions**
Prerequisites

Java 8+

Maven 3+

IntelliJ / Eclipse

Internet connection (for WebDriverManager)

🧩 **Automated Functionalities Covered**

This framework automates multiple functional flows on eBay, covering user login, product search, sorting, adding products to cart, verifying cart details, and navigating to the gift card page.
Below is a detailed breakdown of all scenarios implemented.

🔐 **1. User Login Functionality**

Automated Steps:

Open eBay homepage

Navigate to login page

Enter username

Enter password

Support for SMS/OTP fallback option

Validate successful login by checking displayed username

Validations Performed:

Login button presence

Correct username displayed after login

URL verification after login

**🔍 2. Search Functionality**

Automated Steps:

Enter search query (“Samsung Galaxy M21”)

Click the search button

Wait for results to load

Fetch all item titles from the results page

Print all product names to console

Validations Performed:

Search box visibility

Results page loaded successfully

Multiple product title elements detected

**🔽 3. Sorting Functionality (Best Match → Lowest Price)**

Automated Steps:

Click on the “Sort” dropdown

Choose a sort condition (e.g., Lowest Price)

Wait for the filtered results

Validations:

Sort dropdown presence

Selected sorting option highlighted

Sorted results displayed

**📱 4. Product Selection Functionality**

Automated Steps:

Iterate through products list

Identify product with text:
“Samsung Galaxy M21 2021 Edition-SM215G-4GB RAM 64GB”

Click product

Switch to newly opened tab

Validations:

Product name matching

New tab detected and switched successfully

Product detail page title printed

**🛒 5. Add to Cart Functionality**

Automated Steps:

Scroll to “Add to cart” button

Click the button

Validate cart update

Switch back to main window

Validations:

Add-to-cart button visibility

Cart updates

URL check for cart

**🧺 6. Cart Page Functionality**

Automated Steps:

Hover over cart icon

Extract items listed in minicart dropdown

Print item names to console

Click “Go to Cart”

Verify cart page URL contains /cart

Validations:

Cart is not empty

Minicart item list loaded

Cart page navigation successful

**🏡 7. Address Entry Functionality**

Automated Steps:

Enter Address Line 1

Enter City

Select State from dropdown

Enter ZIP code

Click Continue button

Validations:

All address fields visible

Dropdown selection working

Continue button functional

🎁 **8. Gift Card Page Navigation Functionality**

Automated Steps:

Click on “Gift Cards” link

Validate URL contains /giftcards

Scroll to “Birthday Gift Cards” section

Click “Birthday” category

Validations:

Gift cards page load

Birthday category clickable

Navigation to category successful

🧩 **Summary of All Automated Modules**

Functionality	Description	Status
Login	Email + Password + SMS login flow	✔ Completed
Product Search	Search for Samsung Galaxy M21	✔ Completed
Sorting	Apply Best Match or Lowest Price	✔ Completed
Product Selection	Identify specific model from results	✔ Completed
Add to Cart	Add item from product page	✔ Completed
Cart Features	View minicart, navigate to cart	✔ Completed
Address Form	Fill shipping information	✔ Completed
Gift Card	Visit gift card section & categories	✔ Completed
