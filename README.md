# ParentChildGrailsCriteriaExample
An example project that illustrates how to use a hibernate/Grails Criteria Query using a Parent -hasMany- Child example

This example is given for an answer to a StackOverflow.com question: http://stackoverflow.com/questions/27703377/grails-criteria-query-return-empty-result/27743852?noredirect=1#comment44193820_27743852

#####The logical 'or' tries to find the union between the two queries.

Project Grails Version:  Grails 2.3.0
IDE: Intellij 14.0.2

______________________________________________________________________________________________________________
Run the application and go to http://localhost:9562/ParentChild/person/returnParents
______________________________________________________________________________________________________________

______________________________________________________________________________________________________________
Models:
______________________________________________________________________________________________________________

package com.biniam
class Parent {

  String name

  static hasMany = [childs: Child]

  static constraints = {
  }
}


package com.biniam
class Child {

  Integer childId

  Integer gender

  Integer height

  static constraints = {
  }
}

______________________________________________________________________________________________________________
Sample Data: (Added in Bootstrap.groovy)

    'First Parent'
        childOne = childId: 1, gender: 1, height: 170
        childTwo = childId: 2, gender: 1, height: 175
        childFive = childId: 5, gender: 2, height: 160

    'Second Parent'
        childThree = childId: 3, gender: 1, height: 168
        childSix = childId: 6, gender: 2, height: 170

    'Third Parent'
        childFour = childId: 4, gender: 1, height: 159
        childSeven = childId: 7, gender: 2, height: 178
______________________________________________________________________________________________________________

______________________________________________________________________________________________________________
The Code:

def returnParents() {

      List<Parent> parents = Parent.createCriteria().listDistinct {
          and {
              childs {
                  or {
                      and {
                          eq("gender", 2)
                          ge("height", 150)
                      }
                      and {
                          eq("gender", 1)
                          le("height", 180)
                      }
                  }
              }
          }
      }

      println "The list of parents who have boys with height > 180 AND girls with height < 150"

      parents.each { parent ->

          println "Parent Name: " + parent.name
          println "Children"

          parent.childs.each { child ->

              println "Child Id: " + child.childId + " Child Height: " + child.height + " Child gender: " + child.gender
          }
      }
  }
______________________________________________________________________________________________________________

______________________________________________________________________________________________________________
Output: All Parents with all child will be returned because all children fulfill the criteria.
______________________________________________________________________________________________________________

The list of parents who have boys with height > 180 AND girls with height < 150   
Parent Name: First Parent   
Children   
Child Id: 1 Child Height: 170 Child gender: 1   
Child Id: 2 Child Height: 175 Child gender: 1   
Child Id: 5 Child Height: 160 Child gender: 2   
Parent Name: Second Parent   
Children   
Child Id: 3 Child Height: 168 Child gender: 1   
Child Id: 6 Child Height: 170 Child gender: 2   
Parent Name: Third Parent   
Children   
Child Id: 4 Child Height: 159 Child gender: 1   
Child Id: 7 Child Height: 178 Child gender: 2   
