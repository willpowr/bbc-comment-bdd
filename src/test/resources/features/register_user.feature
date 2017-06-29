# audience-member-register.feature
# Test page: http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0#comments
# Test user: beebuser99

Feature: User Registers BBC Account
  AS A user
  I WANT to be able to register a new account from a commentable page
  So THAT I can easily access comment submission features

  Background: A non-registered user views a BBC commentable article
    Given I am on a commentable page
    Then I click the Register link

  Scenario: A user registers a new BBC account
    When I register successfully as user who is "<user_age>"
    Then I am returned to the commentable page
    And I see a post comment box

