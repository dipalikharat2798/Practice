export class Person {
    constructor(name) {
        document.writeln("parent consrtructor invoked")
        this.name = name
    }
    walk() {
        document.writeln("walk function invoked")
        document.writeln('name : ', this.name)
    }
}