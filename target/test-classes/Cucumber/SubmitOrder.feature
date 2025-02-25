
@tag
Feature: Purchase the product from Ecommerce site
  I want to use this template for my feature file

	@Background	
	given I landed on the Page

  @tag2
  Scenario Outline: Submitting the order
    Given LogIn with <name>& <password>
    When Add The <productname> to cart
    And checkout <productname> and submit the product.
    Then "Thankyou for the order" display messege on page

    Examples: 
      | name                 | password        | productname  |
    	| sp5561719@gmail.com  | Sourabh@1432    | ZARA COAT 3   |
