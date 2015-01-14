package com.biniam

class Parent {

  String name

  static hasMany = [childs: Child]

  static constraints = {
  }
}
