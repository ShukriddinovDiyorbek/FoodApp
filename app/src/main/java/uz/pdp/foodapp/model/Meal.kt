package uz.pdp.foodapp.model

class Meal {
    var id: Int? = null
    var name: String? = null
    var product: String? = null
    var tarib: String? = null

    constructor(id:Int,name:String, product:String, tarib:String){
        this.id = id
        this.name = name
        this.product = product
        this.tarib = tarib
    }
    constructor(name:String, product:String, tarib:String){
        this.name = name
        this.product = product
        this.tarib = tarib
    }
}