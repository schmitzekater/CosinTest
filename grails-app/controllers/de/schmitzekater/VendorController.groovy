package de.schmitzekater

class VendorController {
    static scaffold = Vendor

    def index() {
        redirect action: 'list', params: params
    }

    def list(){
        if (!params.max) params.max = 20
        if (!params.sort) params.sort = 'name'
        if (!params.order) params.order = 'asc'
        def vendors = Vendor.list(params)
        render view: '/layouts/list', model: [model: vendors, count: Vendor.count()]
    }

    def show(){
        redirect action: 'detail', params: params
    }

    def detail() {
        def vendor = Vendor.findById(params.id)
        render view: "/layouts/detail", model: [vendor: vendor]
    }

    def create(){
        respond new Vendor()
    }

    def save(){
        def address = new Address(params.address)
        address.save(failOnError: true)
        def vendor = new Vendor(name: params.name, url: params.url, address: address)
        vendor.save(failOnError: true)
        redirect action: "detail", id: vendor.id
    }
}
