import { Person } from './Person.js'
class Teacher extends Person {
    constructor(name, degree) {
        super(name)
        this.degree = degree
        document.writeln('child constructor invoked')
    }
    teach() {
        document.writeln('teach function invoked')
        document.writeln("degree :", this.degree)
    }
}