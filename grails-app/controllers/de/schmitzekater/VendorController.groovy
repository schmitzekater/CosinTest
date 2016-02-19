package de.schmitzekater

/**
 * @author Alexander Schmitz
 *
 * Controller to handle the Domain Class Vendor
 */
class VendorController {
    static scaffold = Vendor

    def index() {
        redirect action: 'list', params: params
    }

    /*
    tabular view of all Vendors
     */
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

    /*
    Detailed view of a Vendor
     */
    def detail() {
        def vendor = Vendor.findById(params.id)
        render view: "/layouts/detail", model: [vendor: vendor]
    }

    /*
    View for new Vendor
     */
    def create(){
        respond new Vendor()
    }

    /*
    Method to save a new Vendor
     */
    def save(){
        def address = new Address(params.address)
        address.save(failOnError: true)
        def vendor = new Vendor(params)
        vendor.address = address
        vendor.save()
        redirect action: "detail", id: vendor.id
    }
}
