Feature: Registration page

  Background:
    Given I am on the Registration page

    @Test1
  Scenario: Check Required fields
    When I click on Create Account button
    Then I should see following message on the Registration page
      | Field Name | Message                |
      | First Name | First Name is required |
    When I enter value "Daniel" on "First Name" field
    And I click on Create Account button
    Then I should see following message on the Registration page
      | Field Name | Message                |
      | Last Name  | Last name is required. |
      When I enter value "Zumei" on "Last Name" field
    And I click on Create Account button
    Then I should see following message on the Registration page
      | Field Name | Message                    |
      | Email      | Email address is required. |

  Scenario: Existing E-mail validation
    When I fill registration form using 1 row of the excel file
    And I click on Create Account button
    Then I should see following message on the Registration page
      | Field Name | Message                        |
      | Email      | User with email already exists |

  Scenario: Phone number validation
    When I fill registration form using 2 row of the excel file
    And I click on Create Account button
    Then I should see following message on the Registration page
      | Field Name   | Message                                               |
      | Phone Number | Phone Number should be in this (XXX) XXX-XXXX format. |

#  Scenario: Register new accounts using Excel
#    When I fill registration form using 1 row of the excel file
#    And I click on Create Account button
#    Then I should see "Confirm your email" message

    Scenario: Check links on the Registration page
      When I click on "Privacy Notice" link on the Registration page
      Then I should see a popup
      Then I close the popup
      When I click on "Terms and Conditions" link on the Registration page
      Then I should see a popup
      Then I close the popup
      When I click on "Contact Us" link on the Registration page
      Then I should see a popup
      Then I close the popup



