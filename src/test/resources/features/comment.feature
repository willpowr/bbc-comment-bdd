Feature: News Article Comment
  AS A user
  I WANT to comment on a BBC article
  So THAT I can share my point of view about the article with other readers


  Background: A user views a commentable BBC article
    Given I am on a commentable page

  @sign_in_user
  Scenario Outline: A user signs in to comments
    When a user who is "<user_age>" signs in to work with comments
    Then a comment sign in status message "<message>" is shown
    Examples:
      | user_age   | message |
      | old_enough | You are signed in as|
      | too_young  | not the right age |



  @add_comment
  Scenario Outline: A user attempts to add comments
    Given a user old enough to comment is signed in
    When a user enters a comment "<comment>"
    Then a comment submission message "<message>" is shown

    Examples:
      | comment       | message                                            |
      | valid_comment | Thanks, your comment has been posted.              |
      |               | You need to write your comment before you post it. |
