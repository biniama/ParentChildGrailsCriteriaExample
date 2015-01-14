package com.biniam

class Child {
  Integer childId
  Integer gender
  Integer height

  static belongsTo = [parent : Parent]
  
  static constraints = {
  }
}
