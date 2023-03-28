@TC01_Api
Feature: Room Creation

  Scenario: TC01_Post_Room
    Given user sends post request for room data
    #kullanıcı post room data icin request gonderir
    Then user gets the room data and assert
    #room datayı alır ve dogrular

