Feature: Life cycle of user in social network

  Scenario: Life cycle of user in social network

    Given Age API will not confirm that user with name "Mad Max" is adult
    When anonymous user creates a user account in social network with name "Mad Max"
    Then user account not created because user's age is under 18

    Given Age API will confirm that user with name "Alex K" is adult
    When anonymous user creates a user account in social network with name "Alex K"
    Then user account successfully created

    Given Word API will not find swearing words in post
    When user creates a post with content "Hello world!"
    Then user has one post

    # Word API considers the word 'banana' as a swearing word :)
    Given Word API will find swearing words in post
    When user creates a post with content "Hello world, banana!!!"
    Then user has one post

    When user decides to delete their account
    Then social network does not have posts for user any more
    Then social network does not have user account any more