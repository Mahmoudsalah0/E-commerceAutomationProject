@smoke
Feature: F07_FollowUs | users could open followUs links

  Background: user login first

    When      user navigate to login page
    And       user login with "salahmento@gmail.com" and "Aa123456"
    Then      user press on login button
    And       user login to the system successfully


  Scenario: user opens facebook link

    When    user open Facebook link
    Then    is opened in new tab "https://www.facebook.com/nopCommerce"


  Scenario: user opens twitter link

    When    user open Twitter link
    Then    is opened in new tab "https://twitter.com/nopCommerce"


  Scenario: user opens rss link

    When    user open RSS link
    Then    is opened in new tab "https://demo.nopcommerce.com/new-online-store-is-open"


  Scenario: user opens youtube link

    When    user open Youtube link
    Then    is opened in new tab "https://www.youtube.com/user/nopCommerce"