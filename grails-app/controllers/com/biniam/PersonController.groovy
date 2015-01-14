package com.biniam

class PersonController {

  def index() {

    render "Hello"
  }

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
}
