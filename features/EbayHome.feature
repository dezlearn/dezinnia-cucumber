Feature: Ebay Home Page Scenarios

  @P1 @P2
  Scenario: Advanced Search Link
    Given I am on Eaby Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @P1 @setCookies @Test
  Scenario: Seach items count
    Given I am on Eaby Home Page
    When I serach for 'iPhone 11'
    Then I validate atleast 1000 search items present

  @P24 @setCookies
  Scenario: Seach items count2
    Given I am on Eaby Home Page
    When I serach for 'Toy Cars'
    Then I validate atleast 100 search items present

  @P240 @setCookies
  Scenario: Search an item in category
    Given I am on Eaby Home Page
    When I serach for 'soap' in 'BaBy' category
    Then I validate atleast 50 search items present

	@P500
  Scenario Outline: Home page links
    Given I am on Eaby Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples: 
      | link    | url                                                            | title       |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | eBay Motors |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                   | Fashion     |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys        |
