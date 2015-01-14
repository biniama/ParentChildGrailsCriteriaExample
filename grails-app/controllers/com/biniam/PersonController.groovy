package com.biniam

class PersonController {

  def index() {

    render "Hello"
  }

  def returnParents() {

      List<Parent> parents = Parent.createCriteria().list {
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


   /*   parents.each { parent ->

          println parent
          println parent.childs.childId

          println "Parent Name: " + parent.name
          parents.childs.each { child ->

              println "Parent Id: " + child.parent + " Child Id: " + child.childId + " Child Height: " + child.height + " Child gender: " + child.gender
          }
      }
      println "**************************"

      parents.childs.each { child ->

          println "Child Id: " + child.childId + " Child Height: " + child.height + " Child gender: " + child.gender
      }*/

      parents.childs.each { child ->

          println "Parent Id: " + child.parent.id + " Child Id: " + child.childId + " Child Height: " + child.height + " Child gender: " + child.gender
      }
  }
}
