import { Injectable } from '@angular/core';

@Injectable()
export class Constants{
    PRODUCT_SERVICES = {
        'GET_PRODUCTS_LIST' : 'service/productservice/getproducts',
        'GET_PRODUCT_DETAILS' : '/service/productservice/getproducts/',
        'ADD_PRODUCT' : '/service/productservice/addproduct' 
    }
}