package de.schmitzekater

class PersonController {
    static scaffold = Person
    def index() { }

    def home(){
        render"<h1> Hier k�nnte ihre Person stehen</h1>"
    }
}
