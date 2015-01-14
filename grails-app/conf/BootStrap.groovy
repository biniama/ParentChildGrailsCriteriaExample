import com.biniam.Child
import com.biniam.Parent

class BootStrap {

    def init = { servletContext ->

        Parent parentOne = new Parent(name: 'First Parent').save()

        Parent parentTwo = new Parent(name: 'Second Parent').save()

        Parent parentThree = new Parent(name: 'Third Parent').save()

        Child childOne = new Child(childId: 1, gender: 1, height: 170, parent: 1).save()

        Child childTwo = new Child(childId: 2, gender: 1, height: 175, parent: 1).save()

        Child childThree = new Child(childId: 3, gender: 1, height: 168, parent: 2).save()

        Child childFour = new Child(childId: 4, gender: 1, height: 159, parent: 3).save()

        Child childFive = new Child(childId: 5, gender: 2, height: 160, parent: 1).save()

        Child childSix = new Child(childId: 6, gender: 2, height: 170, parent: 2).save()

        Child childSeven = new Child(childId: 7, gender: 2, height: 178, parent: 3).save()

        parentOne.addToChilds(childOne).save()
        parentOne.addToChilds(childTwo).save()
        parentOne.addToChilds(childFive).save()

        parentTwo.addToChilds(childThree).save()
        parentTwo.addToChilds(childSix).save()

        parentThree.addToChilds(childFour).save()
        parentThree.addToChilds(childSeven).save()

        print "Bootstrapping is done."
    }
    def destroy = {
    }
}
