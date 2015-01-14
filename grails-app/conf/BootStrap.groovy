import com.biniam.Child
import com.biniam.Parent

class BootStrap {

    def init = { servletContext ->

        Child childOne = new Child(childId: 1, gender: 1, height: 170).save()

        Child childTwo = new Child(childId: 2, gender: 1, height: 175).save()

        Child childThree = new Child(childId: 3, gender: 1, height: 168).save()

        Child childFour = new Child(childId: 4, gender: 1, height: 159).save()

        Child childFive = new Child(childId: 5, gender: 2, height: 160).save()

        Child childSix = new Child(childId: 6, gender: 2, height: 170).save()

        Child childSeven = new Child(childId: 7, gender: 2, height: 178).save()

        Parent parentOne = new Parent(name: 'First Parent')
        parentOne.addToChilds(childOne).save()
        parentOne.addToChilds(childTwo).save()
        parentOne.addToChilds(childFive).save()

        Parent parentTwo = new Parent(name: 'Second Parent')
        parentTwo.addToChilds(childThree).save()
        parentTwo.addToChilds(childSix).save()

        Parent parentThree = new Parent(name: 'Third Parent')
        parentThree.addToChilds(childFour).save()
        parentThree.addToChilds(childSeven).save()

        print "Bootstrapping is done."
    }
    def destroy = {
    }
}
